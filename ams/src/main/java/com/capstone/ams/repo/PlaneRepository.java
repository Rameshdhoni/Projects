package com.capstone.ams.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capstone.ams.model.Plane;
/**
 * 
 * 
 * @author manneusha.sri@hcl.com
 * 
 */

//PlaneRepository
@Repository
public interface PlaneRepository extends JpaRepository<Plane,Long> {

}
