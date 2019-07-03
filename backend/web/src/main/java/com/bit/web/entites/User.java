package com.bit.web.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "users")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="user_name") private String userName;
    @Column(name="email") private String email;
    @Column(name="password") private String password;
    @Column(name="phone") private String phone;
    @Column(name="city") private String city;

    @Builder
    private User(String userName, String email, String password, String phone, String city){
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.city = city;
    }
}