package com.ey.DTO;

public class AuthResponse {
private String token;
private String role;
private Long userId;

public AuthResponse(String token, String role, Long userId) {
	super();
	this.token = token;
	this.role = role;
	this.userId = userId;
}


public String getToken() {
	return token;
}


public String getRole() {
	return role;

}


public Long getUserId() {
	return userId;
}


public void setUserId(Long userId) {
	this.userId = userId;
}

}
