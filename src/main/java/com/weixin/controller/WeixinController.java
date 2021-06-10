package com.weixin.controller;

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
import java.util.Map;

/**
 * description:  <br>
 * version: 1.0 <br>
 * date: 2021/6/8 0008 15:54 <br>
 * author: lichaoge <br>
 */

@RestController
public class WeixinController {

    /**
     * description: doGet <br>
     * version: 1.0 <br>
     * date: 2021/6/10 0010 16:04 <br>
     * author: lichaoge <br>
     *
     * @param request
 * @param response
     * @return void
     */
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

    /**
     * description: doPost <br>
     * version: 1.0 <br>
     * date: 2021/6/10 0010 16:02 <br>
     * author: lichaoge <br>
     *
     * @param request
     * @param response
     * @return void
     */
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
                    message = MessageUtil.initTextMessage(toUserName,fromUserName,MessageUtil.gongZhongHao_jieShao());
                } else if ("2".equals(content)) {
                    message = MessageUtil.initTextMessage(toUserName,fromUserName,MessageUtil.kaiFa_jieShao());
                } else if ("3".equals(content)) {
                    message = MessageUtil.initNewsMessage(toUserName,fromUserName);
                } else if ("?".equals(content) || "？".equals(content)) {
                    message = MessageUtil.initTextMessage(toUserName,fromUserName,MessageUtil.menuText());
                }
                System.out.println(message);
            } else if (MessageUtil.MESSAGE_EVENT.equals(msgtype)) {
                String eventType = map.get("Event");
                if (MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)) {
                    message = MessageUtil.initTextMessage(toUserName,fromUserName,MessageUtil.menuText());
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
