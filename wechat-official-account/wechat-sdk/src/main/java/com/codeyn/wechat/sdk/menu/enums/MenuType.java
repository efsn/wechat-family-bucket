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
package com.codeyn.wechat.sdk.menu.enums;

/**
 * 事件推送类型
 * 
 * @author Arthur
 *
 *
 */
public enum MenuType {

    CLICK("click", "点击推事件"),

    VIEW("view", "跳转URL"),

    /**
     * 以下3~8仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户
     */

    SCAN("scancode_push", "扫码推事件"),

    SCAN_MSG("scancode_waitmsg", "扫码推事件且弹出提示框"),

    PHONO("pic_sysphoto", "弹出系统拍照发图"),

    PHONO_ALBUM("pic_photo_or_album", "弹出拍照或者相册发图"),

    PIC_WX("pic_weixin", "弹出微信相册发图器"),

    LOCATION("location_select", "弹出地理位置选择器"),

    /**
     * 以下是专门给第三方平台旗下未微信认证的订阅号准备的事件类型， 它们是没有事件推送的，能力相对受限，其他类型的公众号不必使用。
     */

    /**
     * 下发消息（除文本消息）
     */
    MEDIA("media_id", "下发消息"),

    /**
     * 永久素材id对应的图文消息URL
     */
    VIEW_LIMITED("view_limited", "跳转图文消息URL");

    private MenuType(String flag, String title) {
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

    public static MenuType get(String flag) {
        for (MenuType type : MenuType.values()) {
            if (type.flag.equals(flag)) {
                return type;
            }
        }
        return null;
    }
}
