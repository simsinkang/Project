package com.bit.web.service;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

import com.bit.web.domain.UserDTO;
import com.bit.web.entites.User;
import com.bit.web.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired UserRepository userRepository;

    public User save(User entity){
        return userRepository.save(entity);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public HashMap<String, Object> login(String email, String password) {
        Function<UserRepository, HashMap<String,Object>> loginCheck = s -> {
            HashMap<String,Object> result = new HashMap<>();
            Optional<User> check = s.findByEmailAndPassword(email, password);
            if (check.isPresent()) {
                result.put("result", "로그인 성공");
                result.put("user", check.get());
            } else {
                result.put("result", "로그인 실패");
            }
            return result;
        };

        return loginCheck.apply(userRepository);
    }

    public void delete(User entity){
        userRepository.delete(entity);
    }
}