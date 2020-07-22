package com.example.teamworks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class SignIn extends AppCompatActivity {

    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
         t1=findViewById(R.id.editText5);
        t2=findViewById(R.id.editText6);
        Button b1=findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailid=t1.getText().toString();
                String password=t2.getText().toString();

                User user=new User(SignIn.this);
                Cursor c=user.viewUsers();
                int found=0;
                if(c.moveToFirst())
                {
                    do {
                            if(c.getString(c.getColumnIndex("emailid")).equals(emailid) && c.getString(c.getColumnIndex("password")).equals(password))
                            {
                                Intent in=new Intent(SignIn.this,HomeActivity.class);
                                in.putExtra("emailid",emailid);

                                startActivity(in);
                                found=1;
                                break;
                            }

                    }
                    while (c.moveToNext());
                }
                if(found==0)
                {
                  //  Toast.makeText(SignIn.this, "Invalid", Toast.LENGTH_SHORT).show();
                    Snackbar snackBar = Snackbar .make(view, "Login Failed. Please check your credentials", Snackbar.LENGTH_SHORT);
                    snackBar.show();
                }


            }
        });
    }
}
