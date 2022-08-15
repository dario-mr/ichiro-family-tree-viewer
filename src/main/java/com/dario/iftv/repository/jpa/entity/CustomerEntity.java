package com.dario.iftv.repository.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    protected CustomerEntity() {
    }

    public CustomerEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("CustomerEntity[id=%d, firstName='%s', lastName='%s']", id,
                firstName, lastName);
    }

}
