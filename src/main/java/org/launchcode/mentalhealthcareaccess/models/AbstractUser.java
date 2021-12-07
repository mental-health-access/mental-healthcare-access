package org.launchcode.mentalhealthcareaccess.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractUser extends AbstractEntity {


    protected String firstName;


    protected String lastName;


    protected String email;

    protected String pwHash;

    protected static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }
}