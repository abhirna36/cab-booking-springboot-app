/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SigninInputModel;
import com.example.service.LoginService;

/**
 * @author apple
 *
 */
@RestController
public class LoginController {

//	@Autowired
//	private UserDao userDao;

	@Autowired
	LoginService loginService;

	@PostMapping(path = "/addUser")
	public ResponseEntity<Void> addNewUser(@RequestBody SigninInputModel signInInputModel) {

		loginService.AddUser(signInInputModel);

		return ResponseEntity.noContent().build();
	}

//	@GetMapping(path = "/all")
//	public ResponseEntity<List<User>> getAllUsers() {
//
//		List<User> userList = new ArrayList<>();
//		userList.addAll(userDao.findAll());
//		return ResponseEntity.ok().body(userList);
//	}

	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello() {
		return ResponseEntity.ok().body("HelloWorld");
	}
}
