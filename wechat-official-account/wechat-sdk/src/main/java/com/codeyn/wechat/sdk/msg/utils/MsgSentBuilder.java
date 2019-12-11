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

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codeyn.wechat.sdk.core.model.WxBase;
import com.codeyn.wechat.sdk.msg.enums.MsgType;
import com.codeyn.wechat.sdk.msg.model.receive.ReceivedMsg;
import com.codeyn.wechat.sdk.msg.model.send.ImageMsg;
import com.codeyn.wechat.sdk.msg.model.send.MusicMsg;
import com.codeyn.wechat.sdk.msg.model.send.NewsItem;
import com.codeyn.wechat.sdk.msg.model.send.NewsMsg;
import com.codeyn.wechat.sdk.msg.model.send.SentMsg;
import com.codeyn.wechat.sdk.msg.model.send.VideoMsg;
import com.codeyn.wechat.sdk.msg.model.send.VoiceMsg;

/**
 * 利用 Dom4j 动态生成 xml 内容
 * 
 * @author Arthur
 */
public class MsgSentBuilder {

    private static final Logger logger = LoggerFactory.getLogger(MsgSentBuilder.class);

    public static String build(SentMsg msg) {
        Document dd = DocumentHelper.createDocument();
        dd.setXMLEncoding(WxBase.ENCODING);
        Element root = dd.addElement("xml");
        Class<?> clazz = msg.getClass();
        Class<?> parent = clazz.getSuperclass();
        boolean isParent = SentMsg.class.equals(parent);

        if (isParent) {
            build(msg, root, parent, !isParent);
        }

        if (MsgType.NEWS.equals(MsgType.get(msg.getMsgType()))) {
            buildNews((NewsMsg) msg, root);
        } else {
            build(msg, root, clazz, isParent);
        }

        return root.asXML();
    }

    private static void build(SentMsg msg, Element root, Class<?> clazz, boolean isChild) {
        if (clazz != null) {
            root = isChild ? root.addElement(firstCharUpper(msg.getMsgType())) : root;
            for (Field f : clazz.getDeclaredFields()) {
                f.setAccessible(true);
                String name = firstCharUpper(f.getName());
                try {
                    Object x = f.get(msg);

                    if (x != null) {
                        Element e = root.addElement(name);
                        if (String.class.equals(f.getType())) {
                            e.addCDATA(x.toString());
                        } else {
                            e.addText(f.get(msg).toString());
                        }
                    }
                } catch (Exception e) {
                    logger.error("Msg xml build error: ", e);
                }
            }
        }
    }

    private static void buildNews(NewsMsg msg, Element root) {
        root.addElement("ArticleCount").setText(String.valueOf(msg.getArticleCount()));
        Element articles = root.addElement("Articles");
        for (NewsItem item : msg.getArticles()) {
            Element element = articles.addElement("item");
            for (Field f : NewsItem.class.getDeclaredFields()) {
                f.setAccessible(true);
                String name = firstCharUpper(f.getName());
                try {
                    Object x = f.get(item);
                    if (x != null) {
                        element.addElement(name).addCDATA(x.toString());
                    }
                } catch (Exception e) {
                    logger.error("News msg xml build error: ", e);
                }
            }
        }
    }

    public static String firstCharUpper(String str) {
        if (StringUtils.isNotBlank(str)) {
            return str.substring(0, 1).toUpperCase().concat(str.substring(1));
        }
        return str;
    }

    /**
     * 根据type获取需要发送的消息
     */
    public static SentMsg getSentMsg(ReceivedMsg inMsg, MsgType sentType) {
        switch (sentType) {
            case TEXT:
                return new SentMsg(inMsg);

            case IMAGE:
                return new ImageMsg(inMsg);

            case VOICE:
                return new VoiceMsg(inMsg);

            case VIDEO:
                return new VideoMsg(inMsg);

            case SHORT_VIDEO:
                return new VideoMsg(inMsg);

            case NEWS:
                return new NewsMsg(inMsg);

            case MUSIC:
                return new MusicMsg(inMsg);

            default:
                return null;
        }
    }

}
