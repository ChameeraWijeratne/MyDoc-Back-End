package com.java.mydoc.service;

import com.java.mydoc.entity.User;
import com.java.mydoc.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> findAllByEmail(String email) {
        // Find doctor by email
        List<User> users = repo.findAllByEmail(email);
        if (users == null) {
            // Doctor not found
            return null;
        }
        // Authentication successful
        return users;
    }

    public String getUserIdByEmailAndPassword(String email) {
        // Find user by email
        User user = repo.findByEmail(email);

        if (user != null) {
                return user.get_id();

        }

        // Return null if user not found or password doesn't match
        return null;
    }
}
