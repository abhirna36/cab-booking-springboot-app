package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.model.SigninInputModel;
import com.example.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void AddUser(SigninInputModel signInInputModel) {
		User user = new User();
		user.setEmail(signInInputModel.getEmail());
		user.setName(signInInputModel.getName());
		user.setPassword(signInInputModel.getPassword());
		user.setHomeLatitude(signInInputModel.getHomeLatitude());
		user.setHomeLongitude(signInInputModel.getHomeLongitude());

		userDao.save(user);
	}

}
