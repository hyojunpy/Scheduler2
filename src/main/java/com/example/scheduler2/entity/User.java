package com.example.scheduler2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;


@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NonNull
    @Size(max = 4, message = "유저명은 4글자이내입니다.")
    @Pattern(regexp = "^[ㄱ-ㅎ|가-힣]*$", message ="영문 및 한글만 입력 가능합니다.")
    private String userName;

    @Column(nullable = false)
    @Email(regexp = "^[a-zA-Z0-9]+@[0-9a-zA-Z]+\\.[a-z]$", message = "올바른 양식이 아닙니다.")
    private String email;

    private String password;

    public User(String userName, String email, String password) {
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
