package com.yuan.demo1902.repository;


import com.yuan.demo1902.entity.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Object> {
    //根据学生 姓名和密码 查找学生信息
    Student findByNameAndPassword(String name,String password);
    //根据系部查询学生的接口，结果分页查询并按学生编号升序排序
    Page<Student> findByDepartment(String department, Pageable pageable);
    //根据系部和性别查询学生信息
    List<Student> findBySexAndDepartment(String sex,String department);
    //根据学生编号，统计查询该生的平均分
    @Query(value = "select avg(sc.achievement) from Student s,StudentCourse sc where s.id=StudentCourse.id and s.id=:Id order by sc.achievement",nativeQuery = true)
    public double getAchievement(@Param(value = "Id") Integer id);



}
