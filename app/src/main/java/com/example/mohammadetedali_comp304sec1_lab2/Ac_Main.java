package com.example.mohammadetedali_comp304sec1_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ac_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void raise_event(View view) {
        if (view.getId() == R.id.btnOrder){
            Intent intent = new Intent(this,Ac_SelectPizza.class);
            startActivity(intent);
        }
    }
}