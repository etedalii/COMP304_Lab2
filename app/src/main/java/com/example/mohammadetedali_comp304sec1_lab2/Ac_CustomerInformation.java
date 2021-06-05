package com.example.mohammadetedali_comp304sec1_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Ac_CustomerInformation extends AppCompatActivity {
    ArrayList<Pizza> pizzas;
    Customer customer;
    EditText fullName, streetNumber, city, postalCode, phoneNumber, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_customer_information);

        Bundle bundle = getIntent().getExtras();
        pizzas = bundle.getParcelableArrayList("pizzalist");
        customer = bundle.getParcelable("customer");

        fullName = findViewById(R.id.fullName);
        streetNumber = findViewById(R.id.streetNumber);
        city = findViewById(R.id.city);
        postalCode = findViewById(R.id.postalCode);
        phoneNumber = findViewById(R.id.phoneNumber);
        email = findViewById(R.id.email);
    }

    public void onConfirmClick(View view) {
        if(fullName.getText().toString().isEmpty()){
            fullName.setError("Fullname is required!");
            return;
        }
        if(streetNumber.getText().toString().isEmpty()){
            streetNumber.setError("Street number is required!");
            return;
        }
        if(city.getText().toString().isEmpty()){
            city.setError("City is required!");
            return;
        }
        if(postalCode.getText().toString().isEmpty()){
            postalCode.setError("Postal code is required!");
            return;
        }
        if(phoneNumber.getText().toString().isEmpty()){
            phoneNumber.setError("Phone number is required!");
            return;
        }

        customer.setFullName(fullName.getText().toString());
        customer.setStreetNumber(streetNumber.getText().toString());
        customer.setCity(city.getText().toString());
        customer.setPostalCode(postalCode.getText().toString());
        customer.setPhoneNumber(phoneNumber.getText().toString());
        customer.setEmail(email.getText().toString());

        Intent intent = new Intent(this, Ac_ConfirmationPage.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("pizzalist", pizzas);
        bundle.putParcelable("customer", customer);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}