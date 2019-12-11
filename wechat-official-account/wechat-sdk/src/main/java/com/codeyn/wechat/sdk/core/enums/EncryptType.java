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
package com.codeyn.wechat.sdk.core.enums;

/**
 * 消息加密模式
 * 
 * @author Arthur
 */
public enum EncryptType {

    /**
     * 明文模式下，不使用消息体加解密功能，安全系数较低
     */
    DIRECT(0, "明文模式"),

    /**
     * 兼容模式下，明文、密文将共存，方便开发者调试和维护
     */
    MIX(-1, "混合模式"),

    /**
     * 安全模式下，消息包为纯密文，需要开发者加密和解密，安全系数高
     */
    SAFE(1, "安全模式");

    private EncryptType(Integer flag, String title) {
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

    public static EncryptType get(Integer flag) {
        for (EncryptType type : EncryptType.values()) {
            if (type.flag.equals(flag)) {
                return type;
            }
        }
        return null;
    }

}
