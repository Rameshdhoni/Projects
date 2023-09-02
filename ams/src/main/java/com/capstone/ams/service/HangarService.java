package com.capstone.ams.service;

/**
 * This is used for writing hangar service method definitions 

 * 
 * @author jakkula.ramesh@hcl.com
 * @author kurapati.kavyasree@hcl.com
 *        
 */
import java.util.List;

import com.capstone.ams.model.Hangar;

public interface HangarService {

	// CRUD operations on Hangar
	// alloting hangar details as an admin
	public String addHangar(Hangar hangar);

	// deleting hangar by using hangarId
	public String deleteHangar(long hangarId);

	// view all hangar details by using list
	public List<Hangar> getAllHangar();

	// updating hangar details
	public String updateHangar(Hangar hangar);

	// getting a hangar by using hangarId
	public Hangar getHangarById(long hangarId);
}
