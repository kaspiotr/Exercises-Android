package com.piotrkasprzyk.first;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.piotrkasprzyk.first.pojo.Contact;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        loadContactData(actionBar);

    }

    @Override
    protected void onDestroy() {
        displayToast();
        super.onDestroy();
    }

    private void loadContactData(ActionBar actionBar) {
        Contact defaultContact = new Contact();

        defaultContact.setName("Jessica Alba");
        defaultContact.setPhoneNumber("25369852447863");
        defaultContact.setEmail("jessica@alba.com");
        defaultContact.setWebsite("http://jessicaalba.com");

        if (actionBar != null) {
            actionBar.setTitle(defaultContact.getName());
        }

        ((TextView) findViewById(R.id.text_number)).setText(defaultContact.getPhoneNumber());
        ((TextView) findViewById(R.id.text_email)).setText(defaultContact.getEmail());
        ((TextView) findViewById(R.id.text_website)).setText(defaultContact.getWebsite());
    }

    private void displayToast() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.msg_closing_activity);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
