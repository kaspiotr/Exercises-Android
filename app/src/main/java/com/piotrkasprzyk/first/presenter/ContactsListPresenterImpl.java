package com.piotrkasprzyk.first.presenter;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.repository.ContactsRepository;

public class ContactsListPresenterImpl extends PresenterImpl implements Contract.ContactsListPresenter {
    public ContactsListPresenterImpl(ContactsRepository instance) {
        super(instance);
    }

    @Override
    public void attachView(Contract.View view) {
        setView(view);
    }

    @Override
    public void loadData() {
        ((Contract.ContactsListView) getView())
                .setContacts(((ContactsRepository) getRepository()).getContacts());
    }
}
