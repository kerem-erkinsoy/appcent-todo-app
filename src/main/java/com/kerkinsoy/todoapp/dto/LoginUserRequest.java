package com.kerkinsoy.todoapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginUserRequest {

    @NotBlank
    @Size(min = 3,max = 20)
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    public LoginUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
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
