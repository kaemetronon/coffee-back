package ru.coffee.nostresso.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.coffee.nostresso.exception.VkParamsException;
import ru.coffee.nostresso.model.entity.VkUser;
import ru.coffee.nostresso.model.mapper.VkUserMapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginService {
    private static final String ENCODING = "UTF-8";
    private final String urlPart = "https://example.com/";

    private final VkUserMapper mapper;

    @Value("${vk.secret}")
    private String clientSecret;

    @Value("${serv.token.expires}")
    private Long tokenExpiresSeconds;

    @Value("${serv.token.secret}")
    private String tokenSecret;

    @Transactional
    public String makeToken(String url) {
        url = urlPart.concat(url);
        Map<String, String> params = null;
        try {
            params = getQueryParams(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (validateVkParams(params)) {
            var vkId = Long.valueOf(params.get("vk_user_id"));
            if (mapper.findByVkId(vkId) == null)
                mapper.saveVkUser(new VkUser() {{
                    setId(vkId);
                }});
            return makeJWT(params);
        }

        else throw new VkParamsException("Bad vk params");
    }

    private boolean validateVkParams(Map<String, String> params) {

        String checkString = params.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .filter(entry -> entry.getKey().startsWith("vk_"))
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
        return sign.equals(params.getOrDefault("sign", ""));
    }

    private String makeJWT(Map<String, String> params) {
        String vkUserId = params.get("vk_user_id");
        String vkAppId = params.get("vk_app_id");
        Long issuedAt = Long.valueOf(params.get("vk_ts"));

        if (vkUserId.isEmpty() || vkAppId.isEmpty())
            throw new RuntimeException();
        Date dateIssuedAt = Date.from(Instant.ofEpochSecond(issuedAt));
        Date dateExpires = Date.from(Instant.ofEpochSecond(issuedAt + tokenExpiresSeconds));

        return Jwts.builder()
                .setIssuer(vkAppId)
                .setSubject(vkUserId)
                .setIssuedAt(dateIssuedAt)
                .setExpiration(dateExpires)
                .signWith(SignatureAlgorithm.HS512, tokenSecret)
                .compact();
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
