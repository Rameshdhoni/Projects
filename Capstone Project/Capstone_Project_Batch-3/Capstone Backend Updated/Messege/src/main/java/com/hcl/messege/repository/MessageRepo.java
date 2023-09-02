package com.hcl.messege.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.messege.entity.Message;


/*
 * @Author: Ramesh
 * Date: 17-01-2023
 */


//this is the repository class

public interface MessageRepo extends JpaRepository<Message, Integer> {

}
