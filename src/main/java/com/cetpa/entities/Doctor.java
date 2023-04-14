package com.cetpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Doctor 
{
	@Id
	@GeneratedValue
	private int did;
	@Column(length = 30)
	@NotNull(message = "Name is required")
	@Size(min = 3,message = "Doctor name must have atleast three letters")
	@Pattern(regexp = "[A-Za-z' ']*",message = "Name can have only letters")
	private String name;
	@Column(length = 30)
	@NotNull(message = "City is required")
	@Pattern(regexp = "Delhi|Noida|Faridabad",message = "City must be either Delhi or Noida or Faridabad")
	private String city;
	@Column(length = 100)
	@Email(message = "Email is not valid")
	@NotNull(message = "Email is required")
	private String email;
	@Column(length = 20)
	@Size(min=10,message = "Phone number length must be 10")
	@Pattern(regexp = "[0-9]*",message = "Phone number must have digits")
	@NotNull(message = "Phone is required")
	private String phone;
	@Column(length = 20)
	@NotNull(message = "Speciality is required")
	@Pattern(regexp = "Orthopedic|Gynecology|Dermatology|ENT",message = "Invalid speciality")
	private String speciality;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
