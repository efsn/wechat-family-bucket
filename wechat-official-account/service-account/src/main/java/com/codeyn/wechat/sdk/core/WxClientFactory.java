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
package com.codeyn.wechat.sdk.core;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codeyn.wechat.sdk.core.model.WxBase;

/**
 * @author Arthur
 */
public class WxClientFactory {

    private static Logger logger = LoggerFactory.getLogger(WxClientFactory.class);

    private static int GLOBAL_CONNECT_TIMEOUT = 1000;

    private static int GLOBAL_READ_TIMEOUT = 5000;

    public static <T extends WxClient> T getClient(Class<T> clazz, WxBase wxBase) {
        try {
            Constructor<T> constructor = clazz.getConstructor(WxBase.class);
            return constructor.newInstance(wxBase);
        } catch (Exception e) {
            logger.error("Class name: " + clazz.getName(), e);
        }
        return null;
    }

    /**
     * 设置全局连接超时时间
     */
    public static void setGlobalConnectTimeOut(int connectTimeOut) {
        GLOBAL_CONNECT_TIMEOUT = connectTimeOut;
    }

    /**
     * 设置全局等待响应超时时间
     */
    public static void setGlobalReadTimeout(int readTimeout) {
        GLOBAL_READ_TIMEOUT = readTimeout;
    }

    public static int getGlobalConnectTimeOut() {
        return GLOBAL_CONNECT_TIMEOUT;
    }

    public static int getGlobalReadTimeout() {
        return GLOBAL_READ_TIMEOUT;
    }

}
