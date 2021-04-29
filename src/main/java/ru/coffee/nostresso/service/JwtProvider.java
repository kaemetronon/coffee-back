package ru.coffee.nostresso.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.User;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtProvider {

    //        вынести в конфиг
    private final Long validityInMilliseconds = (long) (1000 * 60 * 20);
    private String jwtSecret = "verysecretkey";


    public String createToken(Long userId, Integer role) {

        Claims claims = Jwts.claims().setSubject(userId.toString());
        if (role == 1)
            claims.put("roles", User.Role.USER);
        if (role == 0)
            claims.put("roles", User.Role.ADMIN);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(jwtSecret.getBytes()))
                .compact();
    }
}
