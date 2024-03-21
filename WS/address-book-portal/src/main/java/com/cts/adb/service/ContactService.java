package com.cts.adb.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.adb.entities.Contact;

public interface ContactService {

	Contact add(Contact contact);

	void deleteById(int contactId);

	Contact getById(int contactId);

	List<Contact> getAll();

	boolean existsByMailId(String mailId);

	boolean existsByMobileNumber(String mobileNumber);

	Contact getByMailId(String mailId);

	Contact getByMobileNumber(String mobileNumber);

	List<Contact> getAllByFullName(String fullName);

	List<Contact> getAllBornBetween(LocalDate start, LocalDate end);

}
