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
package com.codeyn.wechat.sdk.user;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.codeyn.wechat.sdk.core.WxClient;
import com.codeyn.wechat.sdk.core.model.WxBase;
import com.codeyn.wechat.sdk.core.model.WxResult;
import com.codeyn.wechat.sdk.user.enums.LangType;
import com.codeyn.wechat.sdk.user.result.UserInfoList;
import com.codeyn.wechat.sdk.user.result.WxFollowUser;
import com.codeyn.wechat.sdk.user.result.WxUser;

/**
 * 微信用户管理
 * 
 * @author Arthur
 */
public class UserClient extends WxClient {

    public UserClient(WxBase wxBase) {
        super(wxBase);
    }

    /**
     * 获取用户基本信息
     */
    public WxUser getUserInfo(final String accessToken, final String openId, final LangType language) {
        return doGet(WxUser.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                map.put("access_token", accessToken);
                map.put("openid", openId);
                map.put("lang", language.getFlag());
            }

        }, "/cgi-bin/user/info");
    }

    /**
     * 批量获取用户基本信息
     */
    public UserInfoList getUserInfos(String accessToken, final LangType language, final String... openIds) {
        return doPost(UserInfoList.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject userList = new JSONObject();
                JSONArray arr = new JSONArray();
                if (openIds != null) {
                    for (String openId : openIds) {
                        JSONObject json = new JSONObject();
                        json.put("openid", openId);
                        json.put("lang", language.getFlag());
                        arr.add(json);
                    }
                }
                userList.put("user_list", arr);
                map.put(KEY, userList.toJSONString());
            }

        }, "/cgi-bin/user/info/batchget?access_token=" + accessToken);
    }

    /**
     * 设置备注名
     */
    public WxResult updateRemark(String accessToken, final String openId, final String remark) {
        return doPost(WxResult.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                json.put("openid", openId);
                json.put("remark", remark);
                map.put(KEY, json.toJSONString());
            }

        }, "/cgi-bin/user/info/updateremark?access_token=" + accessToken);
    }

    /**
     * 获取关注用户列表
     * 
     * @param nextOpenId 第一个拉取的OPENID，不填默认从头开始拉取
     */
    public WxFollowUser getUserInfo(final String accessToken, final String nextOpenId) {
        return doGet(WxFollowUser.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                map.put("access_token", accessToken);
                if (StringUtils.isNotBlank(nextOpenId)) {
                    map.put("next_openid", nextOpenId);
                }
            }

        }, "/cgi-bin/user/get");
    }

}
