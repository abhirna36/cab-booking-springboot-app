/**
 * 
 */
package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Cab;

/**
 * @author apple
 *
 */
public interface CabDao extends JpaRepository<Cab, Integer> {

	List<Cab> findByPincodeAndCabRideStatus(String pincode, String cabRideStatus);

	List<Cab> findByCabRideStatus(boolean cabRideStatus);

}
