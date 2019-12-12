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
package com.codeyn.wechat.sdk.material.result;

import com.codeyn.wechat.sdk.msg.result.MsgResult;

/**
 * 媒体文件
 * 图片（image）、语音（voice）、视频（video）和缩略图（thumb）news图文消息
 * @author Arthur
 *
 */
public class Media extends MsgResult {

    /**
     * 媒体文件类型
     * 分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * news图文消息
     */
    private String type;
    
    /**
     * 媒体文件/图文消息上传后获取的唯一标识
     */
    private String media_id;
    
    /**
     * 媒体文件上传时间
     */
    private Long created_at;
    
    private String url;

    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getMedia_id() {
        return media_id;
    }
    
    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
    
    public Long getCreated_at() {
        return created_at;
    }
    
    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
