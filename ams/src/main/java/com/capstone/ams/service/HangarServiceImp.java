package com.capstone.ams.service;

/**
 * This is used for writing hangar service implementations with  business logics

 * 
 * @author jakkula.ramesh@hcl.com
 * @author kurapati.kavyasree@hcl.com
 *        
 */
import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.ams.exception.HangarAlreadyExistsException;
import com.capstone.ams.exception.NoSuchHangarExistsException;
import com.capstone.ams.model.Hangar;
import com.capstone.ams.repo.HangarRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class HangarServiceImp implements HangarService {
	@Autowired
	HangarRepository hangarRepo;

	// business logic for Hangar
	// adding hangar details
	@Override
	public String addHangar(Hangar hangar) {
		
		if (hangarRepo.findById(hangar.getHangarId()).isPresent()) {
			try {
				throw new HangarAlreadyExistsException(); //exceptionhandling for hangar

			} catch (HangarAlreadyExistsException e) {

				return "Hangar details already exists";
			}

		} else {
				hangarRepo.save(hangar);
				log.info("hangar details added successfully..");
				return "Hangar details added successfully!";
			}
		}
		
	// deleting hangar using hangarId
	@Override
	public String deleteHangar(long hangarId) {
		try {
			hangarRepo.deleteById(hangarId);
			log.info("hangar Deleted SucussFully..");
			return " Hangar Deleted SucussFully";
		} catch (NoSuchHangarExistsException e) {
			throw new NoSuchHangarExistsException("No such hangar exists");// exceptionhandling for deleting hangar
		}
	}

	// getting all hangar details using list
	@Override
	public List<Hangar> getAllHangar() {
		log.info("  viewed  status  hangar details successfully..");
		return hangarRepo.findAll();
	}

	// updating hangar details
	@Override
	public String updateHangar(Hangar hangar) {
		Hangar existHangar = hangarRepo.findById(hangar.getHangarId()).orElse(null);
		if (existHangar == null)
			throw new NoSuchHangarExistsException("No such hangar exists!");// exceptionhandling for updating hangar
		else {
			existHangar.setHangarName(hangar.getHangarName());
			existHangar.setHangarSize(hangar.getHangarSize());
			existHangar.setPlane(hangar.getPlane());
			hangarRepo.save(existHangar);
			log.info("hangar details updated successfully..");
			return "Hangar details updated successfully !";
		}
	}

	// getting a hangar deatils using hangarId
	@Override
	public Hangar getHangarById(long hangarId) {
		Optional<Hangar> han = hangarRepo.findById(hangarId);
		if (han.isPresent()) {
			log.info(" viewied hangar details successfully..");
			return han.get();
		}
		throw new RuntimeException("Hangar not found with id " + hangarId);// exceptionhandling for getting hangarId
	}

}
