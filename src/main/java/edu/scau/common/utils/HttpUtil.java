package edu.scau.common.utils;

import org.apache.http.HttpStatus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @description: 获取openid
 * @author: whj
 * @create: 2020-08-13 20:49
 **/
public class HttpUtil {
    public static String doGet(String urlPath)
            throws Exception {
        StringBuilder sb = new StringBuilder(urlPath);
        // System.out.println(sb.toString());
        URL url = new URL(sb.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000); // 5s超时
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
            // JSONObject jsonObject = new JSONObject(sbs.toString());
            return sbs.toString();
        }

        return null;
    }

}
