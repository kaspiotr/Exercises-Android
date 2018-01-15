package com.piotrkasprzyk.first.repository;

import com.piotrkasprzyk.first.pojo.Contact;

import java.util.List;

public interface ContactsRepository extends Repository {
    List<Contact> getContacts();
}
