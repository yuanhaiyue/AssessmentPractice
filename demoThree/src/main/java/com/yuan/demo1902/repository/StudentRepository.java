package com.yuan.demo1902.repository;


import com.yuan.demo1902.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Object> {
}
