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
package com.codeyn.wechat.sdk.utils;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.codeyn.wechat.sdk.core.model.WxBase;
import com.codeyn.wechat.sdk.encrypt.WxBizMsgCrypt;

/**
 * 对微信平台官方给出的加密解析代码进行再次封装
 * 
 * 异常java.security.InvalidKeyException:illegal Key Size的解决方案：
 * 1：在官方网站下载JCE无限制权限策略文件（JDK7的下载地址：
 * http://www.oracle.com/technetwork/java/javase
 * /downloads/jce-7-download-432124.html
 * 2：下载后解压，可以看到local_policy.jar和US_export_policy.jar以及readme.txt
 * 3：如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security目录下覆盖原来的文件
 * 4：如果安装了JDK，将两个jar文件放到%JDK_HOME%\jre\lib\security目录下覆盖原来文件
 * 
 * 
 * 设置为消息加密模式后 JFinal Action Report 中有如下参数： timestamp=1417610658 encrypt_type=aes
 * nonce=132155339 msg_signature=8ed2a14146c924153743162ab2c0d28eaf30a323
 * signature=1a3fad9a528869b1a73faf4c8054b7eeda2463d3
 */
public class MsgEncryptUtil {

    private static final String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";

    public static String encrypt(WxBase wb, String msg, String timestamp, String nonce) {
        try {
            WxBizMsgCrypt pc = new WxBizMsgCrypt(wb.getToken(), wb.getEncodingAesKey(), wb.getAppId());
            return pc.encryptMsg(msg, timestamp, nonce);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static String decrypt(WxBase wb, String encryptedMsg, String timestamp, String nonce, String msgSignature) {
        try {
            Document document = DocumentHelper.parseText(encryptedMsg);
            Element root = document.getRootElement();
            List<Element> list = root.elements("Encrypt");
            String encrypt = list.get(0).getText();
            String fromXML = String.format(format, encrypt);
            String encodingAesKey = wb.getEncodingAesKey();
            if (encodingAesKey == null)
                throw new IllegalStateException("encodingAesKey can not be null, config encodingAesKey first.");

            WxBizMsgCrypt pc = new WxBizMsgCrypt(wb.getToken(), encodingAesKey, wb.getAppId());

            // 此处 timestamp 如果与加密前的不同则报签名不正确的异常
            return pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
