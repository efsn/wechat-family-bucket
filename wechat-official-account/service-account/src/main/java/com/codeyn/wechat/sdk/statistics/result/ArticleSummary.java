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

import com.codeyn.wechat.sdk.statistics.enums.ShareScene;

/**
 * 图文群发每日数据
 * 
 * @author Arthur
 *
 */
public class ArticleSummary extends Summary<ArticleSummary> {

    /**
     * 这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成，
     * 例如12003_3， 其中12003是msgid，即一次群发的消息的id；
     * 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
     */
    private String msgid;

    /**
     * 统计的日期，在getarticletotal接口中，ref_date指的是文章群发出日期， 而stat_date是数据统计日期
     */
    private String stat_date;

    /**
     * 图文消息的标题
     */
    private String title;

    /**
     * 图文页（点击群发图文卡片进入的页面）的阅读人数
     */
    private Integer int_page_read_user;

    /**
     * 图文页的阅读次数
     */
    private Integer int_page_read_count;

    /**
     * 分享的场景
     */
    private ShareScene share_scene;

    /**
     * 分享的人数
     */
    private Integer share_user;

    /**
     * 分享的次数
     */
    private Integer share_count;

    /**
     * 收藏的人数
     */
    private Integer add_to_fav_user;

    /**
     * 收藏的次数
     */
    private Integer add_to_fav_count;

    /**
     * 送达人数，一般约等于总粉丝数
     */
    private Integer target_user;

    /**
     * 用户来源，在获取图文阅读分时数据时才有该字段
     */
    private ShareScene user_source;

    /**
     * 图文群发总数据
     */
    private ArticleSummary details;

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getStat_date() {
        return stat_date;
    }

    public void setStat_date(String stat_date) {
        this.stat_date = stat_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getInt_page_read_user() {
        return int_page_read_user;
    }

    public void setInt_page_read_user(Integer int_page_read_user) {
        this.int_page_read_user = int_page_read_user;
    }

    public Integer getInt_page_read_count() {
        return int_page_read_count;
    }

    public void setInt_page_read_count(Integer int_page_read_count) {
        this.int_page_read_count = int_page_read_count;
    }

    public ShareScene getShare_scene() {
        return share_scene;
    }

    public void setShare_scene(ShareScene share_scene) {
        this.share_scene = share_scene;
    }

    public Integer getShare_user() {
        return share_user;
    }

    public void setShare_user(Integer share_user) {
        this.share_user = share_user;
    }

    public Integer getShare_count() {
        return share_count;
    }

    public void setShare_count(Integer share_count) {
        this.share_count = share_count;
    }

    public Integer getAdd_to_fav_user() {
        return add_to_fav_user;
    }

    public void setAdd_to_fav_user(Integer add_to_fav_user) {
        this.add_to_fav_user = add_to_fav_user;
    }

    public Integer getAdd_to_fav_count() {
        return add_to_fav_count;
    }

    public void setAdd_to_fav_count(Integer add_to_fav_count) {
        this.add_to_fav_count = add_to_fav_count;
    }

    public Integer getTarget_user() {
        return target_user;
    }

    public void setTarget_user(Integer target_user) {
        this.target_user = target_user;
    }

    public ShareScene getUser_source() {
        return user_source;
    }

    public void setUser_source(ShareScene user_source) {
        this.user_source = user_source;
    }

    public ArticleSummary getDetails() {
        return details;
    }

    public void setDetails(ArticleSummary details) {
        this.details = details;
    }

}
