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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.codeyn.wechat.sdk.core.model.WxBase;
import com.codeyn.wechat.sdk.core.model.WxResult;

/**
 * 
 * @author Arthur
 *
 */
public abstract class WxClient {

    protected static final String KEY = "post_data";

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private WxBase wxBase;

    private Integer connectTimeout;

    private Integer readTimeout;

    protected WxClient(WxBase wxBase) {
        this.wxBase = wxBase;
        setConnectTimeout(WxClientFactory.getGlobalConnectTimeOut());
        setReadTimeout(WxClientFactory.getGlobalReadTimeout());
    }

    protected WxClient(WxBase wxBase, Integer connectTimeout, Integer readTimeout) {
        this(wxBase);
        setConnectTimeout(connectTimeout);
        setReadTimeout(readTimeout);
    }

    /**
     * 用于特殊的链接
     */
    protected <T extends WxResult> T doService(Class<T> clazz, ParamService paramService, String url) {
        Map<String, String> map = new HashMap<>();
        paramService.init(map);
        String response = HttpUtil.get(connectTimeout, readTimeout, url, map);
        logger.debug(response);
        return StringUtils.isBlank(response) ? null : JSON.parseObject(response, clazz);
    }

    /**
     * 需要传access_token，避免死循环
     */
    protected <T extends WxResult> T doGet(Class<T> clazz, ParamService paramService, String url) {
        return doGet(null, clazz, paramService, url);
    }

    protected <T extends WxResult> T doGet(String key, Class<T> clazz, ParamService paramService, String url) {
        Map<String, String> map = new HashMap<>();
        paramService.init(map);
        String response = HttpUtil.get(connectTimeout, readTimeout, wxBase.getHost() + url, map);
        logger.debug(response);
        return StringUtils.isBlank(response) ? null : StringUtils.isBlank(key) ? JSON.parseObject(response, clazz)
                : JSON.parseObject(response).getObject(key, clazz);
    }

    protected File readFile(ParamService paramService, String url, String method) {
        Map<String, String> map = new HashMap<>();
        paramService.init(map);
        return HttpUtil.readFile(connectTimeout, readTimeout, wxBase.getHost() + url, map, method);
    }

    /**
     * POST just use for access_token with no_name_data
     * 
     * @param key
     *            clazz key in response json
     */
    protected <T extends WxResult> T doPost(Class<T> clazz, ParamService paramService, String url) {
        return doPost(null, clazz, paramService, url);
    }

    protected <T extends WxResult> T doPost(String key, Class<T> clazz, ParamService paramService, String url) {
        Map<String, String> map = new HashMap<>();
        paramService.init(map);
        String response = HttpUtil.post(connectTimeout, readTimeout, wxBase.getHost() + url, map.get(KEY));
        logger.debug(response);
        return StringUtils.isBlank(response) ? null : StringUtils.isBlank(key) ? JSON.parseObject(response, clazz)
                : JSON.parseObject(response).getObject(key, clazz);
    }

    public interface ParamService {
        void init(Map<String, String> map);
    }

    public WxBase getWxBase() {
        return wxBase;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

}
