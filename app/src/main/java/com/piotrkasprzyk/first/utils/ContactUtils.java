package com.piotrkasprzyk.first.utils;

import android.support.annotation.NonNull;

import com.piotrkasprzyk.first.pojo.Contact;

public class ContactUtils {

    @NonNull
    public static Contact createContact() {
        Contact defaultContact = new Contact();

        defaultContact.setName("Jessica Alba");
        defaultContact.setPhoneNumber("25369852447863");
        defaultContact.setEmail("jessica@alba.com");
        defaultContact.setWebsite("http://jessicaalba.com");
        return defaultContact;
    }

}
