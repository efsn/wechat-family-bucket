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

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Arthur
 */
public class SignatureCheckUtil {

    private static final Logger logger = LoggerFactory.getLogger(SignatureCheckUtil.class);

    /**
     * 检测签名
     */
    public static boolean checkSignature(String token, String signature, String timestamp, String nonce) {

        if (StringUtils.isBlank(signature) || StringUtils.isBlank(timestamp) || StringUtils.isBlank(nonce)) {
            logger.info("check signature failure");
            return false;
        }

        if (isSignature(token, signature, timestamp, nonce)) {
            return true;
        } else {
            StringBuffer sb = new StringBuffer("check signature failure: signature = ").append(signature)
                    .append(" timestamp = ").append(timestamp).append(" nonce = ").append(nonce);
            logger.error(sb.toString());
            return false;
        }

    }

    /**
     * 配置开发者中心微信服务器所需的 url 与 token true 为config server 请求，false 正式消息交互请求
     */
    public static String configServer(String token, String echostr, String signature, String timestamp, String nonce) {
        boolean isOk = checkSignature(token, signature, timestamp, nonce);
        return isOk ? echostr : null;
    }

    public static boolean isSignature(String token, String signature, String timestamp, String nonce) {
        String[] arr = { token, timestamp, nonce };
        Arrays.sort(arr);
        String tempStr = StringUtils.join(arr);
        tempStr = DigestUtils.sha1Hex(tempStr);
        return tempStr.equalsIgnoreCase(signature);
    }

    /**
     * 是否为开发者中心保存服务器配置的请求
     */
    public static boolean isConfigServerRequest(String echostr) {
        return StringUtils.isNotBlank(echostr);
    }

}
