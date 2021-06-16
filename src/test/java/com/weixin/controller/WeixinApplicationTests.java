package com.weixin.controller;

import com.weixin.entity.AccessToken;
import com.weixin.util.AppIDAndSecret;
import com.weixin.util.MenuUtil;
import javafx.application.Application;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
//@SpringBootTest
class WeixinApplicationTests {

    void contextLoads(){
    }

    public static void main(String[] args) throws SQLException {
        AppIDAndSecret appIDAndSecret = new AppIDAndSecret();
        AccessToken token = appIDAndSecret.getAccessToken();
        System.out.println("token凭证：" + token.getAccessToken());
//        System.out.println("token有效时间：" + token.getExpiresIn());
//
//        String menu = JSONObject.fromObject(MenuUtil.initMenu()).toString();
//        int result = MenuUtil.createMenu(token.getAccessToken(),menu);
//        if (result == 0) {
//            System.out.println("创建菜单成功");
//        } else {
//            System.out.println("创建菜单失败，error：" + result);
//        }

    }

}
