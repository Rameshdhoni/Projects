package com.hcl.profilepageadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hcl.profilepageadmin.entities.AdminPostApproval;

/*
 * @Author:Ramesh
 * Date: 23-12-2022
 */
@Repository   
public interface AdminPostApprovalRepo extends JpaRepository<AdminPostApproval,Integer>{


	//Creating automatic tables using entity class name and data type of primary key of table with JpaRepository

}
