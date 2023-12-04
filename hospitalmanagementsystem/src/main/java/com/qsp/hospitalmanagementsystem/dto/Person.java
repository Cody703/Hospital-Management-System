package com.qsp.hospitalmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name Can't Be Blank")
	@NotNull(message = "Name Can't Be Null")
	private String name;
	@Min(value = 6000000000l)
	@Max(value = 99999999999l)
	@Column(unique = true)
	private long phone;
	@NotBlank(message = "Email Can't Be Blank")
	@NotNull(message = "Email Can't Be Null")
	@Column(unique = true)
//					//satishy703  @ gmail	  .com/in{size from 2 to 3}
	@Email(regexp = "[a-z0-9._+$]+@[a-z0-9]+\\.[a-z]{2,3}", message = "Invalid Email")
	private String email;
	@NotBlank(message = "Address Can't Be Blank")
	@NotNull(message = "Address Can't Be Null")
	private String address;

}
