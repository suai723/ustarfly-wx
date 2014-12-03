package com.sa.bean;

/**
 *
 *
 * ticket	 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
 * expire_seconds	 二维码的有效时间，以秒为单位。最大不超过1800。
 * url	 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
 * Created by sa on 14-12-3.
 */
public class Ticket {
    private  String ticket;
    private  String expire_seconds;
    private  String url;


    public Ticket(String ticket, String expire_seconds, String url) {
        this.ticket = ticket;
        this.expire_seconds = expire_seconds;
        this.url = url;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(String expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
