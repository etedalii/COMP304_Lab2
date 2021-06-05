package com.example.mohammadetedali_comp304sec1_lab2;
/*
    Author: Mohammad Etedali - 301056465
    Code updated: June 2021
    Course: 304 Sec 001
    Date: 6 June 2021
 */

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

        //these three line use to get data from previous activity, the pizza list and customer
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

    //this event raise when user click on the confirm button
    public void onConfirmClick(View view) {
        //check whether the necessary data was import or not
        if(!validateData())
            return;

        //Add the new data such as address and name and phone number to the customer entity
        customer.setFullName(fullName.getText().toString());
        customer.setStreetNumber(streetNumber.getText().toString());
        customer.setCity(city.getText().toString());
        customer.setPostalCode(postalCode.getText().toString());
        customer.setPhoneNumber(phoneNumber.getText().toString());
        customer.setEmail(email.getText().toString());

        //pass the customer entity and pizza list to the next activity
        Intent intent = new Intent(this, Ac_ConfirmationPage.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("pizzalist", pizzas);
        bundle.putParcelable("customer", customer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //check the edit text data is fill or not
    private  boolean  validateData(){
        if(fullName.getText().toString().isEmpty()){
            fullName.setError(getString(R.string.familyRequired));
            return false;
        }
        if(streetNumber.getText().toString().isEmpty()){
            streetNumber.setError(getString(R.string.streetRequired));
            return false;
        }
        if(city.getText().toString().isEmpty()){
            city.setError(getString(R.string.cityRequired));
            return false;
        }
        if(postalCode.getText().toString().isEmpty()){
            postalCode.setError(getString(R.string.postalCodeRequired));
            return false;
        }
        if(phoneNumber.getText().toString().isEmpty()){
            phoneNumber.setError(getString(R.string.phoneNumberRequired));
            return false;
        }

        return true;
    }
}