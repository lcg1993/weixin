package com.weixin.controller;

import com.weixin.entity.TextMessage;
import com.weixin.util.CheckUtil;
import com.weixin.util.MessageUtil;
import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * description:  <br>
 * version: 1.0 <br>
 * date: 2021/6/8 0008 15:54 <br>
 * author: lichaoge <br>
 */

@RestController
public class WeixinController {

    @RequestMapping(value = "/Weixin",method = RequestMethod.GET)
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();
        if (CheckUtil.checkSignature(signature,timestamp,nonce)) {
            out.print(echostr);
        }
    }

    @RequestMapping(value = "/Weixin",method = RequestMethod.POST)
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Map<String,String> map = MessageUtil.xmlToMap(request);
            String fromUserName = map.get("FromUserName");
            String toUserName = map.get("ToUserName");
            String content = map.get("Content");
            String msgtype = map.get("MsgType");
            String message = null;
            if (MessageUtil.MESSAGE_TEXT.equals(msgtype)) {
                if ("1".equals(content)) {
                    message = MessageUtil.initText(toUserName,fromUserName,MessageUtil.gongZhongHao_jieShao());
                } else if ("2".equals(content)) {
                    message = MessageUtil.initText(toUserName,fromUserName,MessageUtil.kaiFa_jieShao());
                } else if ("?".equals(content) || "？".equals(content)) {
                    message = MessageUtil.initText(toUserName,fromUserName,MessageUtil.menuText());
                }
//                TextMessage textMessage = new TextMessage();
//                textMessage.setToUserName(fromUserName);
//                textMessage.setFromUserName(toUserName);
//                textMessage.setMsgType("text");
//                textMessage.setCreateTime(new Date().getTime());
//                textMessage.setContent("您发送的消息是：" + content);
//                message = MessageUtil.textToxml(textMessage);
                System.out.println(message);
            } else if (MessageUtil.MESSAGE_EVENT.equals(msgtype)) {
                String eventType = map.get("EventType");
                if (MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)) {
                    message = MessageUtil.initText(toUserName,fromUserName,content);
                } else if (MessageUtil.MESSAGE_UNSUBSCRIBE.equals(eventType)) {

                }
            }
            out.print(message);
        } catch (DocumentException e){
            e.printStackTrace();
        } finally {
            out.close();
        }

    }

}
