package com.example.dell.dbsession2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Admin extends AppCompatActivity {
    Button delete,show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);

    delete=(Button)findViewById(R.id.delBtn);
        show=(Button)findViewById(R.id.showBtn);
Intent i=getIntent();
final String email=i.getStringExtra("eem");

    delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(Admin.this,Delete.class);
            startActivity(i);
        }
    });

    show.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(Admin.this,DisplayAdmin.class);
            i.putExtra("em",email);
            startActivity(i);
        }
    });
    }
    }
