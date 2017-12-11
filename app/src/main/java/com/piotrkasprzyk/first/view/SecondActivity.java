package com.piotrkasprzyk.first.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.R;
import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.presenter.ContactPresenterImpl;
import com.piotrkasprzyk.first.repository.DummyContactsRepositoryImpl;
import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity implements Contract.ContactView {

    private Contract.Presenter secondPresenter = new ContactPresenterImpl(DummyContactsRepositoryImpl.getInstance());

    @Override
    public void setContact(Contact contact) {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(contact.getName());
        }

        Picasso.with(this)
                .load("https://i.imgur.com/EWank4D.jpg") //original: 450X281
                .resize(450, 280)
                .centerCrop()
                .into((ImageView) findViewById(R.id.image_contact));

        ((TextView) findViewById(R.id.text_number)).setText(contact.getPhoneNumber());
        ((TextView) findViewById(R.id.text_email)).setText(contact.getEmail());
        ((TextView) findViewById(R.id.text_website)).setText(contact.getWebsite());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        initUi();
        initPresenter();
    }

    @Override
    protected void onDestroy() {
        displayToast();
        super.onDestroy();
    }

    private void initUi() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Intent intent = getIntent();
        Contact contact = intent.getParcelableExtra(MainActivity.KEY_INTENT_CONTACT);
        setContact(contact);
    }

    private void initPresenter() {
        secondPresenter.attachView(this);
        secondPresenter.loadData();
    }

    private void displayToast() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.msg_closing_activity);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
