package com.hfad.starbuzz;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductsData {
    private static final Product[] drinks = {
            new Drink("Latte", "A couple of espresso shots with steamed milk",
                    R.drawable.latte, false, true, new ArrayList<>(Arrays.asList("Milk", "Sugar"))),
            new Drink("Cappuccino", "Espresso, hot milk, and a steamed milk foam",
                    R.drawable.cappuccino, true, false, new ArrayList<>(Arrays.asList("Sugar", "Chocolate"))),
            new Drink("Filter", "Highest quality beans roasted and brewed fresh",
                    R.drawable.filter, false, true, new ArrayList<>(Arrays.asList("Milk", "Ice Cream")))
    };

    private static final Product[] food = {
            new Food("Pizza", "Incredible pizza with paper", R.drawable.pizza,
                    200, "fried"),
            new Food("Roll", "Rolls, cooked in China", R.drawable.roll,
                    340, "fresh"),
            new Food("Bun", "Great buns with cream", R.drawable.bun,
                    150, "baked")
    };

    public static Product[] getFood() {
        return food;
    }

    public static Product[] getDrinks() {
        return drinks;
    }
}
