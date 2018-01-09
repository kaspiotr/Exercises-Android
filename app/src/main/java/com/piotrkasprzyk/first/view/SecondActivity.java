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

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity implements Contract.ContactView {

    private Contract.Presenter secondPresenter = new ContactPresenterImpl(DummyContactsRepositoryImpl.getInstance());

    @BindView(R.id.image_contact) ImageView contactImageView;
    @BindView(R.id.text_number) TextView phoneTextView;
    @BindView(R.id.text_email) TextView emailTextView;
    @BindView(R.id.text_website) TextView websiteTextView;
    @BindView(R.id.my_toolbar) Toolbar myToolbar;

    @Override
    public void setContact(Contact contact) {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(contact.getFirstName() + " " + contact.getLastName());
        }

        Picasso.with(this)
                .load(contact.getAvatar())
                .resize(450, 280)
                .centerCrop()
                .into(contactImageView);

        phoneTextView.setText(contact.getPhone());
        emailTextView.setText(contact.getEmail());
        websiteTextView.setText(contact.getEmail());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        ButterKnife.bind(this);

        initUi();
        initPresenter();
    }

    @Override
    protected void onDestroy() {
        displayToast();
        super.onDestroy();
    }

    private void initUi() {
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
