package com.example.sqlitetry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context c;
    String id[];
    String user[];
    String password[];
    LayoutInflater inflater;
    public CustomAdapter(Context c, String[] id, String[] user, String[] password) {
        this.c = c;
        this.id = id;
        this.user = user;
        this.password = password;
        inflater = LayoutInflater.from(c);
    }
    @Override
    public int getCount() {
        return id.length;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_main2,null);
        TextView no = (TextView) convertView.findViewById(R.id.tvid);
        TextView users = (TextView) convertView.findViewById(R.id.tvnama);
        TextView passwords = (TextView) convertView.findViewById(R.id.tvpassword);
        no.setText(id[position]);
        users.setText(user[position]);
        passwords.setText(password[position]);
        return convertView;
    }
}
