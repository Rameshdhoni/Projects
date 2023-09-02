/*
 * Author: Ramesh
 * class name: Admin controller  
 * purpose: we can do some admin operations here using rest api.
 */

package com.hcl.miniproject.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.miniproject.entities.Admin;
import com.hcl.miniproject.entities.Menu;
import com.hcl.miniproject.entities.OrderDetails;
import com.hcl.miniproject.entities.User;
import com.hcl.miniproject.exception.AdminNotFoundException;
import com.hcl.miniproject.exception.MenuNotFoundException;
import com.hcl.miniproject.exception.UserNotFoundException;
import com.hcl.miniproject.service.IAdminService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/admin")
@RestController
@Slf4j
public class AdminController {
	@Autowired
	IAdminService service;

	// ADMIN Registration
	@PostMapping("/register")
	public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
		log.info("Admin registeration ");
		return service.registerAdmin(admin);
	}

	// ADMIN Login Operation
	@GetMapping("/login/{adminName}/{adminPassword}")
	public ResponseEntity<String> login(@PathVariable String adminName, @PathVariable String adminPassword,
			HttpSession session) {
		Admin admi = service.findByadminName(adminName);
		log.info("Admin Login operation excuting");
		ResponseEntity<String> response = null;
		if (admi.getAdminName().equalsIgnoreCase(adminName) && admi.getAdminPassword().equals(adminPassword)) {
			session.setAttribute("adminName", adminName);
			session.setAttribute("adminPassword", adminPassword);
			response = new ResponseEntity<String>("admin login done succussfully", HttpStatus.ACCEPTED);
		} else {

			response = new ResponseEntity<String>("admin login fail registration Failed", HttpStatus.BAD_REQUEST);

		}
		return response;
	}

	// ADMIN Logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("logout method called");
		session.invalidate();
		return "Logout Success";
	}

	public Admin findByadminName(String adminName) {

		return service.findByadminName(adminName);
	}

	// USER CRUD OPERATION BY ADMIN
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		log.info("adduser by Admin operation started");
		return service.addUser(user);
	}

	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user)  {

		return service.updateUser(user);
	}

	@DeleteMapping("/deleteuser/{userId}")
	public String deleteUser(@PathVariable long userId)  {
		log.info("deleteuser by Admin operation started");
		return service.deleteUser(userId);

	}

	@GetMapping("/displayuser")
	public List<User> displayUsers() {
		log.info("display user by Admin operation started");
		return service.displayUsers();
	}

	// Menu CRUD Operations By ADMIN
	@PostMapping("/addmenu")
	public Menu addMenu(@RequestBody Menu menu) {
		log.info("add menu by Admin operation started");
		return service.addMenu(menu);
	}

	@PutMapping("/updatemenu")
	public Menu updateMenu(@RequestBody Menu menu) throws MenuNotFoundException {

		return service.updateMenu(menu);
	}

	@DeleteMapping("/deletemenu/{itemId}")
	public String deleteMenuById(@PathVariable long itemId) {

		return service.deleteMenuById(itemId);
	}

	@GetMapping("/displaymenu")
	public List<Menu> displayMenu() {
		log.info("diaplay menu by Admin operation started");
		return service.displayMenu();
	}

	// Operation Related to billings
	@GetMapping("/billGeneratedToday")
	public List<OrderDetails> showallBillsToday() {

		return service.showallBillsToday();
	}

	@GetMapping("/TotalMonthlybill")
	public String totalMonthlyBill() {
		return service.totalMonthlyBill();
	}

}
