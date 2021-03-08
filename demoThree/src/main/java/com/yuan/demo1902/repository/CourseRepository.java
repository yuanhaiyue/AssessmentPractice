package com.yuan.demo1902.repository;


import com.yuan.demo1902.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Object> {
}
