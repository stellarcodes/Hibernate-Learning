package com.stellarcodes.mapping.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long roleId;

	@Column(name = "ROLE", unique = true, nullable = false)
	private String role;

	@Column(name = "ROLE_DESC")
	private String roleDesc;

	/**
	 * Here we are mentioning that role table has already mapped user table
	 * using "roles". if we did't mention, hibernate will create two mapping
	 * table and do the mapping. one for user and role as user_role, another one
	 * for role and user as role_user, to avoid this we are mentioning mappedBy
	 * attribute as "variable in user" => "roles"
	 */
	@ManyToMany(mappedBy = "roles")
	private Collection<User> users = new ArrayList<User>();

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "[ id:" + roleId + ", role:" + role + ", roledesc:" + roleDesc
				+ "]";
	}

}
