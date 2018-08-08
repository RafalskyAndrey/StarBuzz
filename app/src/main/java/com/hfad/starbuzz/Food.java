package com.hfad.starbuzz;

public class Food extends Product{
    private int calories;
    private String typeOfCooking;

    public Food(String name, String description, int imageResourceId,
                int calories, String typeOfCooking) {
        super(name, description, imageResourceId);
        this.calories = calories;
        this.typeOfCooking = typeOfCooking;
    }

    public int getCalories() {
        return calories;
    }

    public String getTypeOfCooking() {
        return typeOfCooking;
    }
}
