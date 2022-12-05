package com.example.vehicle.payload.Response;

import java.util.Objects;

public class JwtResponse {
    private String token;
    // private String type = "Bearer";
    private Long id;
    private String username;
    private String email;

    public JwtResponse() {
    }

    public JwtResponse(String token, String email) {

    }

    public JwtResponse(String token, Long id, String username, String email) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JwtResponse token(String token) {
        setToken(token);
        return this;
    }

    public JwtResponse id(Long id) {
        setId(id);
        return this;
    }

    public JwtResponse username(String username) {
        setUsername(username);
        return this;
    }

    public JwtResponse email(String email) {
        setEmail(email);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JwtResponse)) {
            return false;
        }
        JwtResponse jwtResponse = (JwtResponse) o;
        return Objects.equals(token, jwtResponse.token) && Objects.equals(id, jwtResponse.id)
                && Objects.equals(username, jwtResponse.username) && Objects.equals(email, jwtResponse.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, id, username, email);
    }

    @Override
    public String toString() {
        return "{" +
                " token='" + getToken() + "'" +
                ", id='" + getId() + "'" +
                ", username='" + getUsername() + "'" +
                ", email='" + getEmail() + "'" +
                "}";
    }

}
