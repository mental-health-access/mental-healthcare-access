package org.launchcode.mentalhealthcareaccess.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.*;

@MappedSuperclass
public abstract class AbstractUser {

    @Id
    @GeneratedValue
    private int userId;

    @NotNull(message="Username is required.")
    @NotBlank(message="Username is required.")
    @Size(max=22, message="Username is too long")
    protected String username;

    @NotNull(message="First name is required.")
    @NotBlank(message="First name is required.")
    @Size(max=22, message="First name is too long")
    protected String firstName;

    @NotNull(message="Last name is required.")
    @NotBlank(message="Last name is required.")
    @Size(max=22, message="Last name is too long")
    protected String lastName;

    @NotNull(message="Email is required.")
    @NotBlank(message="Email is required.")
    @Size(max=22, message="Email is too long")
    protected String email;

//    @NotNull(message="Password is required.")
//    @NotBlank(message="Password is required.")
//    @Size(max=22, message="Password is too long")
//    private String password;

    @NotNull
    @NotBlank
    protected String pwHash;

    protected static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

