package com.example.utils;

import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DeepSeekContentUtil {
    private static final String API_KEY = "sk-1e0975d06e2f4890ba061b3fccf1bded";
    private static final String BASE_URL = "https://api.deepseek.com";
    private static final String SILI_KEY = "sk-ghndbcwdjwhrjzsfglsuyphltsiyvazxtoinohodzfgluvih";

    private static final String SILI_URL = "https://api.siliconflow.cn";

    public static void main(String[] args) {
        getDeepSeekContent("你好");
    }

    public static String getDeepSeekContent(String userQuestion) {
        JSONArray messages = new JSONArray();
        JSONObject userMessage = new JSONObject();
        userMessage.put("role", "user");
        userMessage.put("content", userQuestion);
        messages.add(userMessage);
        sendMessage(messages);
        return "";
    }

    private static JSONObject sendMessage(JSONArray messages) {
        String url = SILI_URL + "/v1/chat/completions";
        JSONObject payload = new JSONObject();
        payload.put("model", "deepseek-ai/DeepSeek-R1-Distill-Llama-70B");
        payload.put("messages", messages);
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + SILI_KEY);
        headers.put("Content-Type", "application/json");
        HttpResponse httpResponse = HttpRequestUtil.sendRequestPost(url, payload.toString(), headers);
        if (httpResponse != null && httpResponse.isOk()) {
            log.info("success");
        }
        return null;
    }
}
