package com.weixin.entity.message;

import javax.persistence.Entity;

/**
 * description: 所有消息的父类 <br>
 * version: 1.0 <br>
 * date: 2021/6/10 0010 15:45 <br>
 * author: lichaoge <br>

 */
public class BaseMessage {

    private String ToUserName;
    private String FromUserName;
    private long CreateTime;
    private String MsgType;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
