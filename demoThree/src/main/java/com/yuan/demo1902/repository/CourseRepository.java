package com.yuan.demo1902.repository;


import com.yuan.demo1902.entity.Course;
import com.yuan.demo1902.entity.CourseSelection;
import com.yuan.demo1902.entity.CourseStudent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Object> , PagingAndSortingRepository<Course,Object> {
    //根据课程名称 模糊查询
    List<Course> findByName(String name);
    //根据学分区间 升序排序
    List<Course> findByCreditBetween(Double minC, Double maxC, Sort sort);
    //根据课程名称查询选修该课程的学生的接口，输出学生的（编号，姓名，性别，系部）
    @Query( value = "select new com.yuan.demo1902.entity.CourseStudent(s.code,s.name,s.sex,s.department) " +
            "from Student s,StudentCourse  sc,Course c " +
            "where s.id=sc.studentId and sc.courseId=c.id and c.name=:cName")
    public Page<CourseStudent> getCourse(@Param(value = "cName") String name,Pageable pageable);
//    //根据课程名称查询选修该课程的选课信息的接口，输出学生编号，姓名，性别，系部，选课时间，成绩，分页查询并按学生编号升序排序
    @Query( value = "select new com.yuan.demo1902.entity.CourseSelection(s.code,s.name,s.sex,s.department,sc.selectDate,sc.achievement) " +
            "from Student s,StudentCourse  sc,Course c " +
            "where s.id=sc.studentId and sc.courseId=c.id and c.name=:cName",nativeQuery = true)
    public Page<CourseSelection> getAchievement(@Param(value = "cName") String name, Pageable pageable);

}
