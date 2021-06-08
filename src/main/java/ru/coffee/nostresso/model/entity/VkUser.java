package ru.coffee.nostresso.model.entity;

import lombok.Data;

@Data
public class VkUser {
    private String id;
    private String password;
    private String role;
    public String getPassword() {
        return id;
    }
    public String getRole() {
        return "USER";
    }
}
