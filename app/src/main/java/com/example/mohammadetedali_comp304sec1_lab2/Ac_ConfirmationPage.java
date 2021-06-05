package com.example.mohammadetedali_comp304sec1_lab2;

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

        Bundle bundle = getIntent().getExtras();
        pizzas = bundle.getParcelableArrayList("pizzalist");
        customer = bundle.getParcelable("customer");

        lst_pizza = findViewById(R.id.lstPizza);
        txv_Customer = findViewById(R.id.txv_customer);

        ArrayAdapter<Pizza> pizzaAdapter = new ArrayAdapter<Pizza>(getApplicationContext(),
                android.R.layout.simple_list_item_1, pizzas);
        lst_pizza.setAdapter(pizzaAdapter);

        txv_Customer.setText(String.format("%s \r\n %s \r\n %s", customer.getFullName(), customer.getPhoneNumber(),
                customer.getFullAddress()));
    }

    public void onReturnHomeClicked(View view) {
        Intent intent = new Intent(this, Ac_Main.class);
        startActivity(intent);
    }
}