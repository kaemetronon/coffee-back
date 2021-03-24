package ru.coffee.nostresso.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

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

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {

        var params = vkProvider.getAuthParams(servletRequest.getParameterMap());
        if (params != null) {
            if (vkProvider.doValidate(params)) {
                // save user with authorities USER in db
                System.out.println();
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
            System.out.println();
        }


//
//
//        filterChain.doFilter(req, res);
    }
}
