package com.stellarcodes.mapping.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER_MAP")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_OF_BIRTH")
	private Date dateofBirth;

	/**
	 * CascadeType.ALL will be triggered all operation like insert, update,
	 * delete.. here in this example we have used this to save unsaved objects
	 * in addresses list
	 * 
	 * mappedBy will be used to register that this table already mapped with
	 * Address class user object. It will prevent the mapping table creation of
	 * one to many with USER_ID, ADDRESS_ID.
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Collection<Address> addresses = new ArrayList<Address>();

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
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

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	@Override
	public String toString() {
		return "[id:" + id + ", first name:" + firstName + ", lastName:"
				+ lastName + ", date of birth:" + dateofBirth + "]";
	}

}
