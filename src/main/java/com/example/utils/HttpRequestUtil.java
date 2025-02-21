package com.example.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class HttpRequestUtil {
    public static HttpResponse sendRequestPost(String url, String json, Map<String, String> headers) {
        HttpResponse result = null;
        try {
            log.info("HTTP-POST请求地址：【{}】", url);
            log.info("HTTP-POST请求内容：【{}】", json);
            result = HttpRequest.post(url).addHeaders(headers).body(json).execute();
            log.info("HTTP-POST请求返回结果：【{}】", result.body());
        } catch (Exception e) {
            log.error("HTTP-POST请求异常：【{}】", e.getMessage(), e);
        }
        return result;
    }
}
