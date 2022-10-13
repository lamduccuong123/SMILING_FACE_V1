package com.example.sharepreferences_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DataStorageDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giadien_chinh);

        Button btnWrite = findViewById(R.id.btnWrite);
        Button btnRead = findViewById(R.id.btnRead);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataStorageDemoActivity.this, WrittingFileActivity.class);
                startActivity(intent);
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataStorageDemoActivity.this, ReadingFileActivity.class);
                startActivity(intent);
            }
        });
    }

//    public void runWriteActivity(View view) {
//        Intent intent = new Intent(this, WrittingFileActivity.class);
//        startActivity(intent);
//    }
//
//    public void runReadActivity(View view) {
//        Intent intent = new Intent(this, ReadingFileActivity.class);
//        startActivity(intent);
//    }
}