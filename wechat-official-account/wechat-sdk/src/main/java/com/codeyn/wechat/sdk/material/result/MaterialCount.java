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

import com.codeyn.wechat.sdk.core.model.WxResult;

/**
 * 获取素材总数
 * @author Arthur
 *
 */
public class MaterialCount extends WxResult{

    /**
     * 语音总数量
     */
    private Integer voice_count;
    
    /**
     * 视频总数量
     */
    private Integer video_count;
    
    /**
     * 图片总数量
     */
    private Integer image_count;
    
    /**
     * 图文总数量
     */
    private Integer news_count;
    
    public Integer getVoice_count() {
        return voice_count;
    }
    
    public void setVoice_count(Integer voice_count) {
        this.voice_count = voice_count;
    }
    
    public Integer getVideo_count() {
        return video_count;
    }
    
    public void setVideo_count(Integer video_count) {
        this.video_count = video_count;
    }
    
    public Integer getImage_count() {
        return image_count;
    }
    
    public void setImage_count(Integer image_count) {
        this.image_count = image_count;
    }
    
    public Integer getNews_count() {
        return news_count;
    }
    
    public void setNews_count(Integer news_count) {
        this.news_count = news_count;
    }
    
}
