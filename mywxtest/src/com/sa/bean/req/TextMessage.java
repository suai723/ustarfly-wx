package com.sa.bean.req;

/**
 * Created by sa on 14-11-26.
 * 文本消息
 */
public class TextMessage extends BaseMessage{
    private String Content;//文本消息内容

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
