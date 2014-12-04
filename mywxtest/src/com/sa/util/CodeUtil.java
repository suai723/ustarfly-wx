package com.sa.util;

import com.sa.bean.AccessToken;
import com.sa.bean.Ticket;
import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 获得临时、永久二维码
 * Created by sa on 14-12-3.
 */
public class CodeUtil {
    public static Ticket  getTicket(AccessToken at,String type,String sceneId){
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+at.getToken();
        String data ="{\"action_name\": \""+type+"\", \"action_info\": {\"scene\": {\"scene_id\":"+sceneId+"}}}";
        String reqUrl = url+at.getToken();
        JSONObject jsonObject = wxutil.httpsRequest(reqUrl, "POST",data);
        String ticket = jsonObject.getString("ticket");
        String expire_seconds = jsonObject.getString("expire_seconds");
        String codeUrl = jsonObject.getString("url");
        return new Ticket(ticket,expire_seconds,codeUrl);
    }

    public static JSONObject getCode(Ticket ticket){
        JSONObject jsonObject=null;
        String url ="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket.getTicket();
        try {
            String reqUrl = url+URLEncoder.encode(ticket.getTicket(),"utf-8");
            jsonObject = wxutil.httpsRequest(reqUrl,"GET",null);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
