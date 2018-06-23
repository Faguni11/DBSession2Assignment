
package com.example.dell.dbsession2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button login,reset,register;
EditText email,password;
DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=(Button)findViewById(R.id.b1);
        reset=(Button)findViewById(R.id.b2);
        register=(Button)findViewById(R.id.b3);
        email=(EditText)findViewById(R.id.et1);
        password=(EditText)findViewById(R.id.et2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em=email.getText().toString();
                String ps=password.getText().toString();

                String p=helper.searchPass(em);
                String t=helper.searchType(em);
                if(ps.equals(p)){
                    if(t.equalsIgnoreCase("Student")){
                        Intent i=new Intent(MainActivity.this,Student.class);
                        i.putExtra("eem",em);
                        i.putExtra("pass",ps);
                        startActivity(i);
                    }else
                        if(t.equalsIgnoreCase("Admin")){
                            Intent i=new Intent(MainActivity.this,Admin.class);
                            i.putExtra("eem",em);

                            startActivity(i);
                        }

                }else{
                    Toast.makeText(getApplicationContext(),"CREDENTIALS WRONG",Toast.LENGTH_SHORT).show();

                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,register.class);
                startActivity(i);
            }
        });
    }
}
