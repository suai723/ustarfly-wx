package com.sa.bean;

/**
 * subscribe	 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
 * openid	 用户的标识，对当前公众号唯一
 * nickname	 用户的昵称
 * sex	 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
 * city	 用户所在城市
 * country	 用户所在国家
 * province	 用户所在省份
 * language	 用户的语言，简体中文为zh_CN
 * headimgurl	 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
 * subscribe_time	 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
 * unionid	 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
 * Created by sa on 14-12-4.
 */
public class User {
    private String subscribe;
    private String openid;
    private String nickname;
    private String sex;
    private String city;
    private String country;
    private String province;
    private String language;
    private String headimgurl;
    private String subscribetime;
    private String unionid;

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getSubscribetime() {
        return subscribetime;
    }

    public void setSubscribetime(String subscribetime) {
        this.subscribetime = subscribetime;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
