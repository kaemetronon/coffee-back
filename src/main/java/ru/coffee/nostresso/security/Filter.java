package ru.coffee.nostresso.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class Filter extends GenericFilterBean {

    @Value("${vk.secret}")
    private String clientSecret;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {
//        if (ValidateRequest.doValidate(servletRequest.getParameterMap(), clientSecret))
            filterChain.doFilter(req, res);
//        else
//            throw new RuntimeException("Invalid params");
    }
}
