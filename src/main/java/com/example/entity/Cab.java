/**
 * 
 */
package com.example.entity;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author abhishek
 *
 */
@Entity
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cab implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4544294823203324419L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("userId")
	private Integer id;

	private String name;

	private String type;

	private String pincode;

	private DecimalFormat latitude;

	private DecimalFormat longitude;

	private String cabRideStatus;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "driverId")
	private Driver driverDetails;

}
