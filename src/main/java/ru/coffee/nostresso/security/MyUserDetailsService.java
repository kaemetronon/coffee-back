package ru.coffee.nostresso.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.VkUser;
import ru.coffee.nostresso.model.mapper.VkUserMapper;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final VkUserMapper userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        VkUser myUser = userRepository.findByUsername(username);
        if (myUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return User.builder()
                .username(myUser.getId())
                .password(myUser.getPassword())
                .roles(myUser.getRole())
                .build();
    }
}