package com.piotrkasprzyk.first.utils;

import android.os.AsyncTask;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.repository.ContactsRepository;

import java.util.List;


public class ContactFetcherAssyncTask extends AsyncTask<Void, Integer,List<Contact>> {
    private Contract.ContactsListPresenter contactsPresenter;

    public ContactFetcherAssyncTask(Contract.ContactsListPresenter contactsPresenter) {
        this.contactsPresenter = contactsPresenter;
    }

    @Override
    protected void onPostExecute(List<Contact> contacts) {
        super.onPostExecute(contacts);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected List<Contact> doInBackground(Void... voids) {
        contactsPresenter.loadData();

        return null;
    }
}
