package com.hcl.profilepageuser.service;
/*
 * @Author: Ramesh
 * Date: 18-01-2023
 */
import com.hcl.profilepageuser.dto.Message;

public interface IMessageService {
	//methods need to implement
	public Message addMessage(Message msg);

	public Message[] messages();

	public Message deleteMessage(int id);

	public Message searchMessage(int id);
}
