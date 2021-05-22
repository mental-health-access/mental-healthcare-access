package org.launchcode.mentalhealthcareaccess.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserSignupFormDTO extends UserLoginFormDTO {

    @NotNull
    @NotBlank(message = "")
    @Size(min=2,max=30, message = "First name must be between 2 and 30 characters.")
    private String firstName;

    @NotNull
    @NotBlank(message = "")
    @Size(min=2,max=30, message = "Last name must be between 2 and 30 characters.")
    private String lastName;

    @NotNull
    @NotBlank(message = "")
    @Size(min=5,max=30, message = "Invalid password. Must be between 5 and 30 characters.")
    private String verifyPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}