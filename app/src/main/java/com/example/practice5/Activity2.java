package com.example.practice5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity2 extends AppCompatActivity {
    private String[] arrCategory = {"Фрукты", "Молочные продукты","Мясо","Для дома","Техника"};
    private ListView listCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        listCategory = (ListView) findViewById(R.id.category_list_2);

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrCategory);
        listCategory.setAdapter(categoryAdapter);
        listCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectCategory = arrCategory[position];
                Intent intent = new Intent(Activity2.this, ProductActivity.class);
                intent.putExtra("category", selectCategory);
                startActivity(intent);
            }
        });
    }
}