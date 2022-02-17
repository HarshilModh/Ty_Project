package com.ty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button weeds,seeds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        weeds=findViewById(R.id.btn_weeds);
        seeds=findViewById(R.id.btn_seeds);
        seeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Seeds seeds=new Seeds();
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frame,seeds);
                fragmentTransaction.commit();

            }
        });
        weeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Weeds weeds=new Weeds();
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frame,weeds);
                fragmentTransaction.commit();

            }
        });
    }
}