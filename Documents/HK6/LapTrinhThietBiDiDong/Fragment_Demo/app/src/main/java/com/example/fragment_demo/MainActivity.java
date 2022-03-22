package com.example.fragment_demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnSearch, btnPink, btnFloat, btnDonut;
    private EditText txtSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnThayDoi = findViewById(R.id.btnChange);



        btnThayDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Truyền dữ liệu từ Activity
                FragmentManager fragmentManager = getSupportFragmentManager();
                BlankFragment fragmentA = (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentA);
                fragmentA.txtA.setText("Activity");
            }
        });

    }

}