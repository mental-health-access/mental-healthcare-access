package org.launchcode.mentalhealthcareaccess.models.data.dto;

import javax.validation.constraints.NotBlank;

public class RegisterFormDTO extends LoginFormDTO {
    @NotBlank
    private String verifyPassword;
    @NotBlank
    private String firstName;
    private String lastName;
    private String companyName;
    private String displayName;

    @NotBlank
    private String phoneNumber;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getDisplayName() {
        if (firstName != "" && lastName != "") {
            return displayName = lastName + ", " + firstName;
        }
        else {
            return displayName = companyName;
        }

    }


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

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
