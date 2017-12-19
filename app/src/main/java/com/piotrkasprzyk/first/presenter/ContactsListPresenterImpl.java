package com.piotrkasprzyk.first.presenter;

import android.os.AsyncTask;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.repository.ContactsRepository;

import java.util.List;

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
        new AsyncTask<Void, Integer, List<Contact>>() {
            @Override
            protected void onPostExecute(List<Contact> contacts) {
                ((Contract.ContactsListView) getView()).setContacts(contacts);
            }

            @Override
            protected List<Contact> doInBackground(Void... voids) {
                List<Contact> contacts = ((ContactsRepository) getRepository()).getContacts();
                return contacts;

            }
        }.execute();
    }
}
