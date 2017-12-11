package com.piotrkasprzyk.first.utils;

import android.support.annotation.NonNull;

import com.piotrkasprzyk.first.pojo.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactUtils {

    @NonNull
    public static Contact createContact() {
        Contact defaultContact = new Contact();

        defaultContact.setName("Jessica Alba");
        defaultContact.setPhoneNumber("25369852447863");
        defaultContact.setEmail("jessica@alba.com");
        defaultContact.setWebsite("http://jessicaalba.com");
        defaultContact.setProfilePictureURL("https://i.imgur.com/EWank4D.jpg");
        return defaultContact;
    }

    public static List<Contact> createContactList(int noOfElements){
        List<Contact> myContactList = new ArrayList<Contact>();

        String names[] = {"Jan", "Piotr", "Maria", "Jessica", "Kacper", "Anna"};
        String surnames[] = {"Nowak", "Kowal", "Carter", "Alba", "Eastwood", "Muller"};
        String numbers[] = {"11122233344455", "22233344455566", "33344455566677", "25369852447863", "25369852447863"};
        String emails[] = { "nowak@gmail.com", "eastwood@eastwood.com", "muller@muller.com", "jessica@alba.com", "piotr@gmail.com", "anna@interia.com"};
        String websites[] = {"http://mullerswebsite.com", "https://clinteastwood.com","http://jessicaalba.com", "http://kowalwebsite.com", "http://annaswebsite.com", "http://carterswebsite.com"};

        for(int i=0; i<noOfElements; i++){

            Contact someContact = new Contact();
            someContact.setName(names[new Random().nextInt(names.length)] + " " + surnames[new Random().nextInt(surnames.length)]);
            someContact.setPhoneNumber(numbers[new Random().nextInt(numbers.length)]);
            someContact.setEmail(emails[new Random().nextInt(emails.length)]);
            someContact.setWebsite(websites[new Random().nextInt(websites.length)]);
            someContact.setProfilePictureURL("https://i.imgur.com/EWank4D.jpg");

            myContactList.add(i,someContact);
        }

        return myContactList;
    }
}
