package com.tech.contact_service.service;

import com.tech.contact_service.model.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getAllContacts();
    public List<Contact> getAllContactsByUserId(Long id);
}
