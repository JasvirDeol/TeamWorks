package com.example.teamworks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        t1=findViewById(R.id.editText);
        t2=findViewById(R.id.editText2);
         t3=findViewById(R.id.editText3);
        t4=findViewById(R.id.editText4);
        Button b1=findViewById(R.id.button3);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String emailid=t1.getText().toString();
             String name=t2.getText().toString();
             String password=t3.getText().toString();
             String confirmpassword=t4.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(!emailid.matches(emailPattern))
                {
                    Toast.makeText(SignUp.this, "Enter a valid email", Toast.LENGTH_SHORT).show();
                }
                else if(!password.equals(confirmpassword))
                {
                    Toast.makeText(SignUp.this, "Password not matched", Toast.LENGTH_SHORT).show();
                }
             User user=new User(SignUp.this);
             boolean b=user.addUser(emailid,name,password);
             if(b)
             {
                 Toast.makeText(SignUp.this, "User Added", Toast.LENGTH_SHORT).show();
             }


            }
        });
    }


}
