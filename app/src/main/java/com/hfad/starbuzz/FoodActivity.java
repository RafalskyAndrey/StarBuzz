package com.hfad.starbuzz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodActivity extends Activity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Food selectedFood = (Food)getIntent().getSerializableExtra(CategoryActivity.EXTRA_PRODUCT);

        ImageView foodImage = findViewById(R.id.food_image);
        ImageView calorieImage = findViewById(R.id.calory_image);
        ImageView typeImage = findViewById(R.id.type_image);

        TextView foodName = findViewById(R.id.food_name);
        TextView foodDescription = findViewById(R.id.description);
        TextView food_calories = findViewById(R.id.calories_info);
        TextView food_type = findViewById(R.id.type_info);

        foodImage.setImageResource(selectedFood.getImageResourceId());
        foodImage.setContentDescription(selectedFood.getName());

        calorieImage.setImageResource(R.drawable.calculator);
        calorieImage.setContentDescription("Calorie image");

        typeImage.setImageResource(R.drawable.pot);
        typeImage.setContentDescription("Type image");

        foodName.setText(selectedFood.getName());
        foodDescription.setText(selectedFood.getDescription());
        food_calories.setText(Integer.toString(selectedFood.getCalories()));
        food_type.setText(selectedFood.getTypeOfCooking());

    }
}
