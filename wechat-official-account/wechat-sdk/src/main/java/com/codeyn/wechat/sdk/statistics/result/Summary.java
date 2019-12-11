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

import java.util.List;

import com.codeyn.wechat.sdk.core.model.WxResult;

/**
 * 
 * @author Arthur
 *
 */
public abstract class Summary<S extends Summary<S>> extends WxResult {

    private List<S> list;

    /**
     * 数据日期 yyyy-MM-dd
     */
    private String ref_date;

    /**
     * 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
     */
    private String ref_hour;

    /**
     * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
     */
    private Integer ori_page_read_user;

    /**
     * 原文页的阅读次数
     */
    private Integer ori_page_read_count;

    public List<S> getList() {
        return list;
    }

    public void setList(List<S> list) {
        this.list = list;
    }

    public String getRef_date() {
        return ref_date;
    }

    public void setRef_date(String ref_date) {
        this.ref_date = ref_date;
    }

    public String getRef_hour() {
        return ref_hour;
    }

    public void setRef_hour(String ref_hour) {
        this.ref_hour = ref_hour;
    }

    public Integer getOri_page_read_user() {
        return ori_page_read_user;
    }

    public void setOri_page_read_user(Integer ori_page_read_user) {
        this.ori_page_read_user = ori_page_read_user;
    }

    public Integer getOri_page_read_count() {
        return ori_page_read_count;
    }

    public void setOri_page_read_count(Integer ori_page_read_count) {
        this.ori_page_read_count = ori_page_read_count;
    }

}
