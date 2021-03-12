package com.yuan.demo.repository;

import com.yuan.demo.entity.CheckWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CheckWorkRepository extends JpaRepository<CheckWork,Object> {

    @Query("from CheckWork c,Shift s where s.name=:name and c.workDate between :min and :max")
    CheckWork getWorkDateName(@Param(value = "name") String name, @Param(value = "min") Date min, @Param(value = "max")Date max);

}
