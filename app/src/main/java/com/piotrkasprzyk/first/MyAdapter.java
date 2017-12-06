package com.piotrkasprzyk.first;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.piotrkasprzyk.first.pojo.Contact;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.piotrkasprzyk.first.MainActivity.KEY_INTENT_CONTACT;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    protected List<Contact> contacts;
    private final Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        // each data item is just a string in this case
        public View mView;
        private ImageView contactImage;
        private TextView contactName;
        private TextView email;

        public ViewHolder(View v) {
            super(v);
            mView = v;

            contactImage = v.findViewById(R.id.image_contact);
            contactName = v.findViewById(R.id.text_contact_name);
            email = v.findViewById(R.id.text_email);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), SecondActivity.class);
            intent.putExtra(KEY_INTENT_CONTACT, contacts.get(getAdapterPosition()));
            v.getContext().startActivity(intent);
        }


        @Override
        public boolean onLongClick(View v) {
            displayToast(v, getAdapterPosition());
            return true;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_layot, parent, false);
        // set the view's size, margins, paddings and layout parameters...
        ViewHolder vh = new ViewHolder(v);
        v.setOnClickListener(vh);
        v.setOnLongClickListener(vh);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.contactName.setText(contacts.get(position).getName());
        holder.email.setText(contacts.get(position).getEmail());
        Picasso.with(holder.contactImage.getContext())
                .load("https://i.imgur.com/EWank4D.jpg") //original: 450X281
                .resize(450, 280)
                .centerCrop()
                .into(holder.contactImage);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return contacts.size();
    }

    private void displayToast(View view, int position) {
        Context context = view.getContext();
        CharSequence text = "On long pressed test " + position;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
