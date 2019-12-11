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
package com.codeyn.wechat.sdk.msg.enums;

/**
 * 消息类型
 * 
 * @author Arthur
 *
 */
public enum MsgType {

    /**
     * Blow is commons
     */
    TEXT("text", "文本消息"),

    IMAGE("image", "图片消息"),

    VOICE("voice", "语音消息"),

    VIDEO("video", "视频消息"),

    /**
     * Blow is receive msg
     */
    SHORT_VIDEO("shortvideo", "小视频消息"),

    LOCATION("location", "地址位置消息"),

    LINK("link", "链接消息"),

    EVENT("event", "事件"),

    /**
     * Blow is send msg
     */
    NEWS("news", "高级图文"),

    MPNEWS("mpnews", "微信图文"),

    MUSIC("music", "音乐消息");

    private MsgType(String flag, String title) {
        this.flag = flag;
        this.title = title;
    }

    private String flag;
    private String title;

    public String getFlag() {
        return flag;
    }

    public String getTitle() {
        return title;
    }

    public static MsgType get(String flag) {
        for (MsgType type : MsgType.values()) {
            if (type.flag.equals(flag)) {
                return type;
            }
        }
        return null;
    }

}
