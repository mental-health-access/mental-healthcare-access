package org.launchcode.mentalhealthcareaccess.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginFormDTO {

    @NotNull
    @NotBlank(message = "")
    @Size(min=7, max=30, message = "Email address must be between 7 and 30 characters.")
    private String email;

    @NotNull
    @NotBlank(message = "")
    @Size(min=5,max=30, message = "Invalid password. Must be between 5 and 30 characters.")
    private String password;

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