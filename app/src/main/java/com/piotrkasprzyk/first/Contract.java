package com.piotrkasprzyk.first;

import com.piotrkasprzyk.first.pojo.Contact;

import java.util.List;

public interface Contract {
    interface View {

    }

    interface ContactsListView extends View {
        void setContacts(List<Contact> contacts);
        void openSecondView(int contactId);
    }

    interface ContactView extends View {

    }

    interface Presenter {
        void attachView(Contract.View view);

        void detachView();

        void loadData();
    }

    interface ContactsListPresenter extends Presenter {

    }
}
