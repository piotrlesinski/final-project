package com.github.xenteros.dto;

import com.github.xenteros.model.User;

public class UserDto {

    private String uuid;
    private String email;
    private String password;

    public UserDto() {
    }

    public UserDto(User that) {
        this.email = that.getEmail();
        this.password = that.getPassword();
        this.uuid = that.getUuid();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
