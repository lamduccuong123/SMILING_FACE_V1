package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnThem;
    private TextView txtAll, txtDangHoc, txtDaRaTruong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThem = findViewById(R.id.btnThem);
        txtAll = findViewById(R.id.txtAll);
        txtDangHoc = findViewById(R.id.txtDangHoc);
        txtDaRaTruong = findViewById(R.id.txtDaRaTruong);


    }
}