
/*
 * Author: Ramesh
 * class name: user controller  
 * purpose: we can do  some user rest api operations here.
 */

package com.hcl.miniproject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.miniproject.entities.Menu;
import com.hcl.miniproject.entities.OrderDetails;
import com.hcl.miniproject.entities.User;
import com.hcl.miniproject.exception.OrderNotFoundException;
import com.hcl.miniproject.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/user")
@RestController
@Slf4j
public class UserController {
	@Autowired
	IUserService service;

	// User Registration
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		log.info("user registration executing ");
		return service.registerUser(user);

	}

	// User Login Operation
	@GetMapping("/login/{userName}/{userPassword}")
	public ResponseEntity<String> login(@PathVariable String userName, @PathVariable String userPassword,
			HttpSession session) {
		User use = service.findByuserName(userName);
		ResponseEntity<String> response = null;
		if (use.getUserName().equals(userName) && use.getUserPassword().equals(userPassword)) {
			session.setAttribute("userName", userName);
			session.setAttribute("userPassword", userPassword);
			log.info("user login done sucussfully ");
			response = new ResponseEntity<String>("user login done", HttpStatus.ACCEPTED);
		} else {
			log.info("login fail registration Failed");
			response = new ResponseEntity<String>("user login fail registration Failed", HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	// User Logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("logout method called");
		session.invalidate();
		return "Logout Success";
	}

	public Menu findByItemName(String itemName) {

		return service.findByItemName(itemName);
	}

	public User findByuserName(@PathVariable String userName) {

		return service.findByuserName(userName);
	}

	// User Operation on Menu
	@GetMapping("/showAllMenu")
	public List<Menu> showAllMenu() {

		return service.showAllMenu();
	}

	@PostMapping("/orderItem")
	public String orderItem(@RequestBody OrderDetails orderDetails) throws OrderNotFoundException {

		return service.orderItem(orderDetails);

	}

	@GetMapping("/orderDetails/{userName}")
	public List<OrderDetails> userOrders(@PathVariable String userName) {

		return service.userOrders(userName);
	}

	// Final Bills for the user
	@GetMapping("/finalbill/{userName}")
	public String finalBill(@PathVariable String userName) {
		return service.finalBill(userName);
	}

}
