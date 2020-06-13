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
import com.example.dao.UserDao;
import com.example.entity.Booking;
import com.example.entity.Cab;
import com.example.entity.User;
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

	@Autowired
	UserDao userDao;

	@Override
	public BookingOutputModel bookCab(String pincode, String email) {
		BookingOutputModel bookingOutputModel = new BookingOutputModel();

		List<Cab> cabList = cabDao.findByPincodeAndCabRideStatus(pincode, "free");
		User userDetails = userDao.findByEmail(email);
		Random rand = new Random();
		Integer randomCabId = rand.nextInt(cabList.size());
		bookingOutputModel.setCabDetails(cabList.get(randomCabId));

		Booking booking = new Booking();
		booking.setCabDetails(bookingOutputModel.getCabDetails());
		booking.setUserDetails(userDetails);

		bookingDao.save(booking);

		return bookingOutputModel;
	}

}
