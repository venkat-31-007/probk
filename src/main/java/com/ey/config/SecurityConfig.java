//package com.ey.config;
//import org.springframework.context.annotation.*; import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.security.web.SecurityFilterChain; import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//@Configuration
//public class SecurityConfig {
//  private final JwtAuthFilter jwtAuthFilter;
//  public SecurityConfig(JwtAuthFilter jwtAuthFilter){ this.jwtAuthFilter = jwtAuthFilter; }
//  @Bean public PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }
//  @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.csrf().disable()
//      .authorizeHttpRequests(auth -> auth
//        .requestMatchers("/api/auth/**").permitAll()
//        .requestMatchers("/api/tables/available").permitAll()
//        .requestMatchers("/api/slots/available").permitAll()
//        .requestMatchers("/api/admin/**").hasRole("ADMIN")
//        .anyRequest().authenticated()
//      )
//      .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//    return http.build();
//  }
//}