//package com.ey.config;
//
//import com.ey.entity.User;
//import com.ey.enums.UserRole;
//import com.ey.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class DataInitializer {
//	@Bean
//	CommandLineRunner init(UserRepository repo, PasswordEncoder encoder) {
//		return args -> {
//			String email = "admin@restaurant.com";
//			if (repo.findByEmail(email).isEmpty()) {
//				User a = new User();
//				a.setName("Admin");
//				a.setEmail(email);
//				a.setPassword(encoder.encode("Admin@123"));
//				a.setRole(UserRole.ROLE_ADMIN);
//				repo.save(a);
//				System.out.println("Admin created");
//			}
//		};
//	}
//}
