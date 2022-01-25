package com.ty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText edtuname,edtpwd;
    Button btnsignup;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtuname=findViewById(R.id.edt_udname);
        edtpwd=findViewById(R.id.edt_pdwd);
        btnsignup=findViewById(R.id.btn_signUp);
        firebaseDatabase=FirebaseDatabase.getInstance("https://ty-project-4ec46-default-rtdb.firebaseio.com/");
        databaseReference=firebaseDatabase.getReference("users");
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName=edtuname.getText().toString();
                String password=edtpwd.getText().toString();
                String userkey=databaseReference.push().getKey();

                ContactModel contact=new ContactModel();
                contact.setUserName(userName);
                contact.setPassword(password);
                databaseReference.child(userkey).setValue(contact);
                edtuname.setText("");
                edtpwd.setText("");
                Intent i=new Intent(SignUp.this,MainActivity.class);
                startActivity(i);
                finish();


            }
        });



    }
}