package com.app.model;

public class Customer {
	private String username;
	private String password;
	private String first_name;
	private String last_name;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password, String first_name, String last_name) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", first_name=" + first_name
				+ ", last_name=" + last_name + "]";
	}
}
