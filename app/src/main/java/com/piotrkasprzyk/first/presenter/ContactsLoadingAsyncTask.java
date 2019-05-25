package com.piotrkasprzyk.first.presenter;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.repository.RestContactsRepositoryImpl;

import java.util.List;

public class ContactsLoadingAsyncTask extends AsyncTask<Void, Integer, List<Contact>> {

    private final Contract.ContactsListView view;
    private ProgressBar contactsBar;
    private RestContactsRepositoryImpl repository;

    public ContactsLoadingAsyncTask(RestContactsRepositoryImpl repository, Contract.ContactsListView view, ProgressBar contactsBar) {
        super();
        this.repository = repository;
        this.contactsBar = contactsBar;
        this.view = view;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        contactsBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected List<Contact> doInBackground(Void... voids) {
        return repository.getContacts();
    }

    @Override
    protected void onPostExecute(List<Contact> contacts) {
        contactsBar.setVisibility(View.GONE);
        view.setContacts(contacts);
    }

}
