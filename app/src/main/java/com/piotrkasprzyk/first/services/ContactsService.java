package com.piotrkasprzyk.first.services;

import com.piotrkasprzyk.first.pojo.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactsService {
    @GET("api")
    Call<List<Contact>> getContacts();
}
