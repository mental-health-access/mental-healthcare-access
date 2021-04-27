package org.launchcode.mentalhealthcareaccess.models.data.dto;

import javax.validation.constraints.NotBlank;

public class RegisterFormDTO extends LoginFormDTO {
    @NotBlank
    private String verifyPassword;
    @NotBlank
    private String name;
    private String lastName;
    @NotBlank
    private String phoneNumber;


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

}
