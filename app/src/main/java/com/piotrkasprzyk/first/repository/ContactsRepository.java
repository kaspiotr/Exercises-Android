package com.piotrkasprzyk.first.repository;

import com.piotrkasprzyk.first.pojo.Contact;

import java.io.IOException;
import java.util.List;

public interface ContactsRepository extends Repository {
    List<Contact> getContacts();

    Contact getContactById(int id);
}
