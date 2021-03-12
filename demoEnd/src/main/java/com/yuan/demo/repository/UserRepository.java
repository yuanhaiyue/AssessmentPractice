package com.yuan.demo.repository;

import com.yuan.demo.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Object> {

       User findByNameAndPassword(String name,String password);


}
