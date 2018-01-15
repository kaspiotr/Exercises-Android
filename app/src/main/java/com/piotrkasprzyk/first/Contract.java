package com.piotrkasprzyk.first;

import com.piotrkasprzyk.first.pojo.Contact;

import java.util.List;

public interface Contract {
    interface View {

    }

    interface ContactsListView extends View {
        void setContacts(List<Contact> contacts);

        void showProgress();

        void hideProgress();
    }

    interface ContactView extends View {
        void setContact(Contact contact);
    }

    interface Presenter {
        void attachView(Contract.View view);

        void detachView();

        void loadData();
    }

    interface ContactsListPresenter extends Presenter {

    }

    interface ContactPresenter extends Presenter {

    }
}
