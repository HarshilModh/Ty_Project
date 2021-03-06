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

public class MainActivity extends AppCompatActivity {

    EditText edtUname,edtPwd;
    Button btnLogin;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUname=findViewById(R.id.edt_uname);
        edtPwd=findViewById(R.id.edt_pwd);
        btnLogin=findViewById(R.id.btn_login);
        tvRegister=findViewById(R.id.btn_signUp);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });
        firebaseDatabase=FirebaseDatabase.getInstance("https://ty-project-4ec46-default-rtdb.firebaseio.com/");
        databaseReference=firebaseDatabase.getReference("users");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=edtUname.getText().toString();
                String password=edtPwd.getText().toString();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        for(DataSnapshot dataSnapshot1:snapshot.getChildren()){

                            ContactModel contact=dataSnapshot1.getValue(ContactModel.class);

                            if(userName.equals(contact.getUserName())&& password.equals(contact.getPassword())){

                                Toast.makeText(getApplicationContext(),"Log in Successfully",Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(MainActivity.this,Home.class);

                                startActivity(i);
                                finish();
                            }
//                            else{
//                                Toast.makeText(getApplicationContext(),"Invalid Crendialts",Toast.LENGTH_SHORT).show();
//
//                            }


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}