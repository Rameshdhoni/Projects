package com.hcl.profilepageadmin.service;

import java.util.List;


import com.hcl.profilepageadmin.entities.AdminPostApproval;

public interface IAdminPostApprovalService {
	public AdminPostApproval addPost(AdminPostApproval task);

	public List<AdminPostApproval> getPost();

	public void deletePost(Integer id);

	public AdminPostApproval getPostById(Integer id);
}
