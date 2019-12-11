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
package com.codeyn.wechat.sdk.core.model;

import org.apache.commons.lang.StringUtils;

import com.codeyn.wechat.sdk.core.enums.EncryptType;

/**
 * 微信基本参数
 * @author Arthur
 */
public class WxBase {
	
    public static final String ENCODING = "UTF-8";
    
    /**
     * 微信接口地址
     */
    private String wxHost = "https://api.weixin.qq.com";

    /**
     * 私钥
     */
	private String token = null;
	private String appId = null;
	private String appSecret = null;
	private String encodingAesKey = null;
	
	/**
	 * 消息加密模式
	 */
	private EncryptType encryptType = EncryptType.DIRECT;
	
	/**
	 * 微信名称
	 */
	private String wxNo;
	private String name;
	private String originId;
	private String domain;
	private String qrUrl;
	
	public WxBase() {
		
	}
	
	public WxBase(String token) {
		setToken(token);
	}
	
	public WxBase(String token, String appId, String appSecret) {
		setToken(token);
		setAppId(appId);
		setAppSecret(appSecret);
	}
	
	public WxBase(String wxNo,
                  String name,
                  String token,
                  String domain,
                  String originId,
                  String appId,
                  String appSecret,
                  String encodingAesKey,
                  Integer messageEncrypt) {
		setToken(token);
		setAppId(appId);
		setAppSecret(appSecret);
		setEncryptMessage(messageEncrypt);
		setEncodingAesKey(encodingAesKey);
		
		setWxNo(wxNo);
		setName(name);
		setOriginId(originId);
		setDomain(domain);
	}
	
	public String getToken() {
		if (StringUtils.isBlank(token))
			throw new IllegalStateException("token 未被赋值");
		return token;
	}
	
	public void setToken(String token) {
		if (StringUtils.isBlank(token))
			throw new IllegalArgumentException("token 值不能为空");
		this.token = token;
	}
	
	public String getAppId() {
		if (StringUtils.isBlank(appId))
			throw new IllegalStateException("appId 未被赋值");
		return appId;
	}
	
	public void setAppId(String appId) {
		if (StringUtils.isBlank(appId))
			throw new IllegalArgumentException("appId 值不能为空");
		this.appId = appId;
	}
	
	public String getAppSecret() {
		if (StringUtils.isBlank(appSecret))
			throw new IllegalStateException("appSecret 未被赋值");
		return appSecret;
	}
	
	public void setAppSecret(String appSecret) {
		if (StringUtils.isBlank(appSecret))
			throw new IllegalArgumentException("appSecret 值不能为空");
		this.appSecret = appSecret;
	}
	
	public String getEncodingAesKey() {
		if (StringUtils.isBlank(encodingAesKey))
			throw new IllegalStateException("encodingAesKey 未被赋值");
		return encodingAesKey;
	}
	
	public void setEncodingAesKey(String encodingAesKey) {
		if (StringUtils.isBlank(encodingAesKey))
			throw new IllegalArgumentException("encodingAesKey 值不能为空");
		this.encodingAesKey = encodingAesKey;
	}
	
	/**
	 * 是否对消息进行加密：
	 * true : 进行加密且必须配置 encodingAesKey
     * false : 采用明文模式，同时也支持混合模式
	 */
	public boolean isEncrypt() {
		return EncryptType.SAFE.equals(encryptType);
	}
	
	/**
	 * 默认为明文模式
	 */
	public void setEncryptMessage(Integer encryptType) {
	    EncryptType type = EncryptType.get(encryptType);
		this.encryptType = type == null ? EncryptType.DIRECT : type;
	}
	
	public String getHost(){
	    return wxHost;
	}
	
	public void setHost(String host){
	    if(StringUtils.isBlank(host)){
	        throw new IllegalStateException("微信域名不能为空");
	    }
	    this.wxHost = host;
	}

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getQrUrl() {
        return qrUrl;
    }

    public void setQrUrl(String qrUrl) {
        this.qrUrl = qrUrl;
    }
}
