package com.sa.bean;

/**
 * Created by sa on 14-12-3.
 */
public class TicketData {
    /**
     *expire_seconds	 该二维码有效时间，以秒为单位。 最大不超过1800。
     *action_name	 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久
     *action_info	 二维码详细信息
     *scene_id	 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     */

    private String expire_seconds;
    private String action_name;
    private String action_info;
    private String scene_id;

    public TicketData(String expire_seconds, String action_name, String action_info, String scene_id) {
        this.expire_seconds = expire_seconds;
        this.action_name = action_name;
        this.action_info = action_info;
        this.scene_id = scene_id;
    }

    public String getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(String expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public String getAction_info() {
        return action_info;
    }

    public void setAction_info(String action_info) {
        this.action_info = action_info;
    }

    public String getScene_id() {
        return scene_id;
    }

    public void setScene_id(String scene_id) {
        this.scene_id = scene_id;
    }
}
