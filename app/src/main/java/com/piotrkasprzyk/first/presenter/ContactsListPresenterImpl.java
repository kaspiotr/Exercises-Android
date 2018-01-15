package com.piotrkasprzyk.first.presenter;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.repository.ContactsRepository;
import com.piotrkasprzyk.first.repository.RestContactsRepositoryImpl;

public class ContactsListPresenterImpl extends PresenterImpl implements Contract.ContactsListPresenter {

    public ContactsListPresenterImpl(ContactsRepository repository) {
        super(repository);
    }

    @Override
    public void attachView(Contract.View view) {
        setView(view);
    }

    @Override
    public void loadData() {
        ContactsLoadingAsyncTask asyncTask = new ContactsLoadingAsyncTask((RestContactsRepositoryImpl) getRepository(), (Contract.ContactsListView) getView());
        asyncTask.execute();
    }
}
