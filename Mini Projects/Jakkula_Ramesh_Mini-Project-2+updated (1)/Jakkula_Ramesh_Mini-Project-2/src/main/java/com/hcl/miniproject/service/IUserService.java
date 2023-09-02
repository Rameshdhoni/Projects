
/*
 * Author: Ramesh
 * interface name: IUserService
 * purpose: implemented methods  declare some methods and 
 */

package com.hcl.miniproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hcl.miniproject.entities.Menu;
import com.hcl.miniproject.entities.OrderDetails;
import com.hcl.miniproject.entities.User;
import com.hcl.miniproject.exception.OrderNotFoundException;

public interface IUserService {

	public User findByuserName(String userName);

	public Menu findByItemName(String itemName);

	// User registrations
	public ResponseEntity<String> registerUser(User user);

	// user operation on menu
	public String orderItem(OrderDetails orderDetails) throws OrderNotFoundException;

	public List<OrderDetails> userOrders(String userName);

	public List<Menu> showAllMenu();

	// displays final bill of the user
	public String finalBill(String userName);
}
