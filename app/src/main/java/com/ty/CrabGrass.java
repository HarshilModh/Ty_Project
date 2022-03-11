package com.ty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class CrabGrass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crab_grass);


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(CrabGrass.this, Home.class);
        startActivity(intent);
        finish();
    }

}