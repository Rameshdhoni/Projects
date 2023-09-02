
/*
 * Author: Ramesh
 * interface name: AdminServiceImp
 * purpose:unimplementd methods declared here and do some operation to achieve abstraction
 * 
 */
package com.hcl.miniproject.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.miniproject.entities.Admin;
import com.hcl.miniproject.entities.Menu;
import com.hcl.miniproject.entities.OrderDetails;
import com.hcl.miniproject.entities.User;
import com.hcl.miniproject.exception.MenuNotFoundException;
import com.hcl.miniproject.exception.UserNotFoundException;
import com.hcl.miniproject.repositories.AdminRepository;
import com.hcl.miniproject.repositories.MenuRepository;
import com.hcl.miniproject.repositories.OrderDetailsRepository;
import com.hcl.miniproject.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImp implements IAdminService {
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	MenuRepository menuRepo;
	@Autowired
	OrderDetailsRepository orderRepo;
	LocalDate ld = LocalDate.now();

	@Override
	public Admin findByadminName(String adminName) {

		return adminRepo.findByadminName(adminName);
	}

	// Input Validation Of ADMIN
	@Override
	public ResponseEntity<String> registerAdmin(Admin admin) {
		ResponseEntity<String> response = null;
		Admin admi = adminRepo.save(admin);
		if (admi != null) {
			response = new ResponseEntity<String>("admin registration done", HttpStatus.ACCEPTED);
		} else {
			log.info("admin registration failed ");
			response = new ResponseEntity<String>("admin registration Failed", HttpStatus.NOT_ACCEPTABLE);

		}
		return response;
	}

	// User CRUD Operations By Admin
	@Override
	public User addUser(User user) {

		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		User exit = userRepo.findById(user.getUserId()).orElse(null);
		if (exit == null) {
			throw new UserNotFoundException();
		}
		try {
			exit.setUserName(user.getUserName());
			exit.setUserPassword(user.getUserPassword());
			return userRepo.save(user);
		} catch (Exception e) {
			throw new UserNotFoundException();
		}
	}

	@Override
	public String deleteUser(long userId) {
		try {
			userRepo.deleteById(userId);
			return "User Detail deleted SucussFully";
		} catch (Exception e) {
			throw new UserNotFoundException();

		}
	}

	@Override
	public List<User> displayUsers() {

		return userRepo.findAll();
	}

//Menu CRUD Operation By ADMIN
	@Override
	public Menu addMenu(Menu menu) {

		return menuRepo.save(menu);
	}

	@Override
	public Menu updateMenu(Menu menu) {
		Menu exit = menuRepo.findById(menu.getItemId()).orElse(null);
		if (exit == null) {
			throw new MenuNotFoundException();
		}
		try {
			exit.setItemId(menu.getItemId());
			exit.setItemName(menu.getItemName());
			exit.setItemPrice(menu.getItemPrice());
			return menuRepo.save(menu);
		} catch (Exception e) {
			throw new MenuNotFoundException();
		}
	}

	@Override
	public String deleteMenuById(long itemId) {
		try {
			menuRepo.deleteById(itemId);
			return " Item Deleted SucussFully";
		} catch (Exception e) {
			throw new MenuNotFoundException();

		}
	}

	@Override
	public List<Menu> displayMenu() {

		return menuRepo.findAll();
	}
	// ADMIN operation related to bills

	public List<OrderDetails> showallBillsToday() {

		return orderRepo.findByDate(ld);

	}

	@Override
	public List<OrderDetails> findByDate(LocalDate ld) {
		// TODO Auto-generated method stub
		return orderRepo.findByDate(ld);
	}

	public String totalMonthlyBill() {

		List<OrderDetails> list = orderRepo.findAll();
		int total = 0;

		for (OrderDetails order : list) {
			total = total + order.getTotalAmount();
		}

		return "Total monthly amount : " + total;
	}
}
