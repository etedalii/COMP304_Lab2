package com.example.mohammadetedali_comp304sec1_lab2;
/*
    Author: Mohammad Etedali - 301056465
    Code updated: June 2021
    Course: 304 Sec 001
    Date: 6 June 2021
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Ac_SelectPizza extends AppCompatActivity {
    TextView txv_pizza_name;
    ImageView img_pizza_name, img_slice_pizza;
    ListView lst_pizza_ingredient;

    // Below arrays use for showing the pizza ingredients I create hard copy for each type of pizza
    String[] canadian_ingredients = new String[] {"Pizza Crust",
            "Pizza Sauce", "Mozzarella Cheese", "Canadian Bacon", "Mushrooms", "Bell Pepper"};
    String[] chiken_caesar_ingredients = new String[] {"Pizza Crust",
            "Chicken Breasts", "Monterey Jack cheese", "Minced garlic", "Parmesan cheese", "Green onions"};
    String[] hawaiian_pizza_ingredients = new String[] {"Pizza Crust",
            "Chicken Breasts", "Monterey Jack cheese", "Minced garlic", "Parmesan cheese", "Green onions"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_select_pizza);

        txv_pizza_name = findViewById(R.id.txv_pizza_name);
        img_pizza_name = findViewById(R.id.pizza_image);
        lst_pizza_ingredient = findViewById(R.id.pizza_ingredients);
        img_slice_pizza = findViewById(R.id.img_slice_pizza);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.pizza_menu,menu);
        return true ;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        img_slice_pizza.setVisibility(View.VISIBLE);
        switch (item.getItemId()) {
            case R.id.canadian_pizza:
                //set pizza name
                setPizza(getString(R.string.canadian_pizza));
                //set proper image for selected pizza
                img_pizza_name.setBackgroundResource(R.drawable.canadian_pizza);
                setListPizzaIngredientAdapter(canadian_ingredients);
                return true;
            case R.id.chiken_caesar:
                setPizza(getString(R.string.chiken_caesar));
                img_pizza_name.setBackgroundResource(R.drawable.chiken_caesar);
                setListPizzaIngredientAdapter(chiken_caesar_ingredients);
                return true;
            case R.id.hawaiian_pizza:
                setPizza(getString(R.string.hawaiian_pizza));
                img_pizza_name.setBackgroundResource(R.drawable.hawaiian);
                return true;
            case R.id.smoky_maple_pizza:
                setPizza(getString(R.string.smokey_maple_bacon));
                img_pizza_name.setBackgroundResource(R.drawable.smoky_maple);
                return true;
            case R.id.vaggie_lover_pizza:
                setPizza(getString(R.string.veggie_lover_s));
                img_pizza_name.setBackgroundResource(R.drawable.vaggie);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void raise_event(View view) {
        if (view.getId() == R.id.btnOrder){
           // Intent intent = new Intent(this,Ac_SelectPizza.class);
          //  startActivity(intent);
        }
    }

    //This method used for set a name in textView for pizza name
    private void setPizza(String name){
        txv_pizza_name.setText(name);
    }

    //This method is use for set adapter for selected pizza
    private void  setListPizzaIngredientAdapter(String[] array){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, array);
        lst_pizza_ingredient.setAdapter(adapter);
    }
}