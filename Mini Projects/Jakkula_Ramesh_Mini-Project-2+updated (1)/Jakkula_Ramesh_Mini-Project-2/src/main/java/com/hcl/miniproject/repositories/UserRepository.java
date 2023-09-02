
package com.hcl.miniproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.miniproject.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByuserName(String userName);

}
