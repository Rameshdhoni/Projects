/*
 * Author: Ramesh
 * interface name: MenuRepository
 * purpose:it extends predefined  JpaRepository interface and create tables using spring data jpa annotations.
*/

package com.hcl.miniproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.miniproject.entities.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
	public Menu findByItemName(String itemName);
}
