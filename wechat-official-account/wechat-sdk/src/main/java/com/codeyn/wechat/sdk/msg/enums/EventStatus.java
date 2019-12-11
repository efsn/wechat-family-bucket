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

public enum EventStatus {

    // 群发
    MASS_SUCCESS("send success", "成功"),
    MASS_FAIL("send fail", "失败"),
    
    MASS_ERR10001("err(10001)", "涉嫌广告"),
    MASS_ERR20001("err(20001)", "涉嫌政治"),
    MASS_ERR20002("err(20002)", "涉嫌色情"),
    MASS_ERR20004("err(20004)", "涉嫌社会"),
    MASS_ERR20006("err(20006)", "涉嫌违法犯罪"),
    MASS_ERR20008("err(20008)", "涉嫌欺诈"),
    MASS_ERR20013("err(20013)", "涉嫌版权"),
    MASS_ERR21000("err(21000)", "涉嫌其他"),
    MASS_ERR22000("err(22000)", "涉嫌互推(互相宣传)"),
    
    /**
     * 模版消息
     */
    TMP_SUCCESS("success", "成功"),
    TMP_BLOCK("block", "用户拒绝接收"),
    TMP_FAILED("failed: system failed", "发送失败（非用户拒绝）");
    
    private EventStatus(String flag, String title) {
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

    public static EventStatus get(String flag) {
        for (EventStatus type : EventStatus.values()) {
            if (type.flag.equals(flag)) {
                return type;
            }
        }
        return null;
    }
    
}
