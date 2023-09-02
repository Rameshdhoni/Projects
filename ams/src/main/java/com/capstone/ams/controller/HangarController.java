package com.capstone.ams.controller;

/**
*
* 
* @author jakkula.ramesh@hcl.com
*         kurapati.kavyasree@hcl.com
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

import com.capstone.ams.model.Hangar;
import com.capstone.ams.service.HangarService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/hangar")
@RestController
public class HangarController {
	@Autowired
	HangarService hangarService;

	// Controller methods for hangar details
	// adding hangar as an admin
	@PostMapping("/hangar")
	public String addHangar(@RequestBody Hangar hangar) {
		log.info("Add hanger is in progress..");
		return hangarService.addHangar(hangar);

	}

	// deleting hangar details by hangarId as an admin
	@DeleteMapping("/{hangarId}")
	public String deleteHangar(@PathVariable long hangarId) {
		log.info("Delete hanger is in progress..");
		return hangarService.deleteHangar(hangarId);
	}

	// getting all hangar details
	@GetMapping("/hangars")
	public List<Hangar> getAllHangar() {
		log.info("Hangers info is in progress..");
		return hangarService.getAllHangar();
	}

	// updating all hanger details as an admin
	@PutMapping("/hangar")
	public String updateHangar(@RequestBody Hangar hangar) {
		log.info("Hanger update is in progress..");
		return hangarService.updateHangar(hangar);
	}

	// getting hangar details by hangarId as an adminS
	@GetMapping("/{hangarId}")
	public Hangar getHangarById(@PathVariable long hangarId) {
		log.info("getting hanger details is in progress..");
		return hangarService.getHangarById(hangarId);
	}
}
