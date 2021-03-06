package com.weixin.util;

import com.thoughtworks.xstream.XStream;
import com.weixin.entity.message.News;
import com.weixin.entity.message.NewsMessge;
import com.weixin.entity.message.TextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * description:  <br>
 * version: 1.0 <br>
 * date: 2021/6/9 0009 14:14 <br>
 * author: lichaoge <br>
 */
public class MessageUtil {

    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDIO = "vidio";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "click";
    public static final String MESSAGE_VIEW = "view";
    public static final String MESSAGE_NEWS = "news";

    /**
     * description: xmlToMap <br>
     * version: 1.0 <br>
     * date: 2021/6/9 0009 14:15 <br>
     * author: lichaoge <br>
     *
     * @param request
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String,String> map = new HashMap<String,String>();
        SAXReader reader = new SAXReader();

        InputStream inputStream = request.getInputStream();
        Document document = reader.read(inputStream);

        Element element = document.getRootElement();

        List<Element> list = element.elements();

        for (Element e : list) {
            map.put(e.getName(),e.getText());
        }

        inputStream.close();

        return map;
    }

    /**
     * description: textmessageToxml <br>
     * version: 1.0 <br>
     * date: 2021/6/9 0009 14:44 <br>
     * author: lichaoge <br>
     *
     * @param textmessage
     * @return java.lang.String
     */
    public static String textMessageToxml(TextMessage textmessage) {
        XStream xStream = new XStream();
        xStream.alias("xml",TextMessage.class);
        return xStream.toXML(textmessage);
    }

    public static String newsMessageToxml(NewsMessge newsMessge) {
        XStream xStream = new XStream();
        xStream.alias("xml", NewsMessge.class);
        xStream.alias("item", News.class);
        return xStream.toXML(newsMessge);
    }
    /**
     * description: ????????????????????? <br>
     * version: 1.0 <br>
     * date: 2021/6/10 0010 16:00 <br>
     * author: lichaoge <br>
     *
     * @param toUserName
     * @param fromUserName
     * @param content
     * @return java.lang.String
     */
    public static String initTextMessage(String toUserName,String fromUserName,String content){
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setMsgType(MESSAGE_TEXT);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setContent(content);
        return textMessageToxml(textMessage);
    }

    public static String initNewsMessage(String toUserName,String fromUserName){

        News news = new News();
        news.setTitle("??????????????????");
        news.setDescription("??????????????????????????????????????????????????????");
        news.setPicUrl("http://lcg.ngrok2.xiaomiqiu.cn/images/01.jpg");
        news.setUrl("http://lcg.ngrok2.xiaomiqiu.cn/images/01.jpg");

        List<News> list = new ArrayList<News>();
        list.add(news);

        NewsMessge newsMessge = new NewsMessge();
        newsMessge.setToUserName(fromUserName);
        newsMessge.setFromUserName(toUserName);
        newsMessge.setCreateTime(new Date().getTime());
        newsMessge.setMsgType(MESSAGE_NEWS);
        newsMessge.setArticleCount(list.size());
        newsMessge.setArticles(list);

        return newsMessageToxml(newsMessge);
    }

    /**
     * description: ????????? <br>
     * version: 1.0 <br>
     * date: 2021/6/9 0009 17:35 <br>
     * author: lichaoge <br>
     *
     * @param
     * @return java.lang.String
     */
    public static String menuText(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("??????????????????????????????????????????????????????\n\n");
        stringBuffer.append("1.???????????????\n");
        stringBuffer.append("2.???????????????????????????\n");
        stringBuffer.append("3.????????????\n\n");
        stringBuffer.append("????????????????????????");
        return stringBuffer.toString();
    }
    /**
     * description: ??????????????? <br>
     * version: 1.0 <br>
     * date: 2021/6/9 0009 17:49 <br>
     * author: lichaoge <br>
     *
     * @param
     * @return java.lang.String
     */
    public static String gongZhongHao_jieShao(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("????????????????????????????????????????????????????????????????????????????????????");
        return stringBuffer.toString();
    }

    /**
     * description: ??????????????????????????? <br>
     * version: 1.0 <br>
     * date: 2021/6/9 0009 17:52 <br>
     * author: lichaoge <br>
     *
     * @param
     * @return java.lang.String
     */
    public static String kaiFa_jieShao(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("????????????:\n\n");
        stringBuffer.append(" ??????\n ??????\n ??????\n ??????\n ?????????\n ??????\n ??????\n\n");
        stringBuffer.append("?????????????????????????????????...\n");
        return stringBuffer.toString();
    }
}
