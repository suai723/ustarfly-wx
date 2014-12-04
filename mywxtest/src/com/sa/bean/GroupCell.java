package com.sa.bean;

/**
 * groups	 公众平台分组信息列表
 * id	 分组id，由微信分配
 * name	 分组名字，UTF8编码
 * count	 分组内用户数量
 * Created by sa on 14-12-4.
 */
public class GroupCell {
    private String id;
    private String name;
    private String count;


    public GroupCell() {}

    public GroupCell(String id, String name, String count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
