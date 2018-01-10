package com.wodaibao.report.common.util;

import com.alibaba.druid.support.json.JSONUtils;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 推荐使用
 * http工具类
 *
 */
public class HttpUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);

    private static Map<String, String> cookieMap = new HashMap<String, String>(64);

    /**
     * post请求
     * 
     * @param url url
     * @param params params
     *
     */
    public static ResponseEntity<String> sendPost(String url, Map<String, String> params) {
        ResponseEntity<String> rr = null;
        CookieStore cookieStore = new BasicCookieStore();
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setCookieStore(cookieStore);

        RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();

        // 填充登陆请求中基本的参数
        try {
            HttpPost post = new HttpPost(url);

            // 设置参数
            if (null != params && !params.isEmpty()) {
                List<NameValuePair> valuePairs = new LinkedList<NameValuePair>();
                for (Map.Entry<String, String> m : params.entrySet()) {
                    BasicNameValuePair baseNameValue = new BasicNameValuePair(m.getKey(), m.getValue());
                    valuePairs.add(baseNameValue);
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
                post.setEntity(entity);
            }

            // 设置头信息，模仿firefox
            post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:47.0) Gecko/20100101 Firefox/47.0");
            post.setHeader("Connection", "keep-alive");
            post.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
            post.setHeader("Accept-Encoding", "gzip, deflate");
            post.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
            // 请求
            CloseableHttpResponse response = httpClient.execute(post, localContext);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);
            log.info("访问url：" + url + "状态status:" + response.getStatusLine());

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 302) {
                String locationUrl = response.getLastHeader("Location").getValue();
                sendPost(locationUrl, null);
            }

            if (statusCode == 200) {
                rr = ResponseEntity.ok(s);
            }

            if (statusCode == 404 || statusCode == 500) {
                log.error("访问url：" + url + "状态status:" + response.getStatusLine() + ",请求参数==>" + JSONUtils.toJSONString(params));
            }

        }
        catch (Exception e) {
            log.error("请求出现错误,url:" + url, e);
        }
        finally {
            try {
                httpClient.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rr;
    }

    public static void main(String[] args) {
        String url = "http://192.168.1.128:8080/rfqserver/wechat/admin/carPart/carPartUpload";
        Map<String, String> params = new HashMap();
        Map<String, File> fileParams = new HashMap();
        params.put("receiveCarId", "1");
        fileParams.put("file", new File("d:/询价审批单.xls"));
    }

    private static String setCookie(HttpResponse httpResponse) {
        Header headers[] = httpResponse.getHeaders("Set-Cookie");
        if (headers == null || headers.length == 0) {
            return null;
        }
        String cookie = "";
        for (int i = 0; i < headers.length; i++) {
            cookie += headers[i].getValue();
            if (i != headers.length - 1) {
                cookie += ";";
            }
        }
        String cookies[] = cookie.split(";");
        for (String c : cookies) {
            c = c.trim();
            if (cookieMap.containsKey(c.split("=")[0])) {
                cookieMap.remove(c.split("=")[0]);
            }
            cookieMap.put(c.split("=")[0],
                          c.split("=").length == 1 ? "" : (c.split("=").length == 2 ? c.split("=")[1] : c.split("=", 2)[1]));
        }
        String cookiesTmp = "";
        for (String key : cookieMap.keySet()) {
            cookiesTmp += key + "=" + cookieMap.get(key) + ";";
        }
        return cookiesTmp.substring(0, cookiesTmp.length() - 2);
    }
}
