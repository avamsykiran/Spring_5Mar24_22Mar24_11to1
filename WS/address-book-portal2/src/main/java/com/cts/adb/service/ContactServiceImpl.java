package com.cts.adb.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.adb.entities.Contact;
import com.cts.adb.repos.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactRepo;
	
	@Override
	public Contact add(Contact contact) {
		return contactRepo.save(contact);
	}

	@Override
	public void deleteById(int contactId) {
		contactRepo.deleteById(contactId);
	}

	@Override
	public Contact getById(int contactId) {
		return contactRepo.findById(contactId).orElse(null);
	}

	@Override
	public List<Contact> getAll() {
		return contactRepo.findAll();
	}

	@Override
	public boolean existsByMobileNumber(String mobileNumber) {
		return contactRepo.existsByMobileNumber(mobileNumber);
	}

	@Override
	public Contact getByMailId(String mailId) {
		return contactRepo.findByMeilId(mailId).orElse(null);
	}

	@Override
	public Contact getByMobileNumber(String mobileNumber) {
		return contactRepo.findByMobileNumber(mobileNumber).orElse(null);
	}

	@Override
	public List<Contact> getAllByFullName(String fullName) {
		return contactRepo.findAllByFullName(fullName);
	}

	@Override
	public List<Contact> getAllBornBetween(LocalDate start, LocalDate end) {
		return contactRepo.findAllBornBetween(start, end);
	}

	@Override
	public Contact update(Contact contact) {
		return contactRepo.save(contact);
	}
	
}
