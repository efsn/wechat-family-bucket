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
package com.codeyn.wechat.sdk.msg.result;

import java.util.List;

import com.codeyn.wechat.sdk.core.model.WxResult;

public class Kf extends WxResult {
    
    private List<Kf> kf_list;
    
    /**
     * 完整客服账号，格式为：账号前缀@公众号微信号
     */
    private String kf_account;
    
    /**
     * 客服昵称，最长6个汉字或12个英文字符
     */
    private String kf_nick;
    
    private String kf_id;
    
    private String kf_headimgurl;
    
    /**
     * 客服账号登录密码，格式为密码明文的32位加密MD5值
     */
    private String password;

    public void setKf_list(List<Kf> kf_list) {
        this.kf_list = kf_list;
    }

    public void setKf_account(String kf_account) {
        this.kf_account = kf_account;
    }

    public void setKf_nick(String kf_nick) {
        this.kf_nick = kf_nick;
    }

    public void setKf_id(String kf_id) {
        this.kf_id = kf_id;
    }

    public void setKf_headimgurl(String kf_headimgurl) {
        this.kf_headimgurl = kf_headimgurl;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Kf> getKf_list() {
        return kf_list;
    }

    public String getKf_account() {
        return kf_account;
    }

    public String getKf_nick() {
        return kf_nick;
    }

    public String getKf_id() {
        return kf_id;
    }

    public String getKf_headimgurl() {
        return kf_headimgurl;
    }

    public String getPassword() {
        return password;
    }
    
}
