package com.tech.contact_service.controller;

import com.tech.contact_service.model.Contact;
import com.tech.contact_service.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts(){
        return new ResponseEntity<List<Contact>>(contactService.getAllContacts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Contact>> getAllContactsByUserId(@PathVariable Long id){
        return new ResponseEntity<List<Contact>>(contactService.getAllContactsByUserId(id), HttpStatus.OK);
    }
}
