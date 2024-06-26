package com.cts.adb.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.adb.entities.Contact;

public interface ContactService {

	Contact add(Contact contact);

	void deleteById(int contactId);

	Contact getById(int contactId);

	List<Contact> getAll();

	default boolean existsByMailId(String mailId) { return false;}

	default boolean existsByMobileNumber(String mobileNumber) { return false;}

	default Contact getByMailId(String mailId) { return null; }

	default Contact getByMobileNumber(String mobileNumber) {return null; }

	default List<Contact> getAllByFullName(String fullName) {return null; }

	default List<Contact> getAllBornBetween(LocalDate start, LocalDate end) { return null; }

}
