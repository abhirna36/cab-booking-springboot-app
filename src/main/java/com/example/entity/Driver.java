/**
 * 
 */
package com.example.entity;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author apple
 *
 */
@Data
@Entity
public class Driver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -678130277449867756L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("driverId")
	private Integer id;

	private String name;

	private Number phoneNumber;

	private DecimalFormat latitude;

	private DecimalFormat longitude;

	private String status;

	private String rating;

	@OneToOne
	@JoinColumn(name = "cabId")
	private Cab cabDetails;
}
