package com.capstone.ams.service;

/**
*
* 
* @author manneusha.sri@hcl.com
*
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.ams.exception.NoSuchPlaneExistsException;
import com.capstone.ams.exception.PlaneAlreadyExistsException;
import com.capstone.ams.model.Plane;
import com.capstone.ams.repo.PlaneRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PlaneServiceImp implements PlaneService {
	@Autowired
	PlaneRepository planeRepo; // injecting planerepository into adminserviceimp
	// business logic on plane details
	// adding plane details

	@Override
	public String addPlane(Plane plane) {

		if (planeRepo.findById(plane.getPlaneId()).isPresent()) {
			try {
				throw new PlaneAlreadyExistsException(); // exceptionhandling for plane

			} catch (PlaneAlreadyExistsException e) {

				return "plane details already exists";
			}

		} else {
			planeRepo.save(plane);
			log.info("plane details added	 successfully");
			return "plane details added successfully";
				
			}
		}
		
	// getting all plane details using list
	@Override
	public List<Plane> getAllPlanes() {
		log.info(" viewed status plane details successfully..");
		return planeRepo.findAll();
	}

	// deleting plane using planeId
	@Override
	public String deletePlane(long planeId) {
		try {
			planeRepo.deleteById(planeId);
			log.info("Plane Deleted SucussFully..");
			return " Plane Deleted SucussFully";
		} catch (NoSuchPlaneExistsException e) {
			throw new NoSuchPlaneExistsException("No such plane exists");// exceptionhandling for deleting plane
		}

	}

	// updating plane details
	@Override
	public String updatePlane(Plane plane) {
		Plane existPlane = planeRepo.findById(plane.getPlaneId()).orElse(null);
		if (existPlane == null) {
			throw new NoSuchPlaneExistsException("No such plane exists!");
		}

		try {

			planeRepo.save(plane);
			log.info("Plane details updated successfully..");
		} catch (NoSuchPlaneExistsException e) {
			throw new NoSuchPlaneExistsException("No such plane exists!");
		}
		return "Plane details updated successfully!";
	}

}
