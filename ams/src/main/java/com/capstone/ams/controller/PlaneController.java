
package com.capstone.ams.controller;

/**
*
* 
* @author manneusha.sri@hcl.com
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

import com.capstone.ams.model.Plane;
import com.capstone.ams.service.PlaneService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/plane")
@RestController
public class PlaneController {
	@Autowired
	PlaneService planeService;

	// Controller methods for Plane details
	// adding palne details as an admin
	@PostMapping("/plane")
	public String addPlane (@Valid @RequestBody Plane plane) {
		log.info("addplane is in progress..");
		return planeService.addPlane(plane);
	}

	// getting all planes details
	@GetMapping("/planes")
	public List<Plane> getAllPlanes() {
		log.info("getplane info is in progress..");
		return planeService.getAllPlanes();
	}

	// deleteing plane details by planeId as an admin
	@DeleteMapping("/{planeId}")
	public String deletePlane(@PathVariable long planeId) {
		log.info("delete plane is in progress..");
		return planeService.deletePlane(planeId);
	}

	// updating plane details as an admin
	@PutMapping("/plane")
	public String updatePlane(@RequestBody Plane plane) {
		log.info("update is in progress..");
		return planeService.updatePlane(plane);
	}

}
