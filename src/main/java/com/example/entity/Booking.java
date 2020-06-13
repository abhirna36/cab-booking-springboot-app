/**
 * 
 */
package com.example.entity;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Entity
@Data
public class Booking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1908418667603140890L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("bookingId")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "cabId")
	private Cab cabDetails;

	@OneToOne
	@JoinColumn(name = "userId")
	private User userDetails;

	private Timestamp bookingTime;

	private String origin;

	private String destination;

}
