package com.ey.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ey.DTO.AuthResponse;
import com.ey.DTO.LoginRequest;
import com.ey.DTO.RegisterRequest;
import com.ey.JWTUtility.JwtUtil;
import com.ey.entity.User;
import com.ey.enums.UserRole;
import com.ey.exception.EmailAlreadyExistsException;
import com.ey.exception.UserNotFoundException;
import com.ey.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepo;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtUtil jwtUtil;

	public User register(RegisterRequest dto) {
		userRepo.findByEmail(dto.getEmail()).ifPresent(u -> {
			throw new EmailAlreadyExistsException("Email already exists");
		});
		User u = new User();
		u.setName(dto.getName());
		u.setEmail(dto.getEmail());
		u.setPassword(dto.getPassword());
		u.setRole(UserRole.ROLE_CUSTOMER);
		return userRepo.save(u);
	}

	public AuthResponse login(LoginRequest dto) {
		User user = userRepo.findByEmail(dto.getEmail())
				.orElseThrow(() -> new UserNotFoundException("Invalid credentials"));
		
		String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
		return new AuthResponse(token, user.getRole().name(),user.getUserId());
	}
}