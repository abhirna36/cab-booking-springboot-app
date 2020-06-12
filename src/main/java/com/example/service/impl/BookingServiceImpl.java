/**
 * 
 */
package com.example.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.BookingDao;
import com.example.dao.CabDao;
import com.example.dao.DriverDao;
import com.example.entity.Cab;
import com.example.model.BookingOutputModel;
import com.example.service.BookingService;

/**
 * @author apple
 *
 */
@Component
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDao bookingDao;

	@Autowired
	CabDao cabDao;

	@Autowired
	DriverDao driverDao;

	@Override
	public BookingOutputModel bookCab(String pincode) {
		BookingOutputModel bookingOutputModel = new BookingOutputModel();

		List<Cab> cabList = cabDao.findByPincodeAndCabRideStatus(pincode, "free");
		Random rand = new Random();
		Integer randomCabId = rand.nextInt(cabList.size());
		bookingOutputModel.setCabDetails(cabList.get(randomCabId));

		return bookingOutputModel;
	}

}
