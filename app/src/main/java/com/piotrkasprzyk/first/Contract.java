package com.piotrkasprzyk.first;

import com.piotrkasprzyk.first.pojo.Contact;

import java.util.List;

public interface Contract {
    interface View {

    }

    interface ContactView extends View {
        void setContacts(List<Contact> contacts);
    }

    interface Presenter {
        void attachView(Contract.View view);

        void detachView();

        void loadData();
    }

    interface ContactPresenter extends Presenter {

    }
}
