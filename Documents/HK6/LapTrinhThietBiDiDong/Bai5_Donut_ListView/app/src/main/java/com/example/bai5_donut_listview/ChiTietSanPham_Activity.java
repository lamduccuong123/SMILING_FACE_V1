package com.example.bai5_donut_listview;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChiTietSanPham_Activity extends AppCompatActivity {
    private Context context;
    private int layout;
    private Product product;
    private TextView txtName, txtGia, txtMoTa;
    private ImageView imgChiTiet;
    private Button btnAdd;
    ChiTietSanPham_Adapter chiTietSanPham_adapter;
    ArrayList<Product> products;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsanpham);

        products = new ArrayList<Product>();

        products.add(new Product("Tasty Donut","Spicy tasty donut family","$10.00",R.drawable.tasty_donut_1));
        products.add(new Product("Pink Donut","Spicy tasty donut family","$20.00",R.drawable.pink_donut_1));
        products.add(new Product("Floating Donut","Spicy tasty donut family","$30.00",R.drawable.green_donut_1));
        products.add(new Product("Tasty Donut","Spicy tasty donut family","$40.00",R.drawable.donut_red_1));
        product = new Product("Tasty Donut","Spicy tasty donut family","$40.00",R.drawable.donut_red_1);

        txtName = findViewById(R.id.txtNameChiTiet);
        txtMoTa = findViewById(R.id.txtShop);
        txtGia = findViewById(R.id.txtGiaChiTiet);
        btnAdd = findViewById(R.id.btnAdd2);
        imgChiTiet = findViewById(R.id.imageView);
        GetInformation();
        }

    private void GetInformation() {
        String name = getIntent().getExtras().getString("name");


        for (Product p:
             products){
            if (p.getName().equals(name)) {
                txtName.setText(p.getName());
                txtMoTa.setText(p.getMoTa());
                txtGia.setText(p.getGia());
                imgChiTiet.setImageResource(p.getPicture());
                chiTietSanPham_adapter = new ChiTietSanPham_Adapter(ChiTietSanPham_Activity.this, R.layout.activity_chitietsanpham, p);
                break;
            }
        }
    }


}
