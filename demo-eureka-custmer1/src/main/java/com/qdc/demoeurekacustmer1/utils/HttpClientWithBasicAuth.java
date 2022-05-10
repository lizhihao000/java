package com.qdc.demoeurekacustmer1.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClientWithBasicAuth {
    private String getHeader(String UserName, String Password) {
        //auth由两部分组成：UserName和Password组成
        String auth = UserName + ":" + Password;
        //使用Base64将auth进行加密
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        return authHeader;
    }

    //url：请求的地址。请求参数
    public String send(String url, String UserName, String Password, Map<String, String> params) {
        //实例化一个post对象，httppost对象映射的是post方法调用接口
        HttpPost post = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();

        //组织请求参数，在获取token时参数为grant_type和scope
        List<NameValuePair> paramList = new ArrayList<>();
        if (params != null && params.size() > 0) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                paramList.add(new BasicNameValuePair(key, params.get(key)));
            }
        }
            try {
                //设置要提交的数据
                post.setEntity(new UrlEncodedFormEntity(paramList, "utf-8"));
            } catch (UnsupportedEncodingException el) {
                el.printStackTrace();
            }
            //在设置的请求中将BaiscAuth信息添加到Post请求包头中
            post.addHeader("Authorization", getHeader(UserName, Password));
            //执行提交请求，excute执行post请求，病毒对返回的结果进行判断
            String responseContent = null;//响应内容
            CloseableHttpResponse response = null;
            try {
                response = client.execute(post);

                int status_code = response.getStatusLine().getStatusCode();
                System.out.println("status_code:" + status_code);
                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = response.getEntity();
                    responseContent = EntityUtils.toString(entity, "UTF-8");
                }
                System.out.println("responseContent:" + responseContent);
            } catch (ClassCastException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (response != null)
                        response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (client != null)
                            client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return responseContent;
        }

}