package com.hcl.profilepageadmin.service;

import java.util.List;

import com.hcl.profilepageadmin.entities.ReportUser;



public interface IReportUserService {

	public ReportUser Register(ReportUser user) ;	

	public List<ReportUser> getUser() ;
	

	public void deleteUser(Integer id);

}
