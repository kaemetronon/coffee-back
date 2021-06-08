package ru.coffee.nostresso.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminUser {
    private Integer id;
    private String username;
    private String password;
    private String role;
}
