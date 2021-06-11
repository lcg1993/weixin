package com.weixin.util;

import com.weixin.entity.AccessToken;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * description:  <br>
 * version: 1.0 <br>
 * date: 2021/6/11 0011 13:59 <br>
 * author: lichaoge <br>
 */
public class AppIDAndSecret {

    private static final String APPID = "wx65cc3ce4e6b8b574";
    private static final String APPSECRET = "4f284cd0ac3f7744f99cbd75e6eac2de";

    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * description: doGetStr <br>
     * version: 1.0 <br>
     * date: 2021/6/11 0011 14:24 <br>
     * author: lichaoge <br> 
     *       
     * @param url
     * @return net.sf.json.JSONObject
     */ 
    public static JSONObject doGetStr(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        JSONObject jsonObject = null;
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                String result = EntityUtils.toString(httpEntity,"UTF-8");
                jsonObject = JSONObject.fromObject(result);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * description: doPostStr <br>
     * version: 1.0 <br>
     * date: 2021/6/11 0011 14:31 <br>
     * author: lichaoge <br> 
     *       
     * @param url
     * @param outStr
     * @return net.sf.json.JSONObject
     */ 
    public static JSONObject doPostStr(String url,String outStr){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = null;
        try {
            httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity(),"UTF-8");
            jsonObject = JSONObject.fromObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * description: 获取Access token <br>
     * version: 1.0 <br>
     * date: 2021/6/11 0011 14:44 <br>
     * author: lichaoge <br> 
     *       
     * @param 
     * @return com.weixin.entity.AccessToken
     */ 
    public static AccessToken getAccessToken(){
        AccessToken token = new AccessToken();
        String url = ACCESS_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSECRET);
        //需要把token存本地   判断token失效时间   不然每次都会重新获取token   一天上线是2000
        //先这样    后续存库    做判断
        if(true) {
            JSONObject jsonObject = doGetStr(url);
            if (jsonObject != null) {
                token.setAccessToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getInt("expires_in"));
            }
        }
        return token;
    }
}
