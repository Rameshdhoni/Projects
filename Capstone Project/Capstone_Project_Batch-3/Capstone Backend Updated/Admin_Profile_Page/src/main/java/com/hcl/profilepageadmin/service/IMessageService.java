package com.hcl.profilepageadmin.service;

import com.hcl.profilepageadmin.dto.Message;
/*
 * @Author: Ramesh
 * Date: 18-01-2023
 */
public interface IMessageService {
	public Message addMessage(Message msg);

	public Message[] messages();

	public Message deleteMessage(int id);
	public Message searchMessage(int id);
}
