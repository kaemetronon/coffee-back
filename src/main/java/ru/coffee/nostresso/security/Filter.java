package ru.coffee.nostresso.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.coffee.nostresso.service.user.IUserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class Filter extends OncePerRequestFilter {

    private final RequestProvider provider;
    private final IUserService userService;

    @Value("${client.app_id}")
    private String clientAppId;

    @Value("${admin.app_id}")
    private String adminAppId;

    @Override
    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        if (!req.getRequestURI().contains("client-auth")) {
            var params = provider.getParams(req);
//        if (params != null) {
//            if (vkProvider.doValidate(params)) {
//                var appId = params.get("vk_app_id");
//                var userId = Long.parseLong(params.get("vk_user_id"));
////                if (appId.equals(clientAppId))
////                    userService.addUser(userId);
////                else if (appId.equals(adminAppId))
////                    userService.addAdmin(userId);
////            } else {
////                throw new RuntimeException("bad params");
//            }
//        } else {
//            var token = jwtProvider.resolveToken((HttpServletRequest) servletResponse);
//            if (token != null && jwtProvider.validateToken(token)) {
//                Authentication auth = jwtProvider.getAuthentication(token);
//                if (auth != null) {
//                    SecurityContextHolder.getContext().setAuthentication(auth);
//                }
//            }
//        }
//        throw new RuntimeException("нет ни параметров запуска, ни токена");
        }

        res.setHeader("Access-Control-Allow-Origin", "*");
        filterChain.doFilter(req, res);
    }
}
