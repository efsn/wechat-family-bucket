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
package com.codeyn.wechat.sdk.user.result;

import com.codeyn.wechat.sdk.core.enums.WxStatus;
import com.codeyn.wechat.sdk.core.model.WxResult;
import com.codeyn.wechat.sdk.user.enums.SexType;

/**
 * 
 * @author Arthur
 *
 */
public class WxUser extends WxResult {

    /**
     * 用户是否订阅该公众号标识，值为WxStatus.No时，代表此用户没有关注该公众号，拉取不到其余信息
     */
    private WxStatus subscribe;

    /**
     * 用户的唯一标识
     */
    private String openid;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private SexType sex;

    /**
     * 用户个人资料填写的省份
     */
    private String province;

    /**
     * 普通用户个人资料填写的城市
     */
    private String city;

    /**
     * 用户的语言，简体中文为zh_CN
     */
    private String language;

    /**
     * 国家，如中国为CN
     */
    private String country;

    /**
     * 用户头像
     */
    private String headimgurl;

    /**
     * 用户特权信息
     */
    private String[] privilege;

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
     */
    private String unionid;

    /**
     * 用户关注时间
     */
    private Long subscribe_time;

    /**
     * 公众号运营者对粉丝的备注
     */
    private String remark;

    /**
     * 用户所在的分组ID
     */
    private Integer groupid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        SexType type = SexType.get(sex);
        this.sex = type == null ? SexType.UNKONWN : type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String[] getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String[] privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public WxStatus getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        WxStatus status = WxStatus.get(subscribe);
        this.subscribe = status == null ? WxStatus.NO : status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(Long subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
