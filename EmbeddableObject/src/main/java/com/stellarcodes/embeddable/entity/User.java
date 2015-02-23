package com.stellarcodes.embeddable.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity which holds the profile information of the user
 * 
 * @author Pravin
 *
 */
@Entity
@Table(name = "USER_PROFILE")
public class User {

	/**
	 * Primary key column for this entity. the value of the primary key (@Id)
	 * will be generated automatically by (@GeneratedValue)
	 */
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "CONTACT_NO")
	private String contactNo;

	/**
	 * here we have added another (@Embedded) Object as office address but table
	 * does not have duplicate columns so we need to override the column names
	 * using (@AttributeOverrides).
	 */
	@Embedded
	@AttributeOverrides({

			@AttributeOverride(name = "street", column = @Column(name = "OFF_STREET")),
			@AttributeOverride(name = "state", column = @Column(name = "OFF_STATE")),
			@AttributeOverride(name = "pincode", column = @Column(name = "OFF_PINCODE")),
			@AttributeOverride(name = "city", column = @Column(name = "OFF_CITY")),
			@AttributeOverride(name = "country", column = @Column(name = "OFF_COUNTRY")) })
	private Address officeAddress;

	@Embedded
	private Address userAddress;

	public User() {
	}

	public User(String firstName, String lastName, String contactNo,
			Address userAddress, Address officeAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.userAddress = userAddress;
		this.officeAddress = officeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

}
