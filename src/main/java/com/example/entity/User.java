/**
 * 
 */
package com.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author apple
 *
 */
@Entity
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -7019407592618553955L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("userId")
	private Integer id;

	private String name;

	@NotNull
	@NotBlank
	private String email;

	private String password;
}
