package com.example.dell.dbsession2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class register extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);

    Button submit;
    EditText email,phone,password,type;
    Spinner state;
    ArrayAdapter<String> stateAdapter;
    String stateIndia[]={"Delhi","Punjab","Bihar","Tamil Nadu","Jammu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        submit=(Button)findViewById(R.id.b4);
        email=(EditText)findViewById(R.id.et3);
        phone=(EditText)findViewById(R.id.et4);
        password=(EditText)findViewById(R.id.et5);
        type=(EditText)findViewById(R.id.et7);
        state=(Spinner)findViewById(R.id.et6);
        stateAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,stateIndia);
        state.setAdapter(stateAdapter);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(register.this,MainActivity.class);
                String email1=email.getText().toString();
                String phone1=phone.getText().toString();
                String password1=password.getText().toString();
                String type1=type.getText().toString();

                Contact con=new Contact();
                con.setEmail(email1);
                con.setPassword(password1);
                con.setPhone(phone1);
                con.setType(type1);
                helper.insertContact(con);
                startActivity(i);
            }
        });
    }
    }
