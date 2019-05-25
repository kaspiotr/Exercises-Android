package com.piotrkasprzyk.first.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.piotrkasprzyk.first.R;
import com.piotrkasprzyk.first.pojo.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    protected List<Contact> contacts;

    private final Context context;

    public MyAdapter(Context context) {
        this.contacts = new ArrayList<>();
        this.context = context;
    }

    public void updateList(List<Contact> contacts) {
        this.contacts.removeAll(contacts);
        this.contacts.addAll(contacts);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_contact) ImageView contactImage;
        @BindView(R.id.text_contact_name) TextView contactName;
        @BindView(R.id.text_email) TextView email;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

        @OnClick
        void onClick(View v) {
            Intent intent = new Intent(v.getContext(), SecondActivity.class);
            intent.putExtra(MainActivity.KEY_INTENT_CONTACT, contacts.get(getAdapterPosition()));
            v.getContext().startActivity(intent);
        }

        @OnLongClick
        boolean onLongClick() {
            removeItem(getAdapterPosition());
            return true;
        }

    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_layot, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = contacts.get(position);

        holder.contactName.setText(contact.getFirstName() + " " + contact.getLastName());
        holder.email.setText(contact.getEmail());
        Picasso.with(holder.contactImage.getContext())
                .load(contact.getAvatar())
                .resize(450, 280)
                .centerCrop()
                .into(holder.contactImage);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    private void removeItem(int position) {
        contacts.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, contacts.size());
    }
}


