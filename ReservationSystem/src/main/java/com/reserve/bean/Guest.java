package com.reserve.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Guest {

	private int guestId;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String password;
	private Date createdDate;
	private Date updatedDate;
	private List<GuestRole> roles;

	public Guest() {
		super();
	}

	public Guest(String email, String password, List<GuestRole> roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Guest(String email, String password, GuestRole... roles) {
		this(email, password, Arrays.asList(roles));
	}

	public List<GuestRole> getRoles() {
		return roles;
	}

	public void setRoles(List<GuestRole> roles) {
		this.roles = roles;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phone=" + phone + ", password=" + password + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", roles=" + roles + "]";
	}

}
