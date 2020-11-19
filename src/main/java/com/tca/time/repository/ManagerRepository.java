package com.tca.time.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tca.time.model.Manager;


@Repository
public interface ManagerRepository extends  JpaRepository<Manager, Integer>  {

	
}
