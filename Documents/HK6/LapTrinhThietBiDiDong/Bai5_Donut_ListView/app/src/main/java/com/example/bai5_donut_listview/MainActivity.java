package com.example.bai5_donut_listview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvProducts;
    ProductAdapter productAdapter;
    ArrayList<Product> products, searchProduct;
    private Button btnSearch, btnPink, btnFloat, btnDonut;
    private EditText txtSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProducts = (ListView) findViewById(R.id.listViewProduct);
        products = new ArrayList<Product>();

        products.add(new Product("Tasty Donut","Spicy tasty donut family","$10.00",R.drawable.tasty_donut_1));
        products.add(new Product("Pink Donut","Spicy tasty donut family","$20.00",R.drawable.pink_donut_1));
        products.add(new Product("Floating Donut","Spicy tasty donut family","$30.00",R.drawable.green_donut_1));
        products.add(new Product("Tasty Donut","Spicy tasty donut family","$40.00",R.drawable.donut_red_1));

        productAdapter = new ProductAdapter(MainActivity.this, R.layout.mot_dong_banh,products);
        lvProducts.setAdapter(productAdapter);

        btnSearch = findViewById(R.id.btnSearch);
        btnPink = findViewById(R.id.btnPinkDonut);
        btnDonut = findViewById(R.id.btnDonut);
        btnFloat = findViewById(R.id.btnFloating2);
        txtSearch = findViewById(R.id.txtSearch);
        searchProduct = new ArrayList<>();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchProduct.clear();
                for (Product product: products) {
                    String st = txtSearch.getText().toString();
                    if (product.getName().toString().contains(st)){
                        searchProduct.add(product);
                    }
                }
                lvProducts.setAdapter(new ProductAdapter(MainActivity.this, R.layout.mot_dong_banh, searchProduct));
            }
        });
        btnPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchProduct.clear();
                txtSearch.setText("");
                for (Product product: products) {
                    String st = "Pink";

                    if (product.getName().toString().contains(st)){
                        searchProduct.add(product);
                    }
                }
                lvProducts.setAdapter(new ProductAdapter(MainActivity.this, R.layout.mot_dong_banh, searchProduct));
            }
        });
        btnDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchProduct.clear();
                txtSearch.setText("");
                for (Product product: products) {
                    String st = "Donut";
                    if (product.getName().toString().contains(st)){
                        searchProduct.add(product);
                    }
                }
                lvProducts.setAdapter(new ProductAdapter(MainActivity.this, R.layout.mot_dong_banh, searchProduct));
            }
        });
        btnFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchProduct.clear();
                txtSearch.setText("");
                for (Product product: products) {

                    String st = "Float";

                    if (product.getName().toString().contains(st)){
                        searchProduct.add(product);
                    }
                }
                lvProducts.setAdapter(new ProductAdapter(MainActivity.this, R.layout.mot_dong_banh, searchProduct));
            }
        });

    }

}