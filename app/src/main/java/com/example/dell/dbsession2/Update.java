package com.example.dell.dbsession2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_PASSWORD="password";
    private static final String COLUMN_EMAIL="email";
  //  SQLiteDatabase db;
    DatabaseHelper helper=new DatabaseHelper(this);
    Button update;
    EditText email,password;
//DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);

        update=(Button)findViewById(R.id.btn15);
        email=(EditText)findViewById(R.id.et15);
        password=(EditText)findViewById(R.id.et16);
        Intent i=getIntent();
        final String em=i.getStringExtra("email");




        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l=email.getText().toString();
                String m=password.getText().toString();
                int x=helper.updateData(l,m);
                if(x==1){
                    Toast.makeText(getApplicationContext(),"UPDATED",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Update.this,MainActivity.class);
                    startActivity(i);
                }

            }
        });

    }
    }
