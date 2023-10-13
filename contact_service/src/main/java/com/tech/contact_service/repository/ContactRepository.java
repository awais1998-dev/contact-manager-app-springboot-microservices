package com.tech.contact_service.repository;

import com.tech.contact_service.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAllByUserId(Long id);
}
