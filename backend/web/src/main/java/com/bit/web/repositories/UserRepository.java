package com.bit.web.repositories;

import java.util.Optional;

import com.bit.web.entites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    public Optional<User> findByEmailAndPassword(String email, String password);
    public User findByEmail(String email);
}