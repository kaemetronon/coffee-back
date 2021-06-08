package ru.coffee.nostresso.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.VkUser;
import ru.coffee.nostresso.model.mapper.VkUserMapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class VkParamsParseService {

    private static final String ENCODING = "UTF-8";
    private final String urlPart = "https://example.com/";

    private final VkUserMapper mapper;

    @Value("${vk.secret}")
    private String clientSecret;

    public String updateUserInDb(String url) {
        Map<String, String> params = makeParamMap(url);
        var id = params.get("vk_user_id");

        if (mapper.findByUsername(id) == null)
            mapper.saveVkUser(new VkUser() {{
                setId(id);
                setPassword(id);
            }});
        return id.toString();
    }

    private Map<String, String> makeParamMap(String url) {
        url = urlPart.concat(url);
        Map<String, String> params = null;
        try {
            return getQueryParams(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean validateVkParams(String url) {

        Map<String, String> params = makeParamMap(url);

        String checkString = params.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .filter(entry -> entry.getKey().startsWith("vk_"))
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> encode(entry.getKey()) + "=" + encode(entry.getValue()))
                .collect(Collectors.joining("&"));

        if (params.get("vk_user_id").isEmpty())
            return false;

        String sign;
        try {
            sign = getHashCode(checkString, clientSecret);
        } catch (Exception e) {
            log.error("error with hashing");
            return false;
        }
        return sign.equals(params.getOrDefault("sign", ""));
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
