/**
 * 
 */
package com.example.service;

import com.example.model.BookingOutputModel;

/**
 * @author apple
 *
 */
public interface BookingService {

	/**
	 * 
	 * @param latitude
	 * @param longitude
	 * @param email
	 * @return
	 */
	BookingOutputModel bookCab(Integer latitude, Integer longitude, String email);
}
