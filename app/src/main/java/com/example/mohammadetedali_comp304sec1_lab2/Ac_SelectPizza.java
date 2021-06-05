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
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ac_SelectPizza extends AppCompatActivity {

    TextView txv_pizza_name;
    ImageView img_pizza_name, img_slice_pizza;
    ListView lst_pizza_ingredient;
    CheckBox chb_AddToCart;

    // Below arrays use for showing the pizza ingredients I create hard copy for each type of pizza
    String[] canadian_ingredients = new String[]{"Pizza Crust",
            "Pizza Sauce", "Mozzarella Cheese", "Canadian Bacon", "Mushrooms", "Bell Pepper"};
    String[] chiken_caesar_ingredients = new String[]{"Pizza Crust",
            "Chicken Breasts", "Monterey Jack cheese", "Minced garlic", "Parmesan cheese", "Green onions"};
    String[] hawaiian_pizza_ingredients = new String[]{"Pizza Sauce",
            "Mozzarella cheese", "Cooked ham ", "Pineapple chunks", "Bacon", "Crumbled"};
    String[] smoky_maple_pizza_ingredients = new String[]{"Smoky maple bacon",
            "Featuring Alfredo sauce", "Maple bacon strips", "Bacon crumble", "Sliced mushrooms", "Shredded cheddar"};
    String[] vaggie_lover_pizza_ingredients = new String[]{"Pizza Dough",
            "Organicville Pizza Sauce", "Chopped Red Pepper", "Chopped Green Pepper", "Fresh Spinach", "Fresh White Mushrooms",
            "Mozzarella Cheese", "Parmesan Cheese", "Basil Flakes"};

    //This list user when user select a pizza and added to the card one item add to this list
    ArrayList<Pizza> pizzas = new ArrayList<>();

    //this variable shows the current pizza
    Pizza pizza;

    //These variable I use for the Cart item on the navbar when the user add a item to it shows the number of item in cart
    private Menu mToolbarMenu;
    private static int itemsInCart = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_select_pizza);

        txv_pizza_name = findViewById(R.id.txv_pizza_name);
        img_pizza_name = findViewById(R.id.pizza_image);
        lst_pizza_ingredient = findViewById(R.id.pizza_ingredients);
        img_slice_pizza = findViewById(R.id.img_slice_pizza);
        chb_AddToCart = findViewById(R.id.chb_AddToCart);
    }

    //This event related to the shows menu in activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.pizza_menu, menu);
        return true;
    }

    //when a user clicked on the menu item this event is raise
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        pizza = new Pizza();
        switch (item.getItemId()) {
            case R.id.canadian_pizza:
                //set pizza name
                setPizza(getString(R.string.canadian_pizza));
                //set proper image for selected pizza
                img_pizza_name.setBackgroundResource(R.drawable.canadian_pizza);
                //shows the pizza ingredient in the list
                setListPizzaIngredientAdapter(canadian_ingredients);
                //visible the controls in the activity
                setVisibleControl();
                //set price and name for pizza
                pizza.setPrice(9);
                pizza.setName(getString(R.string.canadian_pizza));
                return true;
            case R.id.chiken_caesar:
                setPizza(getString(R.string.chiken_caesar));
                img_pizza_name.setBackgroundResource(R.drawable.chiken_caesar);
                //shows the pizza ingredient in the list
                setListPizzaIngredientAdapter(chiken_caesar_ingredients);
                setVisibleControl();
                //set price and name for pizza
                pizza.setPrice(8);
                pizza.setName(getString(R.string.chiken_caesar));
                return true;
            case R.id.hawaiian_pizza:
                setPizza(getString(R.string.hawaiian_pizza));
                img_pizza_name.setBackgroundResource(R.drawable.hawaiian);
                //shows the pizza ingredient in the list
                setListPizzaIngredientAdapter(hawaiian_pizza_ingredients);
                setVisibleControl();
                //set price and name for pizza
                pizza.setPrice(10);
                pizza.setName(getString(R.string.hawaiian_pizza));
                return true;
            case R.id.smoky_maple_pizza:
                setPizza(getString(R.string.smokey_maple_bacon));
                img_pizza_name.setBackgroundResource(R.drawable.smoky_maple);
                //shows the pizza ingredient in the list
                setListPizzaIngredientAdapter(smoky_maple_pizza_ingredients);
                setVisibleControl();
                //set price and name for pizza
                pizza.setPrice(8);
                pizza.setName(getString(R.string.smokey_maple_bacon));
                return true;
            case R.id.vaggie_lover_pizza:
                setPizza(getString(R.string.veggie_lover_s));
                img_pizza_name.setBackgroundResource(R.drawable.vaggie);
                //shows the pizza ingredient in the list
                setListPizzaIngredientAdapter(vaggie_lover_pizza_ingredients);
                setVisibleControl();
                //set price and name for pizza
                pizza.setPrice(11);
                pizza.setName(getString(R.string.veggie_lover_s));
                return true;
            case R.id.cart:
                //Check the user whether select a pizza or not
                if (pizzas.size() == 0) {
                    Toast.makeText(getBaseContext(), "Select a pizza from the menu", Toast.LENGTH_LONG).show();
                    return true;
                }
                //Call the next page and pass a pizza list to the page
                Intent intent = new Intent(this, Ac_OrderDetail.class);
                Bundle bundle = new Bundle();
                // I use parcelable because I want to pass list of entity
                bundle.putParcelableArrayList("pizzalist", pizzas);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //visible the control after call this method
    private void setVisibleControl() {
        img_slice_pizza.setVisibility(View.VISIBLE);
        lst_pizza_ingredient.setVisibility(View.VISIBLE);
        chb_AddToCart.setVisibility(View.VISIBLE);
        chb_AddToCart.setChecked(false);
    }

    //This method used for set a name in textView for pizza name
    private void setPizza(String name) {
        txv_pizza_name.setText(name);
    }

    //This method is use for set adapter for selected pizza
    private void setListPizzaIngredientAdapter(String[] array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, array);
        lst_pizza_ingredient.setAdapter(adapter);
    }

    //this event raise first time when activity refresh or user click on the menu
    //This use for show the Cart item on the navbar
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mToolbarMenu == null) {
            mToolbarMenu = menu;
            createCartBadge(0);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    //I use this method for showing the cart item number in the navbar
    private void createCartBadge(int paramInt) {
        MenuItem cartItem = this.mToolbarMenu.findItem(R.id.cart);
        LayerDrawable localLayerDrawable = (LayerDrawable) cartItem.getIcon();
        Drawable cartBadgeDrawable = localLayerDrawable
                .findDrawableByLayerId(R.id.ic_badge);
        BadgeDrawable badgeDrawable;
        if ((cartBadgeDrawable != null)
                && ((cartBadgeDrawable instanceof BadgeDrawable))
                && (paramInt < 10)) {
            badgeDrawable = (BadgeDrawable) cartBadgeDrawable;
        } else {
            badgeDrawable = new BadgeDrawable(this);
        }
        badgeDrawable.setCount(paramInt);
        localLayerDrawable.mutate();
        localLayerDrawable.setDrawableByLayerId(R.id.ic_badge, badgeDrawable);
        cartItem.setIcon(localLayerDrawable);
    }

    //this event raise when user click on the Add to Cart checkbox
    //if checked pizza add to cart otherwise the item remove from the cart
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            itemsInCart++;
            createCartBadge(itemsInCart);
            pizzas.add(pizza);
        } else {
            itemsInCart--;
            createCartBadge(itemsInCart);
            pizzas.remove(pizza);
        }
    }
}