package com.hcl.profilepageuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.webjars.NotFoundException;

import com.hcl.profilepageuser.dto.Message;
import com.hcl.profilepageuser.exception.ResponseAlreadyExistsException;
import com.hcl.profilepageuser.exception.ResponseEmptyException;
/*
 * @Author: Ramesh
 * Date: 18-01-2023
 */
@Service
public class MessageServiceImp implements IMessageService {
	@Autowired
	private RestTemplate rt;
	//this is for adding message
	@Override
	public Message addMessage(Message msg) {
		String uri = "http://localhost:9004/message/add";
		Message m = rt.postForObject(uri, msg, Message.class);
		if (m.getId() == 0) {
			throw new ResponseAlreadyExistsException("Message already exists id:" + msg.getId());
		} else {
			return m;
		}
	}
	//this is for getting all messages
	@Override
	public Message[] messages() {
		String uri = "http://localhost:9004/message/AllMessages";
		try {
			ResponseEntity<Message[]> res = rt.getForEntity(uri, Message[].class);
			if (res.getBody().length == 0) {
				throw new ResponseEmptyException("no post are there");
			} else {
				return res.getBody();
			}
		} catch (Exception e) {
			throw new ResponseEmptyException("no post are there");
		}

	}
	//this is for deleting message
	@Override
	public Message deleteMessage(int id) {
		Message msg = searchMessage(id);
		String uri = "http://localhost:9004/message/delete/id" + id;
		if (msg.getId() == 0) {
			throw new NotFoundException("Message not Found with id:" + id);
		} else {
			rt.delete(uri);
			return msg;
		}

	}
	//this is for searching message
	@Override
	public Message searchMessage(int id) {
		String uri = "http://localhost:9004/message/search/id/" + id;
		Message msg = rt.getForObject(uri, Message.class, id);
		if (msg.getId() == 0) {
			throw new NotFoundException("Message not Found with id:" + id);
		} else {
			return msg;
		}

	}
}