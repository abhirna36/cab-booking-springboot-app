package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.model.SigninInputModel;
import com.example.service.LoginService;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserDao userDao;

	@Override
	public void AddUser(SigninInputModel signInInputModel) {
		User user = new User();
		user.setEmail(signInInputModel.getEmail());
		user.setName(signInInputModel.getName());
		user.setPassword(signInInputModel.getPassword());

		userDao.save(user);
	}

}
