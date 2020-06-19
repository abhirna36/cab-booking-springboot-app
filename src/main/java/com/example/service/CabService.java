/**
 * 
 */
package com.example.service;

import com.example.model.CabRegistrationInputModel;

/**
 * @author apple
 *
 */
public interface CabService {

	/**
	 * 
	 */
	void addnewCab(CabRegistrationInputModel cabRegistrationInputModel);

	void updateCabLocation(Integer cabId, Integer latitude, Integer longitude);

	void switchAvailability(Integer cabId, boolean available);
}
