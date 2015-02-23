package com.stellarcodes.embeddable.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Embeddable Address class which will be part of the entity. user can embed
 * this class type by defining as @Embedded object. this address will hold the
 * address information of the user.
 * 
 * @author Pravin
 *
 */

@Embeddable
public class Address {

	@Column(name = "STREET")
	private String street;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "PINCODE")
	private String pincode;

	public Address() {

	}

	public Address(String street, String city, String state, String country,
			String pincode) {
		this.state = state;
		this.street = street;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
