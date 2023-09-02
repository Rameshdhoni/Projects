package com.capstone.ams.service;

/**
*
* 
* @author ramasrujana.meka@hcl.com
*
*/

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.ams.exception.NoSuchPilotExistsException;
import com.capstone.ams.exception.NoSuchPlaneExistsException;
import com.capstone.ams.exception.PilotAlreadyExistsException;
import com.capstone.ams.model.Pilot;
import com.capstone.ams.repo.PilotRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PilotServiceImp implements PilotService {

	@Autowired
	PilotRepository pilotRepo;// injecting pilotrepository into adminserviceimp

	// business logic on pilot details
	// adding pilot deatils
	@Override
	public String addPilot(Pilot pilot) {

		if (pilotRepo.findById(pilot.getPilotId()).isPresent()) {
			try {
				throw new PilotAlreadyExistsException(); //PilotAlreadyExistsException exceptionhandling

			} catch (PilotAlreadyExistsException e) {

				return "pilot details already exists";
			}

		} else {
			
				pilotRepo.save(pilot);
				log.info("Pilot details added successfully..");
				return "Pilot added successfully!";
			}
		}
		
	// getting all pilot details using list
	@Override
	public List<Pilot> getAllPilots() {
		log.info(" viewed status pilot details successfully..");
		return pilotRepo.findAll();
	}

	// deleting pilot details using pilotId
	@Override
	public String deletePilot(long pilotId) {
		try {
			pilotRepo.deleteById(pilotId);
			log.info("Pilot details deleted successfully..");
			return " Pilot Deleted SucussFully";
		} catch (NoSuchPilotExistsException e) {
			throw new NoSuchPlaneExistsException("No such pilot exists");// exceptionhandling for deleting pilot
		}
	}

	// updating pilot deatils
	@Override
	public String updatePilot(Pilot pilot) {
		Pilot existPilot = pilotRepo.findById(pilot.getPilotId()).orElse(null);
		if (existPilot == null) {
			throw new NoSuchPilotExistsException("No such pilot exists!");// exceptionhandling for updating pilot
		}
		try {
			existPilot.setPilotName(pilot.getPilotName());
			existPilot.setAge(pilot.getAge());
			pilotRepo.save(existPilot);
			log.info("Pilot details updated successfully..");
		} catch (NoSuchPilotExistsException e) {
			throw new NoSuchPilotExistsException("No such pilot exists!");
		}
		return "Pilot details updated successfully!";
	}
}
