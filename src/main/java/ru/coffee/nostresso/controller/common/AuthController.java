package ru.coffee.nostresso.controller.common;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.nostresso.service.JwtProvider;

import java.net.http.HttpRequest;

@RestController("auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtProvider jwtProvider;

    @GetMapping("/client-auth")
    public String authClient(
            @RequestParam("vk_user_id") Long userId) {
        return jwtProvider.createToken(userId, 1);
    }
}
