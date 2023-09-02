
/*
 * Author: Ramesh
 * interface name: AdminServiceImp
 * purpose:unimplementd methods declared here and do some operation to achieve abstraction
 * 
 */
package com.hcl.profilepageadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hcl.profilepageadmin.dto.AdminDTO;
import com.hcl.profilepageadmin.entities.Admin;
import com.hcl.profilepageadmin.repository.AdminRepo;

@Service

public class AdminServiceImp implements IAdminService {
	@Autowired
	AdminRepo adminRepo;

	@Override

	public Admin Register(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public String Login(String adminName, String adminPassword) {
		List<Admin> admin1 = adminRepo.findAll();
		int counter = 0;
		for (Admin admin : admin1) {
			if (admin.getAdminName().equals(adminName) && admin.getAdminPassword().equals(adminPassword)) {
				return "Admin logged in successfully";
			}
		}
		if (counter == 0) {
			return "Invalid credentials";
		} else {
			return "";
		}
	}

	@Override
	public List<Admin> getAdmin() {
		return adminRepo.findAll();
	}

	@Override
	public Admin updateAdmin(Integer id, AdminDTO adminDTO) {
		Admin admin1 = adminRepo.findById(id).get();

		admin1.setAdminName(adminDTO.getAdminName());
		admin1.setAdminEmail(adminDTO.getAdminEmail());
		admin1.setAdminPhone(adminDTO.getAdminPhone());
		admin1.setAdminPassword(adminDTO.getAdminPassword());

		return adminRepo.save(admin1);
	}

	@Override
	public void deleteAdmin(Integer id) {
		adminRepo.deleteById(id);

	}

}