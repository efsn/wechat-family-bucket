/**
 * Copyright (c) 2016 Arthur Chan 陈 (codeyn@163.com).
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the “Software”), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package com.codeyn.wechat.sdk.msg.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.codeyn.wechat.sdk.core.model.WxBase;
import com.codeyn.wechat.sdk.msg.enums.MsgType;
import com.codeyn.wechat.sdk.msg.model.receive.EventMsg;
import com.codeyn.wechat.sdk.msg.model.receive.NormalMsg;
import com.codeyn.wechat.sdk.msg.model.receive.ReceivedMsg;

public class MsgReceivedParser {

    private static final Logger logger = LoggerFactory.getLogger(MsgReceivedParser.class);

    /**
     * 消息类型 1：text 文本消息 2：image 图片消息 3：voice 语音消息 4：video 视频消息 shortvideo 小视频消息
     * 5：location 地址位置消息 6：link 链接消息 7：event 事件
     */
    public static ReceivedMsg parseMsg(String xml) {
        try {
            Document doc = DocumentHelper.parseText(xml);
            doc.setXMLEncoding(WxBase.ENCODING);
            Element root = doc.getRootElement();
            ReceivedMsg inMsg = null;
            Class<?> clazz = null;
            if (MsgType.EVENT.getFlag().equals(root.elementText("MsgType"))) {
                inMsg = new EventMsg();
                clazz = EventMsg.class;
            } else {
                inMsg = new NormalMsg();
                clazz = NormalMsg.class;
            }
            parse(root, inMsg, clazz);
            return inMsg;
        } catch (DocumentException e) {
            logger.error("Msg received parse xml error: ", e);
        }
        return null;
    }

    private static void parse(Element root, ReceivedMsg inMsg, Class<?> clazz) {
        try {
            Method[] methods = clazz.getMethods();
            List<String> list = new ArrayList<>();
            for (Method m : methods) {
                list.add(m.getName());
            }

            for (Object obj : root.elements()) {
                Element e = (Element) obj;
                if (e.isTextOnly()) {
                    String name = MsgSentBuilder.firstCharUpper(e.getName());
                    Method method = null;

                    // 特殊处理非String类型的Field
                    if ("Scale".equals(name)) {
                        method = clazz.getMethod("set" + name, Integer.class);
                        method.invoke(inMsg, Integer.parseInt(e.getText()));
                    } else if ("MsgId".equalsIgnoreCase(name) || name.indexOf("Time") > -1) {
                        method = clazz.getMethod("set" + name, Long.class);
                        method.invoke(inMsg, Long.parseLong(e.getText()));
                    } else if (name.indexOf("Location") > -1) {
                        method = clazz.getMethod("set" + name, Double.class);
                        method.invoke(inMsg, Double.parseDouble(e.getText()));
                    } else {
                        String mName = "set" + name;
                        if (list.contains(mName)) {
                            method = clazz.getMethod(mName, String.class);
                            method.invoke(inMsg, e.getText());
                        }
                    }
                    if (method != null) {
                        logger.info("Receive msg method: " + method.getName());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Msg received parse xml error: ", e);
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws DocumentException {
        String xml = "<xml>\n" + "<ToUserName><![CDATA[James]]></ToUserName>\n"
                + "<FromUserName><![CDATA[JFinal]]></FromUserName>\n" + "<CreateTime>1348831860</CreateTime>\n"
                + "<MsgType><![CDATA[event]]></MsgType>\n" + "<Event><![CDATA[CLICK]]></Event>"
                + "<EventKey><![CDATA[EVENTKEY]]></EventKey>" + "</xml>";

        // InTextMsg msg = (InTextMsg)parse(xml);
        // System.out.println(msg.getToUserName());
        // System.out.println(msg.getFromUserName());
        // System.out.println(msg.getContent());

        String xml_2 = "<xml>\n" + "<ToUserName><![CDATA[James]]></ToUserName>\n"
                + "<FromUserName><![CDATA[JFinal]]></FromUserName>\n" + "<CreateTime>1348831860</CreateTime>\n"
                + "<MsgType><![CDATA[text]]></MsgType>\n" + "<Content><![CDATA[this is a test]]></Content>\n"
                + "<MsgId>1234567890123456</MsgId>\n" + "</xml>";

        ReceivedMsg msg = parseMsg(xml);
        System.out.println(JSON.toJSONString(msg));
    }
    
}
