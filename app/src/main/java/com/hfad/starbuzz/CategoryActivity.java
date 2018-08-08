package com.hfad.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategoryActivity extends Activity {

    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_PRODUCT = "product";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final int productIndex = getIntent().getIntExtra(EXTRA_CATEGORY, 0);
        final Product[] productData = getProductsData(productIndex);

        ArrayAdapter<Product> listAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, productData);
        
        ListView categoryList = findViewById(R.id.category_list);
        categoryList.setAdapter(listAdapter);
        categoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(productData[(int)l], productIndex);
            }
        });
    }

    private void startActivity(Product product, int productIndex){
        Class targetedClass;
        switch(productIndex){
            case 0:
                targetedClass = DrinkActivity.class;
                break;
            case 1:
                targetedClass = FoodActivity.class;
                break;
            default:
                throw new IllegalArgumentException("Wrong product index");
        }

        Intent intent = new Intent(CategoryActivity.this, targetedClass);
        intent.putExtra(EXTRA_PRODUCT, product);
        startActivity(intent);


    }

    private Product[] getProductsData(int productIndex) {
        switch (productIndex){
            case 0:
                return ProductsData.getDrinks();
            case 1:
                return ProductsData.getFood();
            default:
                throw new IllegalArgumentException("This type of product is absent");
        }
    }
}
