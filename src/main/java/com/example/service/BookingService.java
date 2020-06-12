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
	 * @param pincode
	 * @return
	 */
	BookingOutputModel bookCab(String pincode);
}
