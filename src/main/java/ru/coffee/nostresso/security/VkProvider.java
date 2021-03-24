package ru.coffee.nostresso.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VkProvider {
    private static final String ENCODING = "UTF-8";

    @Value("${client.secret}")
    private String clientSecret;

    public Map<String, String> getAuthParams(Map<String, String[]> params) {
        Map<String, String> queryParams = new HashMap<>();
        params.forEach((k, v) -> queryParams.put(k, v[0]));

        var paramsMap = queryParams.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .filter(entry -> entry.getKey().startsWith("vk_"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        var sign = queryParams.get("sign");
        if (paramsMap.size() != 0 && sign != null) {
            paramsMap.put("sign", sign);
            return paramsMap;
        } else return null;
    }

    public boolean doValidate(Map<String, String> params) {

        var vkParams = new HashMap<>(params);
        var vkSign = vkParams.remove("sign");

        String checkString = vkParams.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> encode(entry.getKey()) + "=" + encode(entry.getValue()))
                .collect(Collectors.joining("&"));

        String sign;
        try {
            sign = getHashCode(checkString, clientSecret);
        } catch (Exception e) {
            log.error("error with hashing");
            return false;
        }
        return sign.equals(vkSign);
    }

    private Map<String, String> getQueryParams(URL url) {
        final Map<String, String> result = new LinkedHashMap<>();
        final String[] pairs = url.getQuery().split("&");

        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            String key = idx > 0 ? decode(pair.substring(0, idx)) : pair;
            String value = idx > 0 && pair.length() > idx + 1 ? decode(pair.substring(idx + 1)) : null;
            result.put(key, value);
        }
        return result;
    }

    private String getHashCode(String data, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(ENCODING), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        byte[] hmacData = mac.doFinal(data.getBytes(ENCODING));
        return new String(Base64.getUrlEncoder().withoutPadding().encode(hmacData));
    }

    private String decode(String value) {
        try {
            return URLDecoder.decode(value, ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return value;
    }

    private String encode(String value) {
        try {
            return URLEncoder.encode(value, ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return value;
    }
}
