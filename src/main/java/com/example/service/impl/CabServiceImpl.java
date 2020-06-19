/**
 * 
 */
package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.CabDao;
import com.example.dao.DriverDao;
import com.example.entity.Cab;
import com.example.entity.Driver;
import com.example.model.CabRegistrationInputModel;
import com.example.service.CabService;

/**
 * @author apple
 *
 */
@Component
public class CabServiceImpl implements CabService {

	@Autowired
	CabDao cabDao;

	@Autowired
	DriverDao driverDao;

	@Override
	public void addnewCab(CabRegistrationInputModel cabRegistrationInputModel) {

		Cab cab = new Cab();
		Driver driverDetails = new Driver();
		cab.setName(cabRegistrationInputModel.getName());
		cab.setType(cabRegistrationInputModel.getType());
		cab.setCabRideStatus(false);

		driverDetails.setName(cabRegistrationInputModel.getDriverDetails().getName());
		driverDetails.setPhoneNumber(cabRegistrationInputModel.getDriverDetails().getPhone_number());
		cab.setDriverDetails(driverDetails);

		Integer driverId = driverDao.save(driverDetails).getId();
		driverDetails.setId(driverId);

		cab.setDriverDetails(driverDetails);
		cabDao.save(cab).getId();
	}

	@Override
	public void updateCabLocation(Integer cabId, Integer latitude, Integer longitude) {
		Cab cabDetails = cabDao.findById(cabId).orElse(null);

		if (cabDetails != null) {
			cabDetails.setLatitude(latitude);
			cabDetails.setLongitude(longitude);
			cabDao.save(cabDetails);

			Driver driverDetails = driverDao.findById(cabDetails.getDriverDetails().getId()).orElse(null);
			if (driverDetails != null) {
				driverDetails.setLatitude(latitude);
				driverDetails.setLongitude(longitude);
				driverDao.save(driverDetails);
			}
		}
	}

	@Override
	public void switchAvailability(Integer cabId, boolean available) {
		Cab cabDetails = cabDao.findById(cabId).orElse(null);
		if (cabDetails != null) {
			Driver driverDetails = driverDao.findById(cabDetails.getDriverDetails().getId()).orElse(null);
			cabDetails.setCabRideStatus(available);
			driverDetails.setAvaliability(available);
			driverDao.save(driverDetails);
			cabDao.save(cabDetails);
		}
	}
}
