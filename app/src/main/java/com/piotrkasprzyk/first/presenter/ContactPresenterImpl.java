package com.piotrkasprzyk.first.presenter;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.repository.ContactsRepository;

public class ContactPresenterImpl extends PresenterImpl implements Contract.ContactPresenter {

    public ContactPresenterImpl(ContactsRepository repository) {
        super(repository);
    }

    @Override
    public void loadData() {
        super.loadData();
    }
}
