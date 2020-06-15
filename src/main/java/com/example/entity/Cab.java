/**
 * 
 */
package com.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author abhishek
 *
 */
@Entity
@Data
public class Cab implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4544294823203324419L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("cabId")
	private Integer id;

	private String name;

	private String type;

	private String pincode;

	private String latitude;

	private String longitude;

	private String cabRideStatus;

	@OneToOne
	@JoinColumn(name = "driverId")
	private Driver driverDetails;

}
