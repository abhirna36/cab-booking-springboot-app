/**
 * 
 */
package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.SigninInputModel;

/**
 * @author apple
 *
 */
@Service
public interface LoginService {

	/**
	 * Method to add user
	 * 
	 * @param signInInputModel
	 */
	void AddUser(SigninInputModel signInInputModel);
}
