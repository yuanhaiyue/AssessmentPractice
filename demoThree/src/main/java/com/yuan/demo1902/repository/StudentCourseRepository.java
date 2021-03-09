package com.yuan.demo1902.repository;

import com.yuan.demo1902.entity.Course;
import com.yuan.demo1902.entity.CourseStudent;
import com.yuan.demo1902.entity.StudentCourse;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse,Object> {
    //    根据学生id 查询学生选课信息
    List<StudentCourse> findByStudentId(Integer id);
    //根据课程名字统计平均分
    @Query("select avg(sc.achievement) from Course c,StudentCourse sc where c.id=sc.courseId and c.name=:cName")
    Double findByName (@Param(value = "cName") String name);



}
