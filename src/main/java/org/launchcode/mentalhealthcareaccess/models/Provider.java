package org.launchcode.mentalhealthcareaccess.models;

import javax.persistence.Entity;


@Entity
public class Provider extends AbstractEntity {
    private String lastName;
    private String phoneNumber;

    public Provider(){
    }
    public Provider(String lastName, String phoneNumber) {
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

}


