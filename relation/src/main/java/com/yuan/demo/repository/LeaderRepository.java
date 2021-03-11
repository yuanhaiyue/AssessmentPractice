package com.yuan.demo.repository;



import com.yuan.demo.entity.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderRepository extends  JpaRepository<Leader,Object>{

}
