package com.capstone.ams.service;

/**
*
* 
* @author manneusha.sri@hcl.com
*
*/

import java.util.List;

import com.capstone.ams.model.Plane;

public interface PlaneService {
	// CRUD operations on Plane
	// adding plane as an admin
	public String addPlane(Plane plane);

	// view all plane details using list
	public List<Plane> getAllPlanes();

	// deleting plane using planeId
	public String deletePlane(long planeId);

	// updating plane details
	public String updatePlane(Plane plane);

}
