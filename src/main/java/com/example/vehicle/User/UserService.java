package com.example.vehicle.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import com.example.vehicle.SecurityConfig.JwtUtils;
import com.example.vehicle.SecurityConfig.PasswordConfig;
import com.example.vehicle.payload.LoginRequest;
import com.example.vehicle.payload.SignUpRequest;
import com.example.vehicle.payload.Response.JwtResponse;

@Service
public class UserService {

    // @Autowired
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final PasswordConfig passwordConfig;
    // private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(JwtUtils jwtUtils, UserRepository userRepository, PasswordConfig passwordConfig) {
        // AuthenticationManager authenticationManager) {
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
        this.passwordConfig = passwordConfig;
        // this.authenticationManager = authenticationManager;
    }

    // public User createUser(User user) {
    // return userRepository.save(user);
    // }

    // public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {

    // Authentication authentication = authenticationManager.authenticate(
    // new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
    // loginRequest.getPassword()));

    // SecurityContextHolder.getContext().setAuthentication(authentication);
    // // JwtUtils jwtUtils = new JwtUtils();
    // String jwt = jwtUtils.generateJwtToken(authentication);

    // UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    // return ResponseEntity.ok(new JwtResponse(jwt,
    // // userDetails.getId(),
    // userDetails.getUsername()));
    // // userDetails.getEmail()));
    // }

    public ResponseEntity<?> registerUser(SignUpRequest signUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Email already exists");
        }

        // Create new user's account
        User user = new User(
                null,
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getEmail(),
                passwordConfig.passwordEncode().encode(signUpRequest.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }

}
