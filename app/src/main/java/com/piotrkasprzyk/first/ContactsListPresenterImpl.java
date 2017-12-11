package com.piotrkasprzyk.first;

import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.utils.ContactUtils;

import java.util.List;

class ContactsListPresenterImpl extends PresenterImpl implements Contract.ContactsListPresenter {
    public ContactsListPresenterImpl(RepositoryImpl instance) {
        super(instance);
    }

    @Override
    public void attachView(Contract.View view) {
        setView(view);
    }

    @Override
    public void loadData() {
        List<Contact> contacts = ContactUtils.createContactList(10);
        ((Contract.ContactsListView) getView()).setContacts(contacts);
    }
}
