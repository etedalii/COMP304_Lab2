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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Ac_ConfirmationPage extends AppCompatActivity {
    private ArrayList<Pizza> pizzas;
    private Customer customer;
    ListView lst_pizza;
    TextView txv_Customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_confirmation_page);
        // customer and pizza list from the previous activity
        Bundle bundle = getIntent().getExtras();
        pizzas = bundle.getParcelableArrayList("pizzalist");
        customer = bundle.getParcelable("customer");

        lst_pizza = findViewById(R.id.lstPizza);
        txv_Customer = findViewById(R.id.txv_customer);

        //set the pizza list in List view adaptor to show
        ArrayAdapter<Pizza> pizzaAdapter = new ArrayAdapter<Pizza>(getApplicationContext(),
                android.R.layout.simple_list_item_1, pizzas);
        lst_pizza.setAdapter(pizzaAdapter);

        //show the customer information in the text view
        // I use one text view and break a line for each data
        txv_Customer.setText(String.format("%s \r\n %s \r\n %s", customer.getFullName(), customer.getPhoneNumber(),
                customer.getFullAddress()));
    }
    //this event when call return to the home activity
    public void onReturnHomeClicked(View view) {
        Intent intent = new Intent(this, Ac_Main.class);
        startActivity(intent);
    }
}