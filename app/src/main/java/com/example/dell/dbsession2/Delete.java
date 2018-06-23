package com.example.dell.dbsession2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
   EditText email;
   Button delete;
   DatabaseHelper databaseHelper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_activity);

        email=(EditText)findViewById(R.id.et20);
        delete=(Button)findViewById(R.id.btn20);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


Integer deletedRows=databaseHelper.deleteData(email.getText().toString());
if(deletedRows>0){
    Toast.makeText(getApplicationContext(),"DATA DELETED",Toast.LENGTH_SHORT).show();

}
else{
    Toast.makeText(getApplicationContext(),"DATA NOT DELETED",Toast.LENGTH_SHORT).show();
}
            }
        });
    }
    }
