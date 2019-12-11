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
package com.codeyn.wechat.sdk.msg;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.codeyn.wechat.sdk.core.WxClient;
import com.codeyn.wechat.sdk.core.model.WxBase;
import com.codeyn.wechat.sdk.msg.result.TemplateMsgResult;

/**
 * 模板消息
 * 
 * @author Arthur
 */
public class TemplateMsgClient extends WxClient {

    public TemplateMsgClient(WxBase wxBase) {
        super(wxBase);
    }

    /**
     * 发送模板消息
     */
    public TemplateMsgResult send(String accessToken, final String jsonStr) {
        return doPost(TemplateMsgResult.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                map.put(KEY, jsonStr);
            }

        }, "/cgi-bin/message/template/send?access_token=" + accessToken);
    }

    /**
     * 从模版库添加模版
     */
    public TemplateMsgResult apply(String accessToken, final String shortId) {
        return doPost(TemplateMsgResult.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                json.put("template_id_short", shortId);
                map.put(KEY, json.toJSONString());
            }

        }, "/cgi-bin/template/api_add_template?access_token=" + accessToken);
    }

    /**
     * 设置所属行业
     * 
     * @param id1 所属行业编号
     * @param id2 所属行业编号
     */
    public TemplateMsgResult setIndustry(String accessToken, final String id1, final String id2) {
        return doPost(TemplateMsgResult.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                json.put("industry_id1", id1);
                json.put("industry_id2", id2);
                map.put(KEY, json.toJSONString());
            }

        }, "/cgi-bin/template/api_set_industry?access_token=" + accessToken);
    }

}
