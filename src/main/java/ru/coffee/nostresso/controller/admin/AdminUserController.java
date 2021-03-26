package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.User;
import ru.coffee.nostresso.security.JwtProvider;
import ru.coffee.nostresso.service.user.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/user")
@AllArgsConstructor
public class AdminUserController {

    private final IUserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;


    @PostMapping("login")
    public ResponseEntity login(@RequestBody String userId) {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, null));
            UserDetails user = userService.loadUserByUsername(userId);

            if (user == null) {
                throw new UsernameNotFoundException("User with id: " + userId + " not found");
            }

            String token = jwtProvider.createToken(userId, user.getAuthorities());

            Map<Object, Object> response = new HashMap<>();
            response.put("id", userId);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("User is invalid");
        }
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/")
    public Long addAdmin(@RequestBody Long id) {
        return userService.addAdmin(id);
    }

    @DeleteMapping("/")
    public String deleteUser(@RequestParam Long userId) {
        userService.deleteById(userId);
        return "user " + userId + " deleted";
    }
}

