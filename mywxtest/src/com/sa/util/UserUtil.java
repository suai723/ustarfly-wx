package com.sa.util;

import com.sa.bean.AccessToken;
import com.sa.bean.User;
import net.sf.json.JSONObject;

/**
 * Created by sa on 14-12-4.
 */
public class UserUtil {
    public static User getUserInfo(AccessToken at,String openId){
        String url ="https://api.weixin.qq.com/cgi-bin/user/info?access_token="+at.getToken()+"&openid="+openId+"&lang=zh_CN";
        JSONObject jsonObject = wxutil.httpsRequest(url,"GET",null);
        User user =(User)JSONObject.toBean(jsonObject,User.class);
        return user;
    }
}
