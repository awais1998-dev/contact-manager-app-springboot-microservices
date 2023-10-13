package com.tech.contact_service.service;

import com.tech.contact_service.model.Contact;
import com.tech.contact_service.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getAllContactsByUserId(Long id) {
        return contactRepository.findAllByUserId(id);
    }
}
