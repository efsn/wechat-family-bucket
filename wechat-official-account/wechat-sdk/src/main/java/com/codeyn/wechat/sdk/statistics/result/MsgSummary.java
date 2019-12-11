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

/**
 * Message summary
 * 
 * @author Arthur
 *
 */
public class MsgSummary extends Summary<MsgSummary> {

    /**
     * 消息类型 1文字 2图片 3语音 4视频 6链接消息
     */
    private Integer msg_type;

    /**
     * 向公众号发送消息的用户数
     */
    private Integer msg_user;

    /**
     * 向公众号发送的消息数
     */
    private Integer msg_count;

    /**
     * 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
     */
    private Integer count_interval;

    public Integer getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(Integer msg_type) {
        this.msg_type = msg_type;
    }

    public Integer getMsg_user() {
        return msg_user;
    }

    public void setMsg_user(Integer msg_user) {
        this.msg_user = msg_user;
    }

    public Integer getMsg_count() {
        return msg_count;
    }

    public void setMsg_count(Integer msg_count) {
        this.msg_count = msg_count;
    }

    public Integer getCount_interval() {
        return count_interval;
    }

    public void setCount_interval(Integer count_interval) {
        this.count_interval = count_interval;
    }

}
