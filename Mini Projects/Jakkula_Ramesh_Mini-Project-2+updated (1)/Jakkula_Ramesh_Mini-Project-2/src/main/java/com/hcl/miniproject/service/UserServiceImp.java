
/*
 * Author: Ramesh
 * interface name: UserServiceImp
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

import com.hcl.miniproject.entities.Menu;
import com.hcl.miniproject.entities.OrderDetails;
import com.hcl.miniproject.entities.User;
import com.hcl.miniproject.exception.OrderNotFoundException;
import com.hcl.miniproject.repositories.MenuRepository;
import com.hcl.miniproject.repositories.OrderDetailsRepository;
import com.hcl.miniproject.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImp implements IUserService {
	@Autowired
	UserRepository userRepo;
	@Autowired
	MenuRepository menuRepo;
	@Autowired
	OrderDetailsRepository orderRepo;
	LocalDate ld = LocalDate.now();

	@Override
	public User findByuserName(String userName) {

		return userRepo.findByuserName(userName);
	}

	// Input Validation Of User
	@Override
	public ResponseEntity<String> registerUser(User user) {
		ResponseEntity<String> response = null;
		User use = userRepo.save(user);
		if (use != null) {
			response = new ResponseEntity<String>("user registration done", HttpStatus.ACCEPTED);
		} else {
			log.info("user registration failed ");
			response = new ResponseEntity<String>("user registration Failed", HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}

	// User Operations
	@Override
	public List<Menu> showAllMenu() {

		return menuRepo.findAll();
	}

	// user Ordering the items with price
	@Override
	public String orderItem(OrderDetails orderDetails) throws OrderNotFoundException {

		int sum = 0;
		Menu menu = menuRepo.findByItemName(orderDetails.getItemName());

		OrderDetails details = new OrderDetails();
		int price = menu.getItemPrice();
		sum = price * orderDetails.getPlates();
		details.setItemName(orderDetails.getItemName());
		details.setTotalAmount(sum);
		details.setUserName(orderDetails.getUserName());
		details.setPlates(orderDetails.getPlates());
		details.setDate(ld);

		orderRepo.save(details);
		return "total amount: " + sum;

	}

	// Finding placed orders by userName
	@Override
	public List<OrderDetails> userOrders(String userName) {

		return orderRepo.findByUserName(userName);
	}

	@Override
	public Menu findByItemName(String itemName) {
		// TODO Auto-generated method stub
		return menuRepo.findByItemName(itemName);
	}

	// User final bill
	@Override
	public String finalBill(String userName) {

		List<OrderDetails> detail = orderRepo.findByUserName(userName);
		LocalDate ld = LocalDate.now();
		int sum = 0;
		for (OrderDetails order : detail) {
			if (ld.equals(order.getDate())) {
				sum = sum + order.getTotalAmount();
			}
		}
		return "final Bill: " + sum;
	}
}
