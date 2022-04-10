package com.caresoft.clinicapp;
import java.util.ArrayList;


public class Physician extends User implements HIPAACompliantUser {
	// MEMBER VARIABLES
	private ArrayList<String> patientNotes;
	
	
	// CONSTRUCTORS
	public Physician(Integer ID) {
		super(ID);
		patientNotes = new ArrayList<String>();
	}
	
	
	// METHODS
	
	
	// GETTERS & SETTERS
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
	public void setPatientNotes(String patientNotes) {
		this.patientNotes.add(patientNotes);
	}
	
	public boolean assignPin(int pin) {
		this.setPin(pin);
		return true;
	}
	
	public boolean accessAuthorized(Integer confirmAuthID) {
		return this.getId() == confirmAuthID ? true : false;
	}
}
