package com.ey.entity;

import com.ey.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	@Column(nullable = false, unique = true)
	private String email;
	@NotBlank
	@Size(min = 6)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long u) {
		this.userId = u;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String e) {
		this.email = e;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String p) {
		this.password = p;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole r) {
		this.role = r;
	}
}
