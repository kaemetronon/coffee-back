package ru.coffee.nostresso.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.coffee.nostresso.service.user.IUserService;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class Filter extends GenericFilterBean {

    private final JwtProvider jwtProvider;
    private final VkProvider vkProvider;
    private final IUserService userService;

    @Value("${client.app_id}")
    private String clientAppId;

    @Value("${admin.app_id}")
    private String adminAppId;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {

        var params = vkProvider.getAuthParams(servletRequest.getParameterMap());
        if (params != null) {
            if (vkProvider.doValidate(params)) {
                var appId = params.get("vk_app_id");
                var userId = Long.parseLong(params.get("vk_user_id"));
                if (appId.equals(clientAppId))
                    userService.addUser(userId);
                else if (appId.equals(adminAppId))
                    userService.addAdmin(userId);
            } else {
                throw new RuntimeException("bad params");
            }
        } else {
            var token = jwtProvider.resolveToken((HttpServletRequest) servletResponse);
            if (token != null && jwtProvider.validateToken(token)) {
                Authentication auth = jwtProvider.getAuthentication(token);
                if (auth != null) {
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }
        throw new RuntimeException("нет ни параметров запуска, ни токена");
//        filterChain.doFilter(req, res);
    }
}
