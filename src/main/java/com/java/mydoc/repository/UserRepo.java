package com.java.mydoc.repository;

import com.java.mydoc.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<User,String> {
    List<User> findAllByEmail(String email);

    User findByEmail(String email);
}
