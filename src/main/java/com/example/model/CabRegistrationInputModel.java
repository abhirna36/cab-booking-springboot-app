/**
 * 
 */
package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author apple
 *
 */
@Getter
@Setter
public class CabRegistrationInputModel {

	private String name;
	private String type;
	@JsonProperty("driverDetails")
	private DriverRegistrationInputModel driverDetails;

}
