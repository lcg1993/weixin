package com.weixin.entity.message;

/**
 * description: 图文消息体 <br>
 * version: 1.0 <br>
 * date: 2021/6/10 0010 15:35 <br>
 * author: lichaoge <br>
 */
public class News {

    private String Title;
    private String Description;
    private String PicUrl;
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
