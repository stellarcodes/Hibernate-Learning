package com.stellarcodes.embeddable.entity;

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

	private String street;
	private String city;
	private String state;
	private String country;
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
