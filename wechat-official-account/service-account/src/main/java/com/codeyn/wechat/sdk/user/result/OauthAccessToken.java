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
package com.codeyn.wechat.sdk.user.result;

import com.codeyn.wechat.sdk.certificate.result.AccessToken;

/**
 * @author Arthur
 */
public class OauthAccessToken extends AccessToken {

    private String openid;

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
     */
    private String unionid;
    private String refresh_token;

    /**
     * 用户授权的作用域，使用逗号','分隔 snsapi_base: 不弹出授权页面，直接跳转，只能获取用户openid
     * snsapi_userinfo:弹出授权页面，获取用户信息
     */
    private String scope;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public String getBaseScope() {
        return scope.indexOf("snsapi_base") > -1 ? "snsapi_base" : null;
    }

    public String getUserInfoScope() {
        return scope.indexOf("snsapi_userinfo") > -1 ? "snsapi_userinfo" : null;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
