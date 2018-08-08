package com.hfad.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

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
        ImageView alcoholImage = findViewById(R.id.alcohol_view);
        ImageView coldImage = findViewById(R.id.cold_or_hot);
        LinearLayout ingredients = findViewById(R.id.ingredients);

        drinkImage.setImageResource(selectedDrink.getImageResourceId());
        drinkImage.setContentDescription(selectedDrink.toString());
        drinkName.setText(selectedDrink.getName());
        drinkDescription.setText(selectedDrink.getDescription());

        if (selectedDrink.HasAlcohol()){
            alcoholImage.setImageResource(R.drawable.pint_of_beer);
            alcoholImage.setContentDescription("Alcohol drink");
        }else{
            alcoholImage.setImageResource(R.drawable.soft_drink);
            alcoholImage.setContentDescription("Drink without alcohol");
        }

        if (selectedDrink.isHot()){
            coldImage.setImageResource(R.drawable.drink);
            coldImage.setContentDescription("Hot drink");
        }else{
            coldImage.setImageResource(R.drawable.tea_cup);
            coldImage.setContentDescription("Cold drink");
        }

        ArrayList<String> adds = selectedDrink.getSupplements();
        for(int i = 0; i < adds.size(); i++){
            ImageView imageView = new ImageView(this);
            int factor = (int)imageView.getContext().getResources().getDisplayMetrics().density;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50*factor, 50*factor);
            params.setMargins(0, 0, 10 * factor, 0);
            imageView.setLayoutParams(params);
            imageView.setImageResource(getAddsImageResource(adds.get(i)));
            imageView.setContentDescription(adds.get(i));
            ingredients.addView(imageView);
        }
    }
    private int getAddsImageResource(String nameOfAdd){
        switch(nameOfAdd){
            case "Ice Cream":
                return R.drawable.ic_ice_cream;
            case "Milk":
                return R.drawable.milk_box;
            case "Sugar":
                return R.drawable.sugar;
            case "Chocolate":
                return R.drawable.chocolate;
            default:
                throw new IllegalArgumentException("Wrong name of ingredient" + nameOfAdd);
        }
    }
}
