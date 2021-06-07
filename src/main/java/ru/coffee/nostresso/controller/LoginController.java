package ru.coffee.nostresso.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.VkParamsDto;
import ru.coffee.nostresso.security.LoginService;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/auth")
    public String auth(@RequestBody VkParamsDto params) {
        return loginService.makeToken(params.getUrl());
    }
}
