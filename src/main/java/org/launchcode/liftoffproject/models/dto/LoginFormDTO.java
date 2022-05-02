package org.launchcode.liftoffproject.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDTO {
    @Email
    @NotNull
    @NotBlank
    @Size(min = 3, max = 55, message = "Invalid username. Must be an email address between 3 and 55 characters.")
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 30, message = "Invalid password. Must be between 5 and 30 characters.")
    private String password;


    public LoginFormDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginFormDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
