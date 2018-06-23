package com.example.dell.dbsession2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayAdmin extends AppCompatActivity {

    DatabaseHelper db=new DatabaseHelper(this);
    ListView lv;
    ArrayList<String>listItem;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        lv=(ListView)findViewById(R.id.listV);
        listItem=new ArrayList<>();
Intent i=getIntent();
String email=i.getStringExtra("em");

        viewData();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text=lv.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),""+text, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void viewData() {
String type1="Student";
        Cursor cursor=db.viewData(type1);

        if(cursor.getCount()==0){
            Toast.makeText(this,"NO DATA FOUND",Toast.LENGTH_SHORT).show();

        }else{
            while(cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }
            adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
            lv.setAdapter(adapter);
        }
    }
}
