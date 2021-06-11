package com.weixin.entity.message;

import com.weixin.entity.message.BaseMessage;

/**
 * description: 回复文本消息 <br>
 * version: 1.0 <br>
 * date: 2021/6/9 0009 16:19 <br>
 * author: lichaoge <br>
 */
public class TextMessage extends BaseMessage {

    private String ToUserName;
    private String FromUserName;
    private long CreateTime;
    private String MsgType;

    private String Content;
    private String MsgId;

    @Override
    public String getToUserName() {
        return ToUserName;
    }

    @Override
    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    @Override
    public String getFromUserName() {
        return FromUserName;
    }

    @Override
    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    @Override
    public long getCreateTime() {
        return CreateTime;
    }

    @Override
    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    @Override
    public String getMsgType() {
        return MsgType;
    }

    @Override
    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
