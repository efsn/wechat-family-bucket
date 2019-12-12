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
package com.codeyn.wechat.sdk.statistics.result;

import com.codeyn.wechat.sdk.statistics.enums.UserSource;

/**
 * User summary
 * 
 * @author Arthur
 *
 */
public class UserSummary extends Summary<UserSummary> {

    /**
     * 用户的渠道
     */
    private UserSource user_source;

    /**
     * 新增的用户数量
     */
    private Integer new_user;

    /**
     * 取消关注的用户数量
     */
    private Integer cancel_user;

    /**
     * 总用户量
     */
    private Integer cumulate_user;

    public UserSource getUser_source() {
        return user_source;
    }

    public void setUser_source(Integer user_source) {
        UserSource us = UserSource.get(user_source);
        this.user_source = us == null ? UserSource.OTHER : us;
    }

    public Integer getNew_user() {
        return new_user;
    }

    public void setNew_user(Integer new_user) {
        this.new_user = new_user;
    }

    public Integer getCancel_user() {
        return cancel_user;
    }

    public void setCancel_user(Integer cancel_user) {
        this.cancel_user = cancel_user;
    }

    public Integer getCumulate_user() {
        return cumulate_user;
    }

    public void setCumulate_user(Integer cumulate_user) {
        this.cumulate_user = cumulate_user;
    }

    /**
     * 净增用户数量
     */
    public Integer getNetIncrement() {
        return new_user - cancel_user;
    }

}
