package ru.coffee.nostresso.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VkProvider {
//
//    @Value("${client.secret}")
//    private String clientSecret;
//
//    @Value("${client.app_id}")
//    private String clientAppId;
//
//    @Value("${admin.secret}")
//    private String adminSecret;
//
//    @Value("${admin.app_id}")
//    private String adminAppId;
//
//    public Map<String, String> getAuthParams(ServletRequest req) {
//        Map<String, String> queryParams = new HashMap<>();
//        params.forEach((k, v) -> queryParams.put(k, v[0]));
//
//        var paramsMap = queryParams.entrySet().stream()
//                .filter(e -> e.getValue() != null)
//                .filter(entry -> entry.getKey().startsWith("vk_"))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        var sign = queryParams.get("sign");
//        if (paramsMap.size() != 0 && sign != null) {
//            paramsMap.put("sign", sign);
//            return paramsMap;
//        } else return null;
//    }
//
//    public boolean doValidate(Map<String, String> params) {
//
//        var vkParams = new HashMap<>(params);
//        var vkSign = vkParams.remove("sign");
//
//        String checkString = vkParams.entrySet().stream()
//                .sorted(Map.Entry.comparingByKey())
//                .map(entry -> entry.getKey() + "=" + entry.getValue())
//                .collect(Collectors.joining("&"));
//
//        String sign;
//        try {
//            var appId = vkParams.get("vk_app_id");
//
//            if (appId.equals(clientAppId))
//                sign = getHashCode(checkString, clientSecret);
//            else if (appId.equals(adminAppId))
//                sign = getHashCode(checkString, adminSecret);
//            else throw new Exception();
//        } catch (Exception e) {
//            log.error("error with hashing");
//            return false;
//        }
//        return sign.equals(vkSign);
//    }
//
//    private String getHashCode(String data, String key) throws Exception {
//        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
//        Mac mac = Mac.getInstance("HmacSHA256");
//        mac.init(secretKey);
//        byte[] hmacData = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
//        return new String(Base64.getUrlEncoder().withoutPadding().encode(hmacData));
//    }

}
