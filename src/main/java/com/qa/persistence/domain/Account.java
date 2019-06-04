package com.qa.persistence.domain;

public class Account {

	// This class needs to have:
	// An id
	// An Account Number
	// A First Name
	// A last Name

	private int id;
	private String accountNumber;
	private String firstName;
	private String lastName;

	public Account(int id, String accountNumber, String firstName, String lastName) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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

	@Override
	public String toString() {
		return String.format("Account " + accountNumber + " belongs to " + firstName + " " + lastName);
	}

}
