package com.java.mydoc.controller;

import com.java.mydoc.entity.User;
import com.java.mydoc.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping(value = "/save")
    private String saveUser(@RequestBody User users){
        userServices.saveorUpdate(users);
        return users.get_id();
    }

    @GetMapping(value = "/getAll")
    private Iterable<User>getUsers(){
        return userServices.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private User update(@RequestBody User user,@PathVariable(name="id")String _id){
        user.set_id(_id);
        userServices.saveorUpdate(user);
        return user;
    }

    @DeleteMapping(value = "/delete/{id}")
    private void deleteUser(@PathVariable("id")String _id){
        userServices.deleteUser(_id);
    }

    @RequestMapping(value = "/search/{id}")
    private User getUsers(@PathVariable(name="id")String userId){

        return userServices.getUserById(userId);
    }
}
