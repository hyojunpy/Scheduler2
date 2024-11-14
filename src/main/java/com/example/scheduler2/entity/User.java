package com.example.scheduler2.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    @Column(nullable = false)
    private String email;

    private String password;

    public User(String userName, String email ,String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public void updateUser(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
