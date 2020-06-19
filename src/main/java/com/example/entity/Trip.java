/**
 * 
 */
package com.example.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author apple
 *
 */
@Entity
@Data
public class Trip {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1808418667603140890L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("tripId")
	private Integer id;

	@JoinColumn(name = "userId")
	private User userDetails;

	private Timestamp startTime;

	private Timestamp endTime;

	@JoinColumn(name = "cabIdId")
	private Cab cabDetails;

}
