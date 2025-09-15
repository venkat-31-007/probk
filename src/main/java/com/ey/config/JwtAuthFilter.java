//package com.ey.config;
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.ey.JWTUtility.JwtUtil;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//@Component
//public class JwtAuthFilter extends OncePerRequestFilter {
//  @Autowired private JwtUtil jwtUtil;
//  @Override protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain chain) throws ServletException,IOException {
//    String h = req.getHeader("Authorization");
//    if(h!=null && h.startsWith("Bearer ")) {
//      String t = h.substring(7);
//      try {
//        String email = jwtUtil.extractEmail(t);
//        String role = jwtUtil.extractRole(t);
//        SimpleGrantedAuthority auth = new SimpleGrantedAuthority("ROLE_" + role);
//        UsernamePasswordAuthenticationToken a = new UsernamePasswordAuthenticationToken(email, null, List.of(auth));
//        SecurityContextHolder.getContext().setAuthentication(a);
//      } catch(Exception e) { System.out.println("Invalid token:" + e.getMessage()); }
//    }
//    chain.doFilter(req, res);
//  }
//}