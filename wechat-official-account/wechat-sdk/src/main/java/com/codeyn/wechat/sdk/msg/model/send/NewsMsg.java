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

import java.util.ArrayList;
import java.util.List;

import com.codeyn.wechat.sdk.msg.enums.MsgType;
import com.codeyn.wechat.sdk.msg.model.receive.ReceivedMsg;

/**
	回复图文消息
	<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>12345678</CreateTime>
		<MsgType><![CDATA[news]]></MsgType>
			<ArticleCount>2</ArticleCount>
			<Articles>
				<item>
					<Title><![CDATA[title1]]></Title> 
					<Description><![CDATA[description1]]></Description>
					<PicUrl><![CDATA[picurl]]></PicUrl>
					<Url><![CDATA[url]]></Url>
				</item>
				
				<item>
					<Title><![CDATA[title]]></Title>
					<Description><![CDATA[description]]></Description>
					<PicUrl><![CDATA[picurl]]></PicUrl>
					<Url><![CDATA[url]]></Url>
				</item>
			</Articles>
	</xml> 
 */
public class NewsMsg extends SentMsg {
    
	private List<NewsItem> articles = new ArrayList<NewsItem>();
	
	public NewsMsg() {
		setMsgType(MsgType.NEWS.getFlag());
	}
	
	public NewsMsg(ReceivedMsg inMsg) {
		super(inMsg);
		setMsgType(MsgType.NEWS.getFlag());
	}
	
	public Integer getArticleCount() {
		return articles.size();
	}
	
	public List<NewsItem> getArticles() {
		return articles;
	}
	
	public void setArticles(List<NewsItem> articles) {
		if (articles != null)
			this.articles = articles;
	}
	
	public NewsMsg addNews(List<NewsItem> articles) {
		if (articles != null)
			this.articles.addAll(articles);
		return this;
	}
	
	public NewsMsg addNews(String title, String description, String picUrl, String url) {
		this.articles.add(new NewsItem(title, description, picUrl, url));
		return this;
	}
	
	public NewsMsg addNews(NewsItem news) {
		this.articles.add(news);
		return this;
	}
}
