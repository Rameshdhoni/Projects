package com.hcl.profilepageadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.profilepageadmin.entities.ReportUser;
import com.hcl.profilepageadmin.repository.ReportUserRepo;
@Service
public class ReportUserServiceImp implements IReportUserService {
	@Autowired 
	ReportUserRepo userRepo;
	
	@Override
	public ReportUser Register(ReportUser user) {
		return userRepo.save(user);
	}

	@Override
	public List<ReportUser> getUser() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
	}

}
