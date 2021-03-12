package com.yuan.demo.repository;

import com.yuan.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Object> {

    Department findByName(String name);
    Department findOneByName(String name);
    Department getByName(String name);

    @Query("from Department d join fetch d.users")
    public Department findOne(Integer id);

}
