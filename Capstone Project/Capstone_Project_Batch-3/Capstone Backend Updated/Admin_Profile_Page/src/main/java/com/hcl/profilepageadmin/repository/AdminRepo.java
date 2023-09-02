package com.hcl.profilepageadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.profilepageadmin.entities.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer>{
	//Creating automatic tables using entity class name and data type of primary key of table with JpaRepository

}
