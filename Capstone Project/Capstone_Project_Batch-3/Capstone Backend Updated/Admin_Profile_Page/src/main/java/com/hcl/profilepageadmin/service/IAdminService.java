package com.hcl.profilepageadmin.service;

import java.util.List;




import com.hcl.profilepageadmin.dto.AdminDTO;
import com.hcl.profilepageadmin.entities.Admin;


public interface IAdminService {

	public Admin Register(Admin admin);

	public String Login(String adminName, String adminPassword);

	public List<Admin> getAdmin();

	public Admin updateAdmin(Integer id, AdminDTO adminDTO);

	public void deleteAdmin(Integer id);

	
}
