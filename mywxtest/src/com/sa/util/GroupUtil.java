package com.sa.util;

import com.sa.bean.AccessToken;
import com.sa.bean.GroupCell;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 *
 * 微信分组工具类
 * Created by sa on 14-12-4.
 */
public class GroupUtil {
    //创建分组
    public static String createGroup(AccessToken at,String name){
        String url ="https://api.weixin.qq.com/cgi-bin/groups/create?access_token="+at.getToken();
        String data = "{\"group\":{\"name\":\""+name+"\"}}";
        JSONObject jsonObject=wxutil.httpsRequest(url, "POST",data);
        String errmsg=null;
        if (jsonObject.containsKey("name")){
            String str = jsonObject.getString("name");
            errmsg=str.equals(name)?"ok":"error";
        }else{
            errmsg=jsonObject.getString("error")+" "+jsonObject.getString("errmsg");
        }
        return errmsg;
    }

    //查询所有分组
    public static List<GroupCell> checkAllGroup(AccessToken at){
        String url ="https://api.weixin.qq.com/cgi-bin/groups/get?access_token="+at.getToken();
        JSONObject jsonObject = wxutil.httpsRequest(url,"GET",null);
        List<GroupCell> groups = null;
        if (jsonObject.containsKey("groups")){
            JSONArray jsonArray = jsonObject.getJSONArray("groups");
            groups=JSONArray.toList(jsonArray, GroupCell.class);
            return groups;
        }else{
            return null;
        }

    }
    //查询用户所在分组
    public static String checkUserGroup(AccessToken at,String openId){
        String url="https://api.weixin.qq.com/cgi-bin/groups/getid?access_token="+at.getToken();
        String data="{\"openid\":\""+openId+"\"}";
        JSONObject jsonObject= wxutil.httpsRequest(url, "POST", data);
        if (jsonObject.containsKey("groupid")) {
            return jsonObject.getString("groupid");
        }else{
            return jsonObject.getString("error")+" "+jsonObject.getString("errmsg");
        }
    }
    /**
     *修改分组名
     *需要修改组的groupID
     *修改名称
     * @return ok为修改成功                                                                                                                                                                                                                                                                                                                                                                                                                                                   */
    public static String modifyGroupName(AccessToken at,String groupId,String ModifyName){
        String url = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token="+at.getToken();
        String data="{\"group\":{\"id\":"+groupId+",\"name\":\""+ModifyName+"\"}}";
        JSONObject jsonObject = wxutil.httpsRequest(url,"POST",data);
        if (jsonObject.getString("errmsg").equals("ok")){
            return "ok";
        }else{
            return jsonObject.getString("error")+" "+jsonObject.getString("errmsg");
        }
    }
    //将用户移动到分组
    public static String moveUserToGroup(AccessToken at,String opendId,String groupId){
        String url = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token="+at.getToken();
        String data="{\"openid\":\""+opendId+"\",\"to_groupid\":"+groupId+"}";
        JSONObject jsonObject = wxutil.httpsRequest(url,"POST",data);
        if (jsonObject.getString("errmsg").equals("ok")){
            return "ok";
        }else{
            return jsonObject.getString("error")+" "+jsonObject.getString("errmsg");
        }
    }


}
