package com.example.practice5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ProductActivity extends AppCompatActivity {
    private String category;
    private Products products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent intent = getIntent();
        category = intent.getExtras().getString("category");
        switch(category){
            case "Фрукты":
                products.addItem("Бананы");
                products.addItem("Яблоки");
                products.addItem("Апельсины");
                products.addItem("Виноград");
                products.addItem("Бананы");
                products.addItem("Бананы");
        }

    }
}