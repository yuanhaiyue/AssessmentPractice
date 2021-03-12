package com.yuan.demo.repository;

import com.yuan.demo.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<Shift,Object> {

    Shift findByName(String name);
}
