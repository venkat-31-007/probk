package com.ey.service;
 
import com.ey.DTO.AuthResponse;
import com.ey.DTO.LoginRequest;
import com.ey.DTO.RegisterRequest;
import com.ey.enums.UserRole;
import com.ey.entity.User;
import com.ey.repository.UserRepository;
import com.ey.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
 
@Service
public class AuthService {
 
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;
 
    // Registration: encode password, set default role
    public User register(RegisterRequest dto) {
        userRepo.findByEmail(dto.getEmail()).ifPresent(u -> {
            throw new RuntimeException("Email already exists");
        });
 
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(UserRole.ROLE_CUSTOMER); // or your preferred default
 
        return userRepo.save(user);
    }
 
    // Login: bcrypt for hashed users, plain for legacy users
    public AuthResponse login(LoginRequest request) {
        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        boolean passwordOk = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!passwordOk) throw new RuntimeException("Invalid password");
        String dbPassword = user.getPassword();
        if (dbPassword.startsWith("$2a$") || dbPassword.startsWith("$2b$") || dbPassword.startsWith("$2y$")) {
            passwordOk = passwordEncoder.matches(request.getPassword(), dbPassword);
        } else {
            passwordOk = request.getPassword().equals(dbPassword);
        }
       
 
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        return new AuthResponse(token, user.getRole().name(), user.getId());
    }
}
 