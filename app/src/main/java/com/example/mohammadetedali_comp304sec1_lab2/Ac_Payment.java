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
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Ac_Payment extends AppCompatActivity {
    ArrayList<Pizza> pizzas;
    EditText firstName, lastName, cardNumber, expireDate;
    boolean isPaymentSelected = false;
    RadioButton rdbCach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_payment);

        //These two line get the data from the previous page
        Bundle bundle = getIntent().getExtras();
        pizzas = bundle.getParcelableArrayList("pizzalist");

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        cardNumber = findViewById(R.id.cardNum);
        expireDate = findViewById(R.id.date);
        rdbCach = findViewById(R.id.cach);
    }

    //this event raise when user click on the radio button to select the payment method or click on Pay Button
    public void raise_event(View view) {
        //
        if (view.getId() == R.id.cach || view.getId() == R.id.credit_card || view.getId() == R.id.debit_card) {
            isPaymentSelected = true;
            // Is the radio button now checked?
            boolean checked = ((RadioButton) view).isChecked();
            // Check which radio button was clicked
            switch (view.getId()) {
                case R.id.cach:
                    if (checked) {
                        //disable control when payment mode is cach
                        setEditStatus(false);
                    }
                    break;
                case R.id.credit_card:
                case R.id.debit_card:
                    if (checked) {
                        //enable the control for data entry
                        setEditStatus(true);
                    }
                    break;
            }
        } else {// this section belongs to the button click
            paymentProcess();
        }
    }

    private void paymentProcess() {
        //check whether user select the payment option or not
        if (!isPaymentSelected) {
            Toast.makeText(getApplicationContext(), "Select a payment method", Toast.LENGTH_LONG).show();
            return;
        }

        //if user select mode other than cach and put fill empty get error message
        if (!rdbCach.isChecked() && (firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() ||
                cardNumber.getText().toString().isEmpty() || expireDate.getText().toString().isEmpty())) {
            Toast.makeText(getApplicationContext(), "Enter the payment information to proceed", Toast.LENGTH_LONG).show();
            return;
        }

        //Create a instance of Customer class
        Customer customer = new Customer();
        customer.setExpireDate(expireDate.getText().toString());
        customer.setCardNumber(cardNumber.getText().toString());
        customer.setFirstName(firstName.getText().toString());
        customer.setLastName(lastName.getText().toString());

        //pass the customer information and pizza list to next activity
        Intent intent = new Intent(this, Ac_CustomerInformation.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("pizzalist", pizzas);
        bundle.putParcelable("customer", customer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //disable or enable the edittext base on the payment option
    private void setEditStatus(boolean status) {
        lastName.setEnabled(status);
        firstName.setEnabled(status);
        cardNumber.setEnabled(status);
        expireDate.setEnabled(status);
    }
}