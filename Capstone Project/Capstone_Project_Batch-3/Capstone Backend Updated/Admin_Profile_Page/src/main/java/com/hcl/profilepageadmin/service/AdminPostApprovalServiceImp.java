package com.hcl.profilepageadmin.service;

/*
 * @Author:Akash
 * Date: 16-01-2023
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hcl.profilepageadmin.entities.AdminPostApproval;
import com.hcl.profilepageadmin.repository.AdminPostApprovalRepo;

@Service
public class AdminPostApprovalServiceImp implements IAdminPostApprovalService {

	@Autowired
	AdminPostApprovalRepo adminPostApprovalRepo;
	@Override
	public List<AdminPostApproval> getPost() {
		// TODO Auto-generated method stub
		return adminPostApprovalRepo.findAll();
	}

	@Override
	public void deletePost(Integer id) {
		adminPostApprovalRepo.deleteById(id);

	}

	@Override
	public AdminPostApproval getPostById(Integer id) {
		return adminPostApprovalRepo.findById(id).get();
	}

	@Override
	public AdminPostApproval addPost(AdminPostApproval task) {
		// TODO Auto-generated method stub
		return adminPostApprovalRepo.save(task);
	}

}
