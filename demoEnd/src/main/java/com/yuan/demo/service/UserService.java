package com.yuan.demo.service;

import com.yuan.demo.entity.User;
import com.yuan.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String saveUser(User user){
        User user1=userRepository.save(user);
        return user1!=null?"success":"fail";
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);

    }


    public User selectUserNamePassword(String name,String password){
        return userRepository.findByNameAndPassword(name, password);
    }

    public List<User> selectUser(){
        return userRepository.findAll();
    }



}
