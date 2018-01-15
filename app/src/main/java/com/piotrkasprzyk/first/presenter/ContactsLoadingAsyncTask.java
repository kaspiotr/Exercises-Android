package com.piotrkasprzyk.first.presenter;

import android.os.AsyncTask;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.repository.RestContactsRepositoryImpl;

import java.util.List;

public class ContactsLoadingAsyncTask extends AsyncTask<Void, Integer, List<Contact>> {

    private final Contract.ContactsListView view;
    private RestContactsRepositoryImpl repository;

    public ContactsLoadingAsyncTask(RestContactsRepositoryImpl repository, Contract.ContactsListView view) {
        super();
        this.repository = repository;
        this.view = view;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        view.showProgress();
    }

    @Override
    protected List<Contact> doInBackground(Void... voids) {
        return repository.getContacts();
    }

    @Override
    protected void onPostExecute(List<Contact> contacts) {
        view.hideProgress();
        view.setContacts(contacts);
    }

}
