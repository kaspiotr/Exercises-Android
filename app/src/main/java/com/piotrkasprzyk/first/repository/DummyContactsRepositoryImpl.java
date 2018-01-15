package com.piotrkasprzyk.first.repository;

import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.utils.ContactUtils;

import java.util.List;

public class DummyContactsRepositoryImpl implements ContactsRepository {

    private static DummyContactsRepositoryImpl instance;
    private final List<Contact> contacts;

    private DummyContactsRepositoryImpl(){
        contacts = ContactUtils.createContactList(10);
    }

    public static DummyContactsRepositoryImpl getInstance() {

        if (instance == null) instance = new DummyContactsRepositoryImpl();
        return instance;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void saveData() {

    }

    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public Contact getContactById(int id) {
        return contacts.get(id);
    }
}
