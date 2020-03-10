package com.example.demo.entities;

import java.util.Date;

public class SubscriptionRequest {

	private String email;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public boolean isConsentGiven() {
		return isConsentGiven;
	}
	public void setConsentGiven(boolean isConsentGiven) {
		this.isConsentGiven = isConsentGiven;
	}
	public int getNewsLetterId() {
		return newsLetterId;
	}
	public void setNewsLetterId(int newsLetterId) {
		this.newsLetterId = newsLetterId;
	}
	private String firstName;
	private String gender;
	private Date dateOfBirth;
	private boolean isConsentGiven;
	private int newsLetterId;
}
