package com.stellarcodes.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	 * When user have more than one address, we can use @ElementCollection with
	 * the dependency of user object. While saving set of addresses hibernate
	 * puts this into separate table with user id as reference.
	 * 
	 * the fetch type will be LAZY by default, you can also make it EAGER by 
	 * specifying the fetch type to EAGER in @ElementCollection.
	 *  
	 */
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	private Set<Address> listOfAddress = new HashSet<Address>();

	public User() {
	}

	public User(String firstName, String lastName, String contactNo,
			Set<Address> listOfAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.listOfAddress = listOfAddress;
	}

	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
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

	@Override
	public String toString() {
		return "[ listOfAddresses:" + listOfAddress.size()+ "]";
	}
}
