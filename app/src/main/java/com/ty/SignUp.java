package com.ty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {

    EditText edtuname,edtpwd;
    Button btnsignup;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtuname=findViewById(R.id.edt_udname);
        edtpwd=findViewById(R.id.edt_pdwd);
        btnsignup=findViewById(R.id.btn_signUp);
        login=findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
            }
        });
        firebaseDatabase=FirebaseDatabase.getInstance("https://ty-project-4ec46-default-rtdb.firebaseio.com/");
        databaseReference=firebaseDatabase.getReference("users");
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName=edtuname.getText().toString();

                String password=edtpwd.getText().toString();

                ContactModel contact=new ContactModel();
                String userkey=databaseReference.push().getKey();
                contact.setUserName(userName);
                contact.setPassword(password);
                //Check if user already exists
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(userName).exists()){
                            Toast.makeText(SignUp.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            databaseReference.child(userName).setValue(contact);
                            Toast.makeText(SignUp.this, "User created", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(SignUp.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }

                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {

                                                            }
                                                        }
                );


            }
        });



    }
}
