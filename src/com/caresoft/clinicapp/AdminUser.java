package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
	// MEMBER VARIABLES
	private Integer employeeID;
	private String role;
	private ArrayList<String> securityIncidents;
	
	
	// CONSTRUCTORS
	public AdminUser(Integer id, String role) {
		super();
		this.employeeID = id;
		this.role = role;
		securityIncidents = new ArrayList<String>();
	}
	

	// METHODS
	public boolean assignPin(int pin) {
		this.setPin(pin);
		return true;
	}
	
	public boolean accessAuthorized(Integer confirmAuthID) {
		if (this.getEmployeeID() == confirmAuthID) {
			return true;
		} else {
			this.authIncident();
			return false;
		}
	}
	
	public ArrayList<String> reportSecurityIncidents() {
		return this.getSecurityIncidents();
	}
	
	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s \nReported By ID: %s\nNotes: %s \n", new Date(), this.getEmployeeID(), notes);
		securityIncidents.add(report);
	}
	
	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", new Date(), this.getEmployeeID(), "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}
	

	// GETTERS & SETTERS
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(String securityIncident) {
		this.securityIncidents.add(securityIncident);
	}
}
