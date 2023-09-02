package com.hcl.messege.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.messege.entity.Message;
import com.hcl.messege.entity.exception.ResponseEmptyException;
import com.hcl.messege.entity.exception.ResponseNotFoundException;
import com.hcl.messege.repository.MessageRepo;

/*
 * @Author: Ramesh
 * Date: 17-01-2023
 */
@Service
public class MessegeServiceImp implements IMessegeService {
	@Autowired
	private MessageRepo repo;

//this is for adding message
	@Override
	public Message AddMessage(Message msg) {
		msg.setDate(LocalDate.now());
		return repo.save(msg);
	}

//this is for searching message
	@Override
	public Message searchMessage(int id) {
		Optional<Message> op = repo.findById(id);
		try {
			Message msg = op.get();
			if (msg == null) {
				throw new ResponseNotFoundException("No messages are found with id:" + id);
			} else {
				return msg;
			}

		} catch (Exception e) {
			throw new ResponseNotFoundException("No messages are found with id:" + id);
		}

	}

//this is for deleting message
	@Override
	public Message deleteMessage(int id) {
		Optional<Message> op = repo.findById(id);
		try {
			Message msg = op.get();
			if (msg == null) {
				throw new ResponseNotFoundException("No messages are found with id:" + id);
			} else {
				repo.deleteById(id);
				return msg;
			}

		} catch (Exception e) {
			throw new ResponseNotFoundException("No messages are found with id:" + id);
		}
	}

//this is for getting all messages
	@Override
	public List<Message> messages() {
		List<Message> lst = repo.findAll();
		if (lst.size() == 0) {
			throw new ResponseEmptyException("no messages are there!!!");
		} else {
			return lst;
		}
	}

}
