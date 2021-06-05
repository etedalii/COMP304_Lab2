package com.example.mohammadetedali_comp304sec1_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ac_OrderDetail extends AppCompatActivity {
    ListView lst_pizza;
    ArrayList<Pizza> pizzas;
    Spinner pizza_size_spinner;
    TextView txv_totalPrice;
    boolean doughSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_order_detail);

        Bundle bundle = getIntent().getExtras();
        pizzas = bundle.getParcelableArrayList("pizzalist");

        pizza_size_spinner = (Spinner) findViewById(R.id.pizza_size_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pizza_size_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        pizza_size_spinner.setAdapter(adapter);

        txv_totalPrice = findViewById(R.id.txv_totalPrice);
        lst_pizza = findViewById(R.id.lstPizza);
        updatedPizzaList();

        //This event check if the size of pizza was change the List view update base on new data
        pizza_size_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (Pizza item : pizzas) {
                    item.setDough(pizza_size_spinner.getSelectedItem().toString());
                    switch (pizza_size_spinner.getSelectedItem().toString()) {
                        case "Small":
                            break;
                    }
                }
                updatedPizzaList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void updatedPizzaList() {
        ArrayAdapter<Pizza> pizzaAdapter = new ArrayAdapter<Pizza>(getApplicationContext(),
                android.R.layout.simple_list_item_1, pizzas);
        lst_pizza.setAdapter(pizzaAdapter);

        int totalPrice = 0;
        for (Pizza item : pizzas) {
            totalPrice += item.getPrice();
        }
        txv_totalPrice.setText(String.format("$ %s", String.valueOf(totalPrice)));
    }

    public void onRadioButtonClicked(View view) {
        doughSelected = true;
        // Is the radio button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.thin_crust:
                if (checked) {
                    for (Pizza item : pizzas) {
                        item.setType("Thin Crust");
                    }
                }
                break;
            case R.id.thick_crust:
                if (checked) {
                    for (Pizza item : pizzas) {
                        item.setType("Thick Crust");
                    }
                }
                break;
        }
        updatedPizzaList();
    }

    public void onCheckoutClick(View view) {
        if (!doughSelected) {
            Toast.makeText(getBaseContext(), "Select a style of pizza", Toast.LENGTH_LONG).show();
            return;
        }
        if (view.getId() == R.id.btnCheckOut) {
            Intent intent = new Intent(this, Ac_Payment.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pizzalist", pizzas);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}