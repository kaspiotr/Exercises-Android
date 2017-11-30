package com.piotrkasprzyk.first.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
    private String name;
    private String phoneNumber;
    private String email;
    private String website;
    private String profilePictureURL;

    public Contact() {

    }

    protected Contact(Parcel in) {
        name = in.readString();
        phoneNumber = in.readString();
        email = in.readString();
        website = in.readString();
        profilePictureURL = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phoneNumber);
        dest.writeString(email);
        dest.writeString(website);
        dest.writeString(profilePictureURL);
    }
}
