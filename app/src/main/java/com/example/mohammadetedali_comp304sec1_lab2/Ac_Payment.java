package com.example.mohammadetedali_comp304sec1_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Ac_Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_payment);
    }

    public void raise_event(View view) {
        if(view.getId() == R.id.cach || view.getId() == R.id.credit_card || view.getId() == R.id.debit_card) {
            // Is the radio button now checked?
            boolean checked = ((RadioButton) view).isChecked();
            // Check which radio button was clicked
            switch (view.getId()) {
                case R.id.thin_crust:
                    if (checked) {

                    }
                    break;
                case R.id.thick_crust:
                    if (checked) {

                    }
                    break;
            }
        }
        else{

        }
    }
}