
/*
 * @Author: Ramesh
 * Date: 17-01-2023
 */
package com.hcl.messege.entity.restcontroller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.messege.entity.Message;
import com.hcl.messege.service.IMessegeService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/message")
//this is the message controller
public class MessageController {
	//here injecting the MessageService dependency
	@Autowired
	private IMessegeService ms;
	//here is Adding the message
	@PostMapping("/add")
	public Message AddMessage(@RequestBody Message msg) {
		
		return ms.AddMessage(msg);
	}
	//this is for searching the message
	@GetMapping("/search/id/{id}")
	public Message searchMessage(@PathVariable int id) {
		return ms.searchMessage(id);
	}
	//this is for deleting the message
	@DeleteMapping("/delete/{id}")
	public Message deleteMessage(@PathVariable int id) {
		return ms.deleteMessage(id);
	}
	//this is for getting all the messages
	@GetMapping("/AllMessages")
	public List<Message> messages(){
		return ms.messages();
	}

}
