package com.bit.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @Lazy
public class UserDTO {
    private String userName, email, password, phone, city; 
}