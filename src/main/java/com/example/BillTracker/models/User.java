package com.example.BillTracker.models;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class User extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

//    public User(String firstName, String lastName, String password, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//        this.email = email;
//    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassword(), getId());
    }

    @Override
    public boolean isMatchingPassword(String password) {
        return true;
    }
}