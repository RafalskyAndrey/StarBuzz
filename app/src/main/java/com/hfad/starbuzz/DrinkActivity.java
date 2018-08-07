package com.hfad.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends Activity {

    public static final String EXTRA_DRINK = "drink";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        Drink selectedDrink = (Drink) getIntent().getSerializableExtra(EXTRA_DRINK);

        ImageView drinkImage = findViewById(R.id.photo);
        TextView drinkName = findViewById(R.id.name);
        TextView drinkDescription = findViewById(R.id.description);

        drinkImage.setImageResource(selectedDrink.getImageResourceId());
        drinkImage.setContentDescription(selectedDrink.toString());
        drinkName.setText(selectedDrink.getName());
        drinkDescription.setText(selectedDrink.getDescription());

    }
}
