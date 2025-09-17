package com.ey.controller;
 
import com.ey.DTO.LoginRequest;
import com.ey.DTO.RegisterRequest;
import com.ey.DTO.AuthResponse;
import com.ey.entity.User;
import com.ey.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
 
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterRequest dto) {
        User savedUser = authService.register(dto);
        return ResponseEntity.status(201).body(savedUser);
    }
 
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest dto) {
        AuthResponse loggedInUser = authService.login(dto);
        return ResponseEntity.ok(loggedInUser);
    }
}
 