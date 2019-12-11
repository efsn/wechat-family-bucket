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
package com.codeyn.wechat.sdk.statistics.enums;

/**
 * User source
 * 
 * @author Arthur
 *
 */
public enum UserSource {

    TIME_LINE(78, "朋友圈广告"),

    ARTICLE_AD(75, "公众号文章广告"),

    MPNEWS(57, "图文页内公众号名称"),

    PAYMENT(51, "支付后关注"),

    MPNEWS_UR(43, "图文页右上角菜单"),

    QRCODE(30, "扫描二维码"),

    BUSINESS_CARD(17, "名片分享"),

    SEARCH(1, "公众号搜索"),

    OTHER(0, "其他合计");

    private UserSource(Integer flag, String title) {
        this.flag = flag;
        this.title = title;
    }

    private Integer flag;
    private String title;

    public Integer getFlag() {
        return flag;
    }

    public String getTitle() {
        return title;
    }

    public static UserSource get(Integer flag) {
        for (UserSource type : UserSource.values()) {
            if (type.flag.equals(flag)) {
                return type;
            }
        }
        return null;
    }

}
