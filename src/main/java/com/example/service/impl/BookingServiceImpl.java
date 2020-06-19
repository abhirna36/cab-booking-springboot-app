/**
 * 
 */
package com.example.service.impl;

import java.util.ArrayList;
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
import com.example.entity.Driver;
import com.example.entity.User;
import com.example.model.BookingOutputModel;
import com.example.service.BookingService;
import com.example.util.utils;

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
	public BookingOutputModel bookCab(Integer latitude, Integer longitude, String email) {
		BookingOutputModel bookingOutputModel = new BookingOutputModel();
		List<Cab> cabList = cabDao.findByCabRideStatus(false);
		User userDetails = userDao.findByEmail(email);

		List<Cab> nearCabs = new ArrayList<Cab>();

		for (int i = 0; i < cabList.size(); i++) {
			double distance = utils.calculateDistance(latitude, longitude, cabList.get(i).getLatitude(),
					cabList.get(i).getLongitude());
			if (distance < 5) {
				nearCabs.add(cabList.get(i));
			}
		}

		if (nearCabs.size() > 1) {
			Random rand = new Random();
			Integer randomCabId = rand.nextInt(nearCabs.size());

			Cab cabDetails = nearCabs.get(randomCabId);

			cabDetails.setCabRideStatus(true);
			cabDao.save(cabDetails);
			Driver driverDetails = driverDao.findById(cabDetails.getDriverDetails().getId()).orElse(null);
			driverDetails.setAvaliability(true);
			driverDao.save(driverDetails);

			bookingOutputModel = addBooking(cabDetails, userDetails);
		} else if (nearCabs.size() == 1) {

			Cab cabDetails = nearCabs.get(0);
			cabDetails.setCabRideStatus(true);
			Driver driverDetails = driverDao.findById(cabDetails.getDriverDetails().getId()).orElse(null);
			driverDetails.setAvaliability(true);
			driverDao.save(driverDetails);
			cabDao.save(cabDetails);

			bookingOutputModel = addBooking(cabDetails, userDetails);
		} else {
			// If no near by cabs available we can add logic based on requirement
		}

		return bookingOutputModel;
	}

	private BookingOutputModel addBooking(Cab cabDetails, User userDetails) {
		BookingOutputModel bookingOutputModel = new BookingOutputModel();
		Booking booking = new Booking();
		booking.setCabDetails(cabDetails);
		booking.setUserDetails(userDetails);

		bookingDao.save(booking);
		bookingOutputModel.setCabDetails(cabDetails);

		return bookingOutputModel;
	}

}
