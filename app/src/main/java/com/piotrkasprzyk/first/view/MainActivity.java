package com.piotrkasprzyk.first.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.R;
import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.presenter.ContactsListPresenterImpl;
import com.piotrkasprzyk.first.repository.DummyContactsRepositoryImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.ContactsListView {

    private Contract.ContactsListPresenter presenter = new ContactsListPresenterImpl(DummyContactsRepositoryImpl.getInstance());

    private RecyclerView contactRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static String KEY_INTENT_CONTACT = "KEY_CONTACT";


    @Override
    public void setContacts(List<Contact> contacts) {
        mAdapter.updateList(contacts);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        initPresenter();

    }

    private void initUi() {
        contactRecyclerView = findViewById(R.id.contact_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        contactRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        contactRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(this);
        contactRecyclerView.setAdapter(mAdapter);
    }

    private void initPresenter(){
        presenter.attachView(this);
        presenter.loadData();
    }
}
