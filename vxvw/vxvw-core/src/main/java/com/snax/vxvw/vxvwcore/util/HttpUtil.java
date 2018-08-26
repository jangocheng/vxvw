package com.snax.vxvw.vxvwcore.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * 向指定的url发送post方法的请求
 * @return 远程资源的响应结果
 */
public class HttpUtil {

    /**
     * 向指定的url发送post方法的请求
     * @param url 请求url
     * @param params 请求的参数集合
     * @return 远程资源的响应结果
     */
    @SuppressWarnings("unused")
    public static String sendPost(String url,Map<String,String> params){
        OutputStreamWriter out=null;
        BufferedReader in=null;
        StringBuilder result=new StringBuilder();
        try {
            URL realUrl=new URL(url);
            HttpURLConnection conn= (HttpURLConnection) realUrl.openConnection();
            /**
             * 发送post请求必须设置如下两行
             */
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //post方法
            conn.setRequestMethod("POST");
            //设置通用的请求属性
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.connect();
            //获取urlConnection对象对应的输出流
            out=new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
            //发送请求参数
            if (params!=null){
                StringBuilder builder=new StringBuilder();
                for (Map.Entry<String,String> entry:params.entrySet()){
                    if (builder.length()>0){
                        builder.append("&");
                    }
                    builder.append(entry.getKey());
                    builder.append("=");
                    builder.append(entry.getValue());
                }
                out.write(builder.toString());
            }
            out.flush();
            in=new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"UTF-8")
            );
            String line;
            while ((line=in.readLine())!=null){
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (out!=null){
                    out.close();
                }
                if (in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }
}
