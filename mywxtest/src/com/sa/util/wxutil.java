package com.sa.util;


import com.sa.bean.AccessToken;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

/**
 * 向微信服务器发送https请求
 * requestUrl是请求地址   requestMethod请求方式post get  outputStr是提交的数据
 * Created by sa on 14-12-1.
 */
public class wxutil {
    private static Logger log = Logger.getLogger(wxutil.class);
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        HttpsURLConnection httpUrlConn =null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;

            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException e) {
            log.error("Weixin server connection timed out.");
        } catch (Exception e) {
            log.error("https request error:{}", e);
        }finally {
            httpUrlConn.disconnect();
        }
        return jsonObject;
    }


    public static AccessToken getAccessToken(){
        String appId="wxc2c284ba6cb8344e";
        String appSecret="13981decd3da850c7cfab546a9a7d750";
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appId+"&secret="+appSecret;
        JSONObject jsonObject = httpsRequest(url,"GET",null);
        AccessToken at = new AccessToken();
        at.setStartTime(System.currentTimeMillis());
        at.setToken(jsonObject.getString("access_token"));
        at.setExpiresIn(jsonObject.getString("expires_in"));
        //at.setEndTime(at.getStartTime()+Long.parseLong((String) jsonObject.get("expires_in")));
//        long MillisTime=System.currentTimeMillis();
//        jsonObject.put("StratTime",MillisTime);
//        jsonObject.put("EndTime",MillisTime+Long.parseLong((String) jsonObject.get("expires_in")));
        return at;

    }
}
