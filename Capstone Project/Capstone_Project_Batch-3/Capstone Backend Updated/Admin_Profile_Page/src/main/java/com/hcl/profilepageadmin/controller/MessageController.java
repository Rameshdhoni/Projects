package com.hcl.profilepageadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.profilepageadmin.dto.Message;
import com.hcl.profilepageadmin.service.IMessageService;
/*
 * @Author: Ramesh
 * Date: 18-01-2023
 */
@RestController
@RequestMapping("/adminmsg")
public class MessageController {
	// injecting the dependency of messageservice
	@Autowired
	IMessageService ms;

//this is for adding message
	@PostMapping("/add")
	public Message addMessage(@RequestBody Message msg) {
		return ms.addMessage(msg);
	}

//this is for searching message by id
	@GetMapping("/search/id/{id}")
	public Message searchMessage(@PathVariable int id) {
		return ms.searchMessage(id);
	}
	//this is for deleting message
	@DeleteMapping("/delete/id/{id}")
	public Message deleteMessage(@PathVariable int id) {
		return ms.deleteMessage(id);
	}
	//this is for getting messages
	@GetMapping("/messages")
	public Message[] message() {
		return ms.messages();
	}
}
