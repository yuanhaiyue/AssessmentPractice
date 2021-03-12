package com.yuan.demo.controller;


import com.yuan.demo.entity.User;
import com.yuan.demo.repository.UserRepository;
import com.yuan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/select")
    public List<User> select(){
        return userService.selectUser();
    }

    @GetMapping("/delete")
    public void delete(Integer id){
        userService.deleteUser(id);
    }

    @PostMapping("/save")
    public String save(User user){
       return userService.saveUser(user);
    }

    @PostMapping("/selectNamePassword")
    public User select(String name,String password){
        return userService.selectUserNamePassword(name, password);
    }

}
