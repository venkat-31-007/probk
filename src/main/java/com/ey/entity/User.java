package com.ey.entity;
 
import jakarta.persistence.*;
import com.ey.enums.UserRole;
 
@Entity
@Table(name = "users")  // Assuming your database table is named 'users'
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
 
    private String name;
 
    @Column(unique = true, nullable = false)
    private String email;
 
    @Column(nullable = false)
    private String password;
 
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;
 
    // Constructors
    public User() {}
 
    public User(String name, String email, String password, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
 
    // Getters and Setters
 
    public Long getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public UserRole getRole() {
        return role;
    }
 
    public void setRole(UserRole role) {
        this.role = role;
    }
}
 