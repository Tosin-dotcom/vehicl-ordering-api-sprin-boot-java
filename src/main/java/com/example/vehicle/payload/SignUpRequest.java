package com.example.vehicle.payload;

import java.util.Objects;

public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public SignUpRequest() {
    }

    public SignUpRequest(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignUpRequest firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public SignUpRequest lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public SignUpRequest email(String email) {
        setEmail(email);
        return this;
    }

    public SignUpRequest password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SignUpRequest)) {
            return false;
        }
        SignUpRequest signUpRequest = (SignUpRequest) o;
        return Objects.equals(firstName, signUpRequest.firstName) && Objects.equals(lastName, signUpRequest.lastName)
                && Objects.equals(email, signUpRequest.email) && Objects.equals(password, signUpRequest.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password);
    }

    @Override
    public String toString() {
        return "{" +
                " firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }

}
