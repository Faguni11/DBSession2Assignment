package com.example.dell.dbsession2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Student extends AppCompatActivity {
    Button show,edit;
    TextView email,phone,password,type;
    DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_activity);

        show=(Button)findViewById(R.id.b5);
        edit=(Button)findViewById(R.id.b6);
        email=(TextView) findViewById(R.id.t1);
        phone=(TextView) findViewById(R.id.t2);
        password=(TextView) findViewById(R.id.t3);
        type=(TextView) findViewById(R.id.t4);
        Intent i=getIntent();
        final String email1=i.getStringExtra("eem");
        final String pass1=i.getStringExtra("pass");


        final String t=helper.searchType(email1);
       final String ph=helper.searchPhone(email1);

       show.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               email.setText(email1);
               phone.setText(ph);
               password.setText(pass1);
               type.setText(t);



           }
       });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Student.this,Update.class);
                i.putExtra("email",email1);
                startActivity(i);
                            }
        });

        }
    }
