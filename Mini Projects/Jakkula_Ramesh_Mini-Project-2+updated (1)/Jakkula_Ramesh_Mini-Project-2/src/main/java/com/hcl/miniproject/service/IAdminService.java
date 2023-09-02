
/*
 * Author: Ramesh
 * interface name: IAdminService
 * purpose: implemented methods  declare some methods and 
 */
package com.hcl.miniproject.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hcl.miniproject.entities.Admin;
import com.hcl.miniproject.entities.Menu;
import com.hcl.miniproject.entities.OrderDetails;
import com.hcl.miniproject.entities.User;
import com.hcl.miniproject.exception.MenuNotFoundException;
import com.hcl.miniproject.exception.UserNotFoundException;

public interface IAdminService {
	public Admin findByadminName(String adminName);

	public ResponseEntity<String> registerAdmin(Admin admin);

	// User CRUD Operation By ADMIN
	public User addUser(User user);

	public User updateUser(User user) ;

	public String deleteUser(long userId) ;

	public List<User> displayUsers();

	// Menu CRUD Operation By ADMIN

	public Menu addMenu(Menu menu);

	public Menu updateMenu(Menu menu) throws MenuNotFoundException;

	public String deleteMenuById(long itemId) ;

	public List<Menu> displayMenu();

// Operation related to billings
	public List<OrderDetails> findByDate(LocalDate ld);

	public List<OrderDetails> showallBillsToday();

	public String totalMonthlyBill();

}
