package com.stellarcodes.mapping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long vehicleId;

	@Column(name = "VHEICLE")
	private String vehicle;

	@Column(name = "VEHICLE_MAKE")
	private String vehicleMake;

	@Column(name = "VEHICLE_MODEL")
	private String vehicleModel;

	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private User owner;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@Override
	public String toString() {
		return "[ vehicleId:" + vehicleId + ", vehicle:" + vehicle
				+ ", vehicle make:" + vehicleMake + ", vehicle model:"
				+ vehicleModel + "]";
	}

}
