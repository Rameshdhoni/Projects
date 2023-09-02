package com.capstone.ams.controller;

/**
*
* 
* @author ramasrujana.meka@hcl.com
*
*/

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.ams.model.Pilot;
import com.capstone.ams.service.PilotService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/pilot")
@RestController
public class PilotController {
	
	@Autowired
	PilotService pilotService;

	// Controller methods for Pilot details
	// adding piolt details as an admin
	@PostMapping("/pilot")
	public String addPilot(@Valid @RequestBody Pilot pilot) {
		log.info("addpilot is in progress..");
		return pilotService.addPilot(pilot);
	}

	// getting all pilot details
	@GetMapping("/pilots")
	public List<Pilot> getAllPilots() {
		log.info("getallpilots is in progress..");
		return pilotService.getAllPilots();
	}

	// deleting pilot details by pilotId as an admin
	@DeleteMapping("/{pilotId}")
	public String deletePilot(@PathVariable long pilotId) {
		log.info("delete pilot details is in progress..");
		return pilotService.deletePilot(pilotId);
	}

	// updating pilot detalis as an admin
	@PutMapping("/pilot")
	public String updatePilot(@RequestBody Pilot pilot) {
		log.info("update pilot details is in progress..");
		return pilotService.updatePilot(pilot);
	}

}
