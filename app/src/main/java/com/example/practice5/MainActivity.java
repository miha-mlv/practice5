package com.example.practice5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private List<DataModel> dataList;
    private Button scroll, spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();
        dataList.add(new DataModel(R.drawable.ananas, "Fruits"));
        dataList.add(new DataModel(R.drawable.meet, "Meat"));
        dataList.add(new DataModel(R.drawable.milk, "Dairy products"));
        dataList.add(new DataModel(R.drawable.ananas, "Fruits"));
        dataList.add(new DataModel(R.drawable.meet, "Meat"));
        dataList.add(new DataModel(R.drawable.milk, "Dairy products"));
        dataList.add(new DataModel(R.drawable.ananas, "Fruits"));
        dataList.add(new DataModel(R.drawable.meet, "Meat"));
        dataList.add(new DataModel(R.drawable.milk, "Dairy products"));
        dataList.add(new DataModel(R.drawable.ananas, "Fruits"));
        dataList.add(new DataModel(R.drawable.meet, "Meat"));
        dataList.add(new DataModel(R.drawable.milk, "Dairy products"));
        dataList.add(new DataModel(R.drawable.ananas, "Fruits"));
        dataList.add(new DataModel(R.drawable.meet, "Meat"));
        dataList.add(new DataModel(R.drawable.milk, "Dairy products"));
        dataList.add(new DataModel(R.drawable.ananas, "Fruits"));
        dataList.add(new DataModel(R.drawable.meet, "Meat"));
        dataList.add(new DataModel(R.drawable.milk, "Dairy products"));

        adapter = new DataAdapter(dataList, this);
        recyclerView.setAdapter(adapter);
        scroll = findViewById(R.id.scroll);
        spinner = findViewById(R.id.spinner);
        scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollActivity.class);
                startActivity(intent);
            }
        });
        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });
    }
}