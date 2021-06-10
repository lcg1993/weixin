package com.weixin.util;

import com.thoughtworks.xstream.XStream;
import com.weixin.entity.TextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public static String textToxml(TextMessage textmessage) {
        XStream xStream = new XStream();
        xStream.alias("xml",textmessage.getClass());
        return xStream.toXML(textmessage);
    }

    public static String initText(String toUserName,String fromUserName,String content){
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setMsgType(MessageUtil.MESSAGE_TEXT);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setContent(content);
        return textToxml(textMessage);
    }

    /**
     * description: 主菜单 <br>
     * version: 1.0 <br>
     * date: 2021/6/9 0009 17:35 <br>
     * author: lichaoge <br>
     *
     * @param
     * @return java.lang.String
     */
    public static String menuText(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("欢迎您关注，请按照菜单提示进行操作：\n\n");
        stringBuffer.append("1.公众号介绍\n");
        stringBuffer.append("2.公众号开发人员介绍\n\n");
        stringBuffer.append("回复？调出菜单。");
        return stringBuffer.toString();
    }
    /**
     * description: 公众号介绍 <br>
     * version: 1.0 <br>
     * date: 2021/6/9 0009 17:49 <br>
     * author: lichaoge <br>
     *
     * @param
     * @return java.lang.String
     */
    public static String gongZhongHao_jieShao(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("此公众号是为了便捷生活，将程序带进生活，将生活带进程序！");
        return stringBuffer.toString();
    }

    /**
     * description: 公众号开发人员介绍 <br>
     * version: 1.0 <br>
     * date: 2021/6/9 0009 17:52 <br>
     * author: lichaoge <br>
     *
     * @param
     * @return java.lang.String
     */
    public static String kaiFa_jieShao(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("开发人员为：\n  内蒙古民族大学数学学院信息与计算科学专业学生-李朝格；");
        return stringBuffer.toString();
    }
}
