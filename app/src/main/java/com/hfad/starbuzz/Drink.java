package com.hfad.starbuzz;

import java.util.ArrayList;

public class Drink extends Product{
    private boolean hasAlcohol;
    private boolean isHot;
    private ArrayList<String> supplements;

    public Drink(String name, String description, int imageResourceId, boolean hasAlcohol,
                 boolean isHot, ArrayList<String> supplements) {
        super(name, description, imageResourceId);
        this.hasAlcohol = hasAlcohol;
        this.isHot = isHot;
        this.supplements = supplements;
    }

    public boolean HasAlcohol() {
        return hasAlcohol;
    }

    public boolean isHot() {
        return isHot;
    }

    public ArrayList<String> getSupplements() {
        return supplements;
    }
}
