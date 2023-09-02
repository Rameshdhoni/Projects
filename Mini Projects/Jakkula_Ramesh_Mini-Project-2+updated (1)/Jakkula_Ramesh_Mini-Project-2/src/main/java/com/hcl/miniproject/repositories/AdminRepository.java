
/*
 * Author: Ramesh
 * interface name: AdminRepository
 * purpose:it extends predefined  JpaRepository interface and create tables using spring data jpa annotations.
*/
package com.hcl.miniproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.miniproject.entities.Admin;
import com.hcl.miniproject.entities.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	public Admin findByadminName(String adminName);

}
