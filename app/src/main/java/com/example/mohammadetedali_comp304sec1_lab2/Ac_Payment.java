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

        Bundle bundle = getIntent().getExtras();
        pizzas = bundle.getParcelableArrayList("pizzalist");

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        cardNumber = findViewById(R.id.cardNum);
        expireDate = findViewById(R.id.date);
        rdbCach = findViewById(R.id.cach);
    }

    public void raise_event(View view) {
        if (view.getId() == R.id.cach || view.getId() == R.id.credit_card || view.getId() == R.id.debit_card) {
            isPaymentSelected = true;
            // Is the radio button now checked?
            boolean checked = ((RadioButton) view).isChecked();
            // Check which radio button was clicked
            switch (view.getId()) {
                case R.id.cach:
                    if (checked) {
                        setEditStatus(false);
                    }
                    break;
                case R.id.credit_card:
                case R.id.debit_card:
                    if (checked) {
                        setEditStatus(true);
                    }
                    break;
            }
        } else {
            paymentProcess();
        }
    }

    private void paymentProcess() {
        if (!isPaymentSelected) {
            Toast.makeText(getApplicationContext(), "Select a payment method", Toast.LENGTH_LONG).show();
            return;
        }

        if (!rdbCach.isChecked() && (firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() ||
                cardNumber.getText().toString().isEmpty() || expireDate.getText().toString().isEmpty())) {
            Toast.makeText(getApplicationContext(), "Enter the payment information to proceed", Toast.LENGTH_LONG).show();
            return;
        }

        Customer customer = new Customer();
        customer.setExpireDate(expireDate.getText().toString());
        customer.setCardNumber(cardNumber.getText().toString());
        customer.setFirstName(firstName.getText().toString());
        customer.setLastName(lastName.getText().toString());

        Intent intent = new Intent(this, Ac_CustomerInformation.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("pizzalist", pizzas);
        bundle.putParcelable("customer", customer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void setEditStatus(boolean status) {
        lastName.setEnabled(status);
        firstName.setEnabled(status);
        cardNumber.setEnabled(status);
        expireDate.setEnabled(status);
    }

}