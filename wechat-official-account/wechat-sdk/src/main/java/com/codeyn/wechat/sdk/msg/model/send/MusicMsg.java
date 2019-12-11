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
package com.codeyn.wechat.sdk.msg.model.send;

import com.codeyn.wechat.sdk.msg.enums.MsgType;
import com.codeyn.wechat.sdk.msg.model.receive.ReceivedMsg;

/**
	回复音乐消息
	<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>12345678</CreateTime>
		<MsgType><![CDATA[music]]></MsgType>
		<Music>
			<Title><![CDATA[TITLE]]></Title>
			<Description><![CDATA[DESCRIPTION]]></Description>
			<MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
			<HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
			<ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
		</Music>
	</xml>
*/
public class MusicMsg extends SentMsg {
	
	private String title;
	private String description;
	private String musicUrl;
	private String hQMusicUrl;
	// private String thumbMediaId;
	private String funcFlag = "0";
	
	public MusicMsg() {
		setMsgType(MsgType.MUSIC.getFlag());
	}
	
	public MusicMsg(ReceivedMsg inMsg) {
		super(inMsg);
		setMsgType(MsgType.MUSIC.getFlag());
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
	
	public String getMusicUrl() {
		return musicUrl;
	}
	
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	
	public String getHQMusicUrl() {
		return hQMusicUrl;
	}
	
	public void setHQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}
	
	public String getFuncFlag() {
		return funcFlag;
	}
	
	// 设置为星标
	public void setFuncFlag(boolean funcFlag) {
		this.funcFlag = funcFlag ? "1" : "0";
	}
	
	/* 官方文档有误，无此属性
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}*/
}
