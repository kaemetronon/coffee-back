package ru.coffee.nostresso.security;

import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RequestProvider {

    public Map<String, String> getParams(ServletRequest req) {
        var params = req.getParameterMap();
        Map<String, String> queryParams = new HashMap<>();
        params.forEach((k, v) -> queryParams.put(k, v[0]));

        var isVk = queryParams.entrySet().stream()
                .anyMatch(entry -> entry.getKey().startsWith("vk_"));
        if (isVk) {
            queryParams.put("vk", null);
            var paramsMap = queryParams.entrySet().stream()
                    .filter(e -> e.getValue() != null)
                    .filter(entry -> entry.getKey().startsWith("vk_"))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            var sign = queryParams.get("sign");
            if (sign != null)
                paramsMap.put("sign", sign);
            return paramsMap;
        }

        String bearerToken = ((HttpServletRequest) req).getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer_")) {

//            return bearerToken.substring(7);
        }
        return null;


    }
}
