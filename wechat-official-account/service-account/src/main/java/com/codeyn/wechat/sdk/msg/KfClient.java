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
import com.codeyn.wechat.sdk.core.model.WxResult;
import com.codeyn.wechat.sdk.msg.enums.MsgType;
import com.codeyn.wechat.sdk.msg.result.Kf;

/**
 * 多客服功能</br> 
 * 必须先在公众平台官网为公众号设置微信号后才能使用该能力
 */
public class KfClient extends WxClient{
    
    public KfClient(WxBase wxBase) {
        super(wxBase);
    }

    public WxResult saveAccount(String accessToken, boolean isNew, final String account, final String name, final String pw){
        return doPost(WxResult.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                json.put("kf_account", account);
                json.put("nickname", name);
                json.put("password", pw);
                map.put(KEY, json.toJSONString());
            }
            
        }, (isNew ? "/customservice/kfaccount/add?access_token=" : "/customservice/kfaccount/update?access_token=") + accessToken);
    }
    
    /**
     * 删除客服帐号
     * 避免@被encoding
     */
    public WxResult deleteAccount(final String accessToken, String account){
        return doGet(WxResult.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("access_token", accessToken);
            }
            
        }, "/customservice/kfaccount/del?kf_account=" + account);
    }

    /**
     * 获取所有客服账号
     */
    public Kf getAccountList(boolean isOnline, final String accessToken) {
        return doGet(Kf.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("access_token", accessToken);
            }
            
        }, "/cgi-bin/customservice/" + (isOnline ? "getonlinekflist" : "getkflist"));
    }
    
    /**
     * 发送客服消息
     */
    public WxResult sendMsg(String accessToken, final String toUser, final MsgType type, final Map<String, Object> data){
        return doPost(WxResult.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                json.put("touser", toUser);
                json.put("msgtype", type.getFlag());
                
                JSONObject msg = new JSONObject();
                msg.putAll(data);
                json.put(type.getFlag(), msg);
                
                map.put(KEY, json.toJSONString());
            }
            
        }, "/cgi-bin/message/custom/send?access_token=" + accessToken);
    }
    
    
    /**
     * 获取客服聊天记录
     */
    public WxResult getChatRecords(String accessToken, final String json) {
        return doPost(WxResult.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put(KEY, json);
            }
            
        }, "/customservice/msgrecord/getrecord?access_token=" + accessToken);
    }
}
