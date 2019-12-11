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

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.codeyn.wechat.sdk.core.WxClient;
import com.codeyn.wechat.sdk.core.model.WxBase;
import com.codeyn.wechat.sdk.core.model.WxResult;
import com.codeyn.wechat.sdk.user.result.WxUserGroup;

/**
 * 微信用户分组管理
 * 
 * @author Arthur
 */
public class UserGroupClient extends WxClient {

    public UserGroupClient(WxBase wxBase) {
        super(wxBase);
    }

    /**
     * 创建分组
     */
    public WxUserGroup createGroup(String accessToken, final String name) {
        return doPost("group", WxUserGroup.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                JSONObject group = new JSONObject();
                group.put("name", name);
                json.put("group", group);
                map.put(KEY, json.toJSONString());
            }

        }, "/cgi-bin/groups/create?access_token=" + accessToken);
    }

    /**
     * 查询所有分组
     */
    public WxUserGroup getUserInfos(final String accessToken) {
        return doGet(WxUserGroup.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                map.put("access_token", accessToken);
            }

        }, "/cgi-bin/groups/get");
    }

    /**
     * 查询用户所在分组
     */
    public WxUserGroup getGroupId(String accessToken, final String openId) {
        return doPost(WxUserGroup.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                json.put("openid", openId);
                map.put(KEY, json.toJSONString());
            }

        }, "/cgi-bin/groups/getid?access_token=" + accessToken);
    }

    /**
     * 修改分组名
     */
    public WxResult updateGroup(String accessToken, final Integer groupId, final String name) {
        return doPost(WxResult.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                JSONObject group = new JSONObject();
                group.put("id", groupId);
                group.put("name", name);
                json.put("group", group);
                map.put(KEY, json.toJSONString());
            }

        }, "/cgi-bin/groups/update?access_token=" + accessToken);
    }

    /**
     * 移动用户分组
     */
    public WxResult moveUser(String accessToken, final Integer toGroupId, final String openId) {
        return doPost(WxResult.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                json.put("to_groupid", toGroupId);
                json.put("openid", openId);
                map.put(KEY, json.toJSONString());
            }

        }, "/cgi-bin/groups/members/update?access_token=" + accessToken);
    }

    /**
     * 批量移动用户分组
     */
    public WxResult batchMoveUser(String accessToken, final Integer toGroupId, final List<String> openIds) {
        return doPost(WxResult.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                json.put("to_groupid", toGroupId);
                JSONArray list = new JSONArray();
                list.addAll(openIds);
                json.put("openid_list", list);
                map.put(KEY, json.toJSONString());
            }

        }, "/cgi-bin/groups/members/batchupdate?access_token=" + accessToken);
    }

    /**
     * 删除分组
     */
    public WxResult deleteGroup(String accessToken, final Integer groupId) {
        return doPost(WxResult.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                JSONObject group = new JSONObject();
                group.put("id", groupId);
                json.put("group", group);
                map.put(KEY, json.toJSONString());
            }

        }, "/cgi-bin/groups/delete?access_token=" + accessToken);
    }

}
