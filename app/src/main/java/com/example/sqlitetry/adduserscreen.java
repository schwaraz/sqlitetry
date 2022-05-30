package com.example.sqlitetry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;


public class adduserscreen extends AppCompatActivity {
    EditText Euser;
    EditText Epass;
    DBHandler mydb;
    DataModel usermodel;
    Intent intentkeawal;
    Button b1;
    int state = 0;
//    private View.OnClickListener myClickListener = new View.OnClickListener() {
//
//        @Override
//        public void onClick(View v) {
//            switch(v.getId()){
//                case R.id.button2:
//                    Euser =(EditText) findViewById(R.id.edittextuser);
//                    Epass =(EditText) findViewById(R.id.edittextpassword);
//                    String a = Euser.getText().toString();
//                    String b = Epass.getText().toString();
//                    int c = mydb.getdatacount();
//                    int id = c + 1;
//                    Log.d("tes","isi dari c="+c);
//                    if (TextUtils.isEmpty(Euser.getText().toString()) || (TextUtils.isEmpty(Epass.getText().toString()))){
//                        Toast.makeText(adduserscreen.this,
//                                "Empty field not allowed!",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                    else
//                    {
//                        Log.d("tes","data masuk if");
//
////                        usermodel = new DataModel(id,a,b);
////                        mydb.insertUser(usermodel);
//                        state = 1;
//                    }
//                    break;
//
//        }
//    }
//
//
//    };


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduserscreen);
        b1 = (Button)findViewById(R.id.button2);
            Log.d("tes","page2");
//            b1.setOnClickListener(myClickListener);
            mydb = new DBHandler(this);
//            if (state == 1){


            }

    public void backtostart(View view) {
        Log.d("tes","acntivity");

        Euser =(EditText) findViewById(R.id.edittextuser);
                    Epass =(EditText) findViewById(R.id.edittextpassword);
                    String a = Euser.getText().toString();
                    String b = Epass.getText().toString();
                    int c = mydb.getdatacount();
                    int id = c + 1;
                    Log.d("tes","isi dari c="+c);
                    if (TextUtils.isEmpty(Euser.getText().toString()) || (TextUtils.isEmpty(Epass.getText().toString()))){
                        Toast.makeText(adduserscreen.this,
                                "Empty field not allowed!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Log.d("tes","data masuk if");

                        usermodel = new DataModel(id,a,b);
                        mydb.insertUser(usermodel);
                        Intent intentkeawal = new Intent(this, MainActivity.class);
                        startActivity(intentkeawal);


                    }
    }
}



