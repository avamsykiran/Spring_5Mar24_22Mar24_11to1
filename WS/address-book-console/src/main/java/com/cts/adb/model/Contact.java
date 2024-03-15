package com.cts.adb.model;

import java.time.LocalDate;
import java.util.Objects;

public class Contact {

	private int contactId;
	private String fullName;
	private String mobileNumber;
	private String meilId;
	private LocalDate dateOfBith;
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(int contactId, String fullName, String mobileNumber, String meilId, LocalDate dateOfBith) {
		super();
		this.contactId = contactId;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.meilId = meilId;
		this.dateOfBith = dateOfBith;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMeilId() {
		return meilId;
	}

	public void setMeilId(String meilId) {
		this.meilId = meilId;
	}

	public LocalDate getDateOfBith() {
		return dateOfBith;
	}

	public void setDateOfBith(LocalDate dateOfBith) {
		this.dateOfBith = dateOfBith;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", fullName=" + fullName + ", mobileNumber=" + mobileNumber
				+ ", meilId=" + meilId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactId, fullName, meilId, mobileNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return contactId == other.contactId && Objects.equals(fullName, other.fullName)
				&& Objects.equals(meilId, other.meilId) && Objects.equals(mobileNumber, other.mobileNumber);
	}
	
	
}
