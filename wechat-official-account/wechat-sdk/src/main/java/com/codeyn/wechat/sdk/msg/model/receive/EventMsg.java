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
package com.codeyn.wechat.sdk.msg.model.receive;

import org.apache.commons.lang.StringUtils;

/**
 * 接收消息对象，微信样例见event.txt
 * 
 * @author Arthur
 */
public class EventMsg extends ReceivedMsg {

    public static final String QR_KEY_PRE = "qrscene_";

    private String event;

    /**
     * 客服
     */
    private String kfAccount;
    private String toKfAccount;

    /**
     * 菜单，暂支持1-2 TODO 3-8
     */
    private String eventKey;

    /**
     * 上报地理位置事件
     */
    private Double latitude;
    private Double longitude;
    private Double precision;

    /**
     * 群发
     */
    private String status;
    private String totalCount;
    private String filterCount;
    private String sentCount;
    private String errorCount;

    /**
     * 扫二维码
     */
    private String ticket;

    public String getQrParam() {
        return StringUtils.isBlank(eventKey) ? null : eventKey.replace(QR_KEY_PRE, "");
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public String getToKfAccount() {
        return toKfAccount;
    }

    public void setToKfAccount(String toKfAccount) {
        this.toKfAccount = toKfAccount;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(String filterCount) {
        this.filterCount = filterCount;
    }

    public String getSentCount() {
        return sentCount;
    }

    public void setSentCount(String sentCount) {
        this.sentCount = sentCount;
    }

    public String getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(String errorCount) {
        this.errorCount = errorCount;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

}
