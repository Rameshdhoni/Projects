package com.hcl.messege.service;

import java.util.List;

import com.hcl.messege.entity.Message;
/*
 * @Author: Ramesh
 * Date: 17-01-2023
 */
public interface IMessegeService {
	public Message AddMessage(Message msg);

	public Message searchMessage(int id);

	public Message deleteMessage(int id);

	public List<Message> messages();
}
