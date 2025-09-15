package com.ey.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.DTO.AuthResponse;
import com.ey.DTO.LoginRequest;
import com.ey.DTO.RegisterRequest;
import com.ey.entity.User;
import com.ey.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private AuthService authService;
	

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest dto) {
		User saved = authService.register(dto);
		return ResponseEntity.status(201).body(saved);
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest dto) {
		AuthResponse resp = authService.login(dto);
		return ResponseEntity.ok(resp);
	}
}
