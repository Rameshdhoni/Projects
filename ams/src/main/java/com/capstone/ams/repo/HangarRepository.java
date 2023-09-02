package com.capstone.ams.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.ams.model.Hangar;

/**
 * 
 * 
 * @author jakkula.ramesh@hcl.com
 * @author kurapati.kavyasree@hcl.com
 * 
 */

//HangarRepsitory
@Repository
public interface HangarRepository extends JpaRepository<Hangar, Long> {

}
