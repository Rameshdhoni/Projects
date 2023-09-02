package com.capstone.ams.service;

/**
*
* 
* @author ramasrujana.meka@hcl.com

*
*/

import java.util.List;

import com.capstone.ams.model.Pilot;

public interface PilotService {
	// CRUD operations on pilot details
	// adding pilot details as an admin
	public String addPilot(Pilot pilot);

	// view all pilot details by using list
	public List<Pilot> getAllPilots();

	// deleting piolt using pilotId
	public String deletePilot(long pilotId);

	// updating pilot details
	public String updatePilot(Pilot pilot);

}
