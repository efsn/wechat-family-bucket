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
 * 事件推送类型
 * 
 * @author Arthur
 *
 */
public enum EventType {
    
    /**
     * 客服
     */
    KF_CREATE_SESSION("kf_create_session", "接入会话"),
    KF_CLOSE_SESSION("kf_close_session", "关闭会话"),
    KF_SWITCH_SESSION("kf_switch_session", "转接会话"),
    
    /**
     * 关注
     */
    SUBSCRIBE("subscribe", "关注"),
    UNSUBSCRIBE("unsubscribe", "取消关注"),
    
    /**
     * 上报地理位置
     */
    LOCATION("LOCATION", "上报地理位置"),
    
    /**
     * 群发
     */
    MASSSENDJOBFINISH("MASSSENDJOBFINISH", "群发"),
    
    /**
     * 菜单点击
     */
    CLICK("CLICK", "菜单拉取消息"),
    VIEW("VIEW", "菜单跳转链接"),
    
    /**
     * 扫描带参数二维码
     */
    SCAN("SCAN", "扫描带参数二维码"),
    
    /**
     * 模版消息发送状态
     */
    TEMPLATESENDJOBFINISH("TEMPLATESENDJOBFINISH", "模版消息发送状态");
    
    private EventType(String flag, String title) {
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

    public static EventType get(String flag) {
        for (EventType type : EventType.values()) {
            if (type.flag.equals(flag)) {
                return type;
            }
        }
        return null;
    }
    
}
