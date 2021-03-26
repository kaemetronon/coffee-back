package ru.coffee.nostresso.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.coffee.nostresso.service.user.IUserService;

@RequiredArgsConstructor
public class Configurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final JwtProvider jwtProvider;
    private final VkProvider vkProvider;
    private final IUserService userService;

    @Override
    public void configure(HttpSecurity httpSecurity) {
        Filter filter = new Filter(jwtProvider, vkProvider, userService);
        httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
