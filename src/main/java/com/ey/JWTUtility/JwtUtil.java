package com.ey.JWTUtility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
	private final SecretKey SECRET = Keys.hmacShaKeyFor("change_this_to_32+_chars_minimum_long_secret_key".getBytes());
	private final long EXP = 1000L * 60 * 60;

	public String generateToken(String email, String role) {
		return Jwts.builder().setSubject(email).claim("role", role).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXP)).signWith(SECRET).compact();
	}

	public String extractEmail(String token) {
		return Jwts.parserBuilder().setSigningKey(SECRET).build().parseClaimsJws(token).getBody().getSubject();
	}

	public String extractRole(String token) {
		return Jwts.parserBuilder().setSigningKey(SECRET).build().parseClaimsJws(token).getBody().get("role",
				String.class);
	}
}