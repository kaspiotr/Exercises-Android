package com.piotrkasprzyk.first.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.R;
import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.presenter.ContactsListPresenterImpl;
import com.piotrkasprzyk.first.repository.RestContactsRepositoryImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Contract.ContactsListView {

    private Contract.ContactsListPresenter presenter;

    @BindView(R.id.contact_recycler_view) RecyclerView contactRecyclerView;
    @BindView(R.id.indeterminate_bar) ProgressBar contactsBar;

    private MyAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    public static String KEY_INTENT_CONTACT = "KEY_CONTACT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUi();
        initPresenter();
    }

    @Override
    public void setContacts(List<Contact> contacts) {
        mAdapter.updateList(contacts);
    }

    private void initUi() {
        contactRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        contactRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(this);
        contactRecyclerView.setAdapter(mAdapter);
    }

    private void initPresenter() {
        presenter = new ContactsListPresenterImpl(new RestContactsRepositoryImpl(), contactsBar);
        presenter.attachView(this);
        presenter.loadData();
    }
}
