package edu.scau.common.utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @description: 获取openid
 * @author: whj
 * @create: 2020-08-13 20:49
 **/
public class HttpUtil {
    public static final String APPID="wx3ba5b3cafbcbd958";
    public static final String APPSECRET="13c3597b68a04f2b65270413e38a5989";
    public static String doGet(String urlPath)
            throws Exception {
        URL url = new URL(urlPath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(20000); // 5s超时
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() == HttpStatus.SC_OK) {// HttpStatus.SC_OK ==
            // 200
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            StringBuilder sbs = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sbs.append(line);
            }
            return sbs.toString();
        }
        return null;
    }
    public static String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultString;
    }
    public static String getAccessToken() throws Exception {
        String result= HttpUtil.doGet("https://api.weixin.qq.com/cgi-bin/token?" +
                "grant_type=client_credential" +
                "&appid="+HttpUtil.APPID+
                "&secret="+HttpUtil.APPSECRET);
        JSONObject jsonObject = JSONObject.fromObject(result);
        String accessToken = (String) jsonObject.get("access_token");
        return  accessToken;
    }

}
