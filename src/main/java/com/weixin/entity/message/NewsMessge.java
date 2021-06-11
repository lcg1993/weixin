package com.weixin.entity.message;

import javax.persistence.Entity;
import java.util.List;

/**
 * description: 回复图文消息 <br>
 * version: 1.0 <br>
 * date: 2021/6/10 0010 15:51 <br>
 * author: lichaoge <br>
 */
public class NewsMessge extends BaseMessage {

//    private String ToUserName;
//    private String FromUserName;
//    private long CreateTime;
//    private String MsgType;

    private int ArticleCount;
    private List<News> Articles;

//    @Override
//    public String getToUserName() {
//        return ToUserName;
//    }
//
//    @Override
//    public void setToUserName(String toUserName) {
//        ToUserName = toUserName;
//    }
//
//    @Override
//    public String getFromUserName() {
//        return FromUserName;
//    }
//
//    @Override
//    public void setFromUserName(String fromUserName) {
//        FromUserName = fromUserName;
//    }
//
//    @Override
//    public long getCreateTime() {
//        return CreateTime;
//    }
//
//    @Override
//    public void setCreateTime(long createTime) {
//        CreateTime = createTime;
//    }
//
//    @Override
//    public String getMsgType() {
//        return MsgType;
//    }
//
//    @Override
//    public void setMsgType(String msgType) {
//        MsgType = msgType;
//    }

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<News> getArticles() {
        return Articles;
    }

    public void setArticles(List<News> articles) {
        Articles = articles;
    }
}
