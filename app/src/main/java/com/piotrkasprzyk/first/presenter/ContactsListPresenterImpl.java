package com.piotrkasprzyk.first.presenter;

import android.widget.ProgressBar;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.repository.ContactsRepository;
import com.piotrkasprzyk.first.repository.RestContactsRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ContactsListPresenterImpl extends PresenterImpl implements Contract.ContactsListPresenter {
    private ProgressBar progressBar;
    private List<Contact> contactsList;


    public ContactsListPresenterImpl(ContactsRepository repository, ProgressBar progressBar) {
        super(repository);
        this.progressBar = progressBar;
        this.contactsList = new ArrayList<>();
    }

    @Override
    public void attachView(Contract.View view) {
        setView(view);
    }

    @Override
    public void loadData() {
        ContactsLoadingAsyncTask asyncTask = new ContactsLoadingAsyncTask((RestContactsRepositoryImpl) getRepository(), (Contract.ContactsListView) getView(), progressBar);
        asyncTask.execute();
    }
}
