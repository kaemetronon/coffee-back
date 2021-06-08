package ru.coffee.nostresso.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.coffee.nostresso.model.dto.VkParamsDto;
import ru.coffee.nostresso.model.dto.TokenResponse;
import ru.coffee.nostresso.security.JwtService;
import ru.coffee.nostresso.security.VkParamsParseService;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final VkParamsParseService vkParamsParseService;

    @PostMapping("/auth")
    public TokenResponse login(@RequestBody VkParamsDto vkParams) {

        String params = vkParams.getUrl();
        Authentication authentication;

        if (vkParamsParseService.validateVkParams(params)) {
            String vkId = vkParamsParseService.updateUserInDb(params);
            try {
                authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(vkId, vkId));
            } catch (BadCredentialsException e) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Имя или пароль неправильны", e);
            }
            var jwt = jwtService.makeToken((UserDetails) authentication.getPrincipal());
            return new TokenResponse(jwt);
        }
        return new TokenResponse("Invalid params");
    }
}
