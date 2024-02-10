package com.java.mydoc.service;

import com.java.mydoc.entity.User;
import com.java.mydoc.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private UserRepo repo;
    public void saveorUpdate(User users) {
        repo.save(users);
    }

    public Iterable<User> listAll() {
        return this.repo.findAll();
    }

    public void deleteUser(String id) {
        repo.deleteById(id);
    }

    public User getUserById(String userId) {
        return repo.findById(userId).get();
    }
}
