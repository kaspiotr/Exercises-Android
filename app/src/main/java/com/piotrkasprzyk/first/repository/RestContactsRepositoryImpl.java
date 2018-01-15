package com.piotrkasprzyk.first.repository;

import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.services.ContactsService;

import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestContactsRepositoryImpl implements ContactsRepository {

    private ContactsService service;

    public RestContactsRepositoryImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jaksiemaszcare-training-mobile.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ContactsService.class);
    }

    @Override
    public void loadData() {
    }

    @Override
    public void saveData() {

    }

    @Override
    public List<Contact> getContacts() {
        try {
            return service.getContacts().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
