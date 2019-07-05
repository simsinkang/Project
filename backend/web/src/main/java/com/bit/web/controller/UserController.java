package com.bit.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

import javax.persistence.EntityNotFoundException;

import com.bit.web.common.lambda.ISupplier;
import com.bit.web.domain.UserDTO;
import com.bit.web.entites.User;
import com.bit.web.repositories.UserRepository;
import com.bit.web.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired UserService userService;
    @Autowired ModelMapper modelMapper;
    @Autowired UserDTO user;
    @Autowired UserRepository repo;
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    
    @PostMapping("/save")
    public HashMap<String,Object> save(@RequestBody UserDTO dto){
        HashMap<String,Object> map = new HashMap<>();
        User entity = new User();
        entity.setUserName(dto.getUserName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhone());
        entity.setCity(dto.getCity());
        User result = repo.save(entity);
        if(result != null) {
            map.put("result", "회원가입 성공");
        } else {
            map.put("result", "회원 가입 실패");
        }
        return map;
    }
    
    @PostMapping("/login")
    public HashMap<String,Object> login(@RequestBody UserDTO dto){
        System.out.println("email : "+ dto.getEmail());
        System.out.println("PW : "+ dto.getPassword());
        Supplier<HashMap<String,Object>> fx = (()->{
            return userService.login(dto.getEmail(), dto.getPassword());
        });
        return fx.get();
    }

    @GetMapping("")
    public Iterable<UserDTO> findAll(){
        Iterable<User> entities = userService.findAll();
        List<UserDTO> list = new ArrayList<>();
        for(User s: entities){
            UserDTO cust = modelMapper.map(s, UserDTO.class);
            list.add(cust);
        }
        System.out.println(list); 
        return list;
    }

    @GetMapping("/mypage/{id}")
    public UserDTO findById(@PathVariable String id){
        System.out.println("findById로 들어온 ID : "+id);
        return modelMapper.map(repo.findById(Long.parseLong(id)), UserDTO.class);
    }

    @GetMapping("/mypage/{email}")
    public UserDTO findByEmail(@PathVariable String email){
        System.out.println("findById로 들어온 ID : "+email);
        return modelMapper.map(repo.findByEmail(email),UserDTO.class);
    }

    @DeleteMapping("/delete/{email}")
    public HashMap<String, String> deleteById(@RequestBody UserDTO dto){
        HashMap<String, String> map = new HashMap<>();
        User entity = new User();
        entity.setUserName(dto.getUserName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhone());
        entity.setCity(dto.getCity());
        userService.delete(entity);
        map.put("result", "탈퇴 성공");
        return map;  
    }
}