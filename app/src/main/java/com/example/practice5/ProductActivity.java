package com.example.practice5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ProductActivity extends AppCompatActivity {
    private String category;
    private Products products = new Products();
    private Button addProduct_btn, removeProduct_btn;
    private EditText select_product;
    ListView listCategoryAdapter;
    private List<Integer> selectProduct = new ArrayList<Integer>();
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
                products.addItem("Мандарины");
                break;
            case "Молочные продукты":
                products.addItem("Молоко");
                products.addItem("Сыр");
                products.addItem("Творог");
                products.addItem("Сметана");
                products.addItem("Ряженка");
                products.addItem("Кефир");
                products.addItem("Сливки");
                products.addItem("Масло");
                products.addItem("Йогурт");
                break;
            case "Мясо":
                products.addItem("Свинина");
                products.addItem("Баранина");
                products.addItem("Курица");
                products.addItem("Сосиски");
                break;
        }
        init();
        ListView listCategory = (ListView) findViewById(R.id.listview_2);
        updateListView();
        listCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray select = listCategory.getCheckedItemPositions();
                for(int i=0; i < products.getCount(); i++)
                {
                    if(select.get(i))
                    {
                        selectProduct.add(i);
                    }
                }
            }
        });
        addProduct_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameProduct = select_product.getText().toString();
                if(nameProduct.equals(""))
                {
                    Toast.makeText(ProductActivity.this,"Введите название товара", Toast.LENGTH_SHORT).show();
                }
                else {
                    products.addItem(nameProduct);
                    updateListView();
                }
            }
        });
        removeProduct_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectProduct.isEmpty())
                {
                    Toast.makeText(ProductActivity.this, "Выберите товар", Toast.LENGTH_SHORT).show();
                }
                for(int i = 0; i < selectProduct.size(); i++)
                {
                    products.remove(selectProduct.get(i));
                }
                updateListView();
                listCategory.clearChoices();
                selectProduct.clear();

            }
        });
    }
    private void updateListView()
    {
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, products.getAllItem());
        listCategoryAdapter.setAdapter(categoryAdapter);
    }
    private void init()
    {
        addProduct_btn = findViewById(R.id.addProduct_btn);
        removeProduct_btn = findViewById(R.id.removeProduct_btn);
        select_product = findViewById(R.id.select_product);
        listCategoryAdapter = (ListView) findViewById(R.id.listview_2);
    }
}