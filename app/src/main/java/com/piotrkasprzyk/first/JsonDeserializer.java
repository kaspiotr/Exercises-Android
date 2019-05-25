package com.piotrkasprzyk.first;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.piotrkasprzyk.first.pojo.Contact;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonDeserializer {
    public static List<Contact> deserializeContact(String gsonFileName) throws FileNotFoundException {
        List<Contact> contacts;
        Type LIST_CONTACTS_TYPE = new TypeToken<List<Contact>>() {
        }.getType();

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(gsonFileName));
        contacts = gson.fromJson(reader, LIST_CONTACTS_TYPE);


        return contacts;
    }
}