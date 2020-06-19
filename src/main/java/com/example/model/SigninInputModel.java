/**
 * 
 */
package com.example.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author apple
 *
 */
@Getter
@Setter
public class SigninInputModel {

	@NotNull
	private String name;
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	private String password;

	private Integer homeLatitude;

	private Integer homeLongitude;
}
