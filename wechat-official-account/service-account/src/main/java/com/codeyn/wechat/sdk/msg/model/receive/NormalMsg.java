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

/**
 * 接收消息对象，微信样例见msg.txt
 * @author Arthur
 */
public class NormalMsg extends ReceivedMsg{
	
	/**
	 * 文本内容
	 */
    private String content;
	
	/**
	 * 媒体序号
	 * 图片/语音/视频
	 */
    private String mediaId;
	
    /**
     * 图片地址
     */
    private String picUrl;
    
	/**
	 * 视频/小视频
	 */
    private String thumbMediaId;
	
    /**
     * 音频格式
     */
    private String format;
	
	/**
	 * 接收语音识别结果，与 Voice 唯一的不同是多了一个 Recognition 标记
	 */
    private String recognition;
	
    /**
     * 接收链接消息
     */
    private String title;
    private String description;
    private String url;
    
    /**
     * 接收地理位置消息
     */
    private Double location_X;
    private Double location_Y;
    private Integer scale;
    
    //位置信息
    private String label;
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getMediaId() {
        return mediaId;
    }
    
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
    
    public String getPicUrl() {
        return picUrl;
    }
    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    
    public String getThumbMediaId() {
        return thumbMediaId;
    }
    
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
    
    public String getFormat() {
        return format;
    }
    
    public void setFormat(String format) {
        this.format = format;
    }
    
    public String getRecognition() {
        return recognition;
    }
    
    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public Double getLocation_X() {
        return location_X;
    }
    
    public void setLocation_X(Double location_X) {
        this.location_X = location_X;
    }
    
    public Double getLocation_Y() {
        return location_Y;
    }
    
    public void setLocation_Y(Double location_Y) {
        this.location_Y = location_Y;
    }
    
    public Integer getScale() {
        return scale;
    }
    
    public void setScale(Integer scale) {
        this.scale = scale;
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
}
