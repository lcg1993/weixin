package com.weixin.controller;

import com.weixin.entity.AccessToken;
import com.weixin.util.AppIDAndSecret;
import com.weixin.util.MenuUtil;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeixinApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        AccessToken token = AppIDAndSecret.getAccessToken();
        System.out.println("token凭证：" + token.getAccessToken());
        System.out.println("token有效时间：" + token.getExpiresIn());

        String menu = JSONObject.fromObject(MenuUtil.initMenu()).toString();
        int result = MenuUtil.createMenu(token.getAccessToken(),menu);
        if (result == 0) {
            System.out.println("创建菜单成功");
        } else {
            System.out.println("创建菜单失败，error：" + result);
        }
    }

}
