package com.example.sqlitetry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DBHandler mydb;
    DataModel usermodel;
    ListView tabel;
    String coloum[]={"ID","USER","PASSWORD"};
    String id[];
    String user[], password[];
    ListView mylv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DBHandler(this);
        int c = mydb.getdatacount();
        int d = c+1;
        List<DataModel> a = mydb.getAll();
        mylv = (ListView) findViewById(R.id.list1);
        id = new String[d];
        user = new String[d];
        password = new String[d];
        id[0]= "ID";
        user[0]= "USERNAME";
        password[0]= "PASSWORD";
        for(int tes = 1; tes <= c; tes++) {
            id[tes]= String.valueOf(a.get(tes-1).id);
            user[tes]= String.valueOf(a.get(tes-1).nama);
            password[tes]= String.valueOf(a.get(tes-1).password);
        }
        CustomAdapter aAdapter = new CustomAdapter(getApplicationContext(),id,user,password);
        mylv.setAdapter(aAdapter);

    }


    public void tambahuser(View view) {
        Intent i = new Intent(this,adduserscreen.class);
        startActivity(i);


    }
}