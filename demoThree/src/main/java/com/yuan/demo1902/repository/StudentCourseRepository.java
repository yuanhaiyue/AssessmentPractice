package com.yuan.demo1902.repository;

import com.yuan.demo1902.entity.StudentCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse,Object> {







}
