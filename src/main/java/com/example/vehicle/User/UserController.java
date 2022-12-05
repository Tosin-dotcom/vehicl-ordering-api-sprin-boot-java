package com.example.vehicle.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.example.vehicle.Vehicle.Vehicle;
import com.example.vehicle.payload.LoginRequest;
import com.example.vehicle.payload.SignUpRequest;

@RestController
@RequestMapping(path = "api/v1/auth")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "register")
    public ResponseEntity<?> createUser(@RequestBody SignUpRequest userData) {
        System.out.println(userData);
        return userService.registerUser(userData);
    }

    // @PostMapping(path = "login")
    // public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
    // return userService.authenticateUser(loginRequest);
    // }

}
