package com.weixin.util;

import com.weixin.entity.menu.Button;
import com.weixin.entity.menu.ClickButton;
import com.weixin.entity.menu.Menu;
import com.weixin.entity.menu.ViewButton;
import net.sf.json.JSONObject;

public class MenuUtil {

    private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public static Menu initMenu(){
        Menu menu = new Menu();
        ClickButton button1 = new ClickButton();
        button1.setName("文本资料");
        button1.setType("click");
        button1.setKey("1");

        ViewButton button2 = new ViewButton();
        button2.setName("菜鸟教程");
        button2.setType("view");
        button2.setUrl("https://www.runoob.com/");

        ClickButton button31 = new ClickButton();
        button31.setName("扫码");
        button31.setType("scancode_push");
        button31.setKey("31");

        ClickButton button32 = new ClickButton();
        button32.setName("地理位置");
        button32.setType("location_select");
        button32.setKey("32");

        Button button3 = new Button();
        button3.setName("工具");
        button3.setSub_button(new Button[]{button31,button32});

        menu.setButton(new Button[]{button1,button2,button3});
        return menu;
    }

    public static int createMenu(String token,String menu){
        int result = 0;
        String url = CREATE_MENU_URL.replace("ACCESS_TOKEN",token);
        JSONObject jsonObject = AppIDAndSecret.doPostStr(url,menu);
        if (jsonObject != null) {
            result = jsonObject.getInt("errcode");
        }
        return result;
    }
}
