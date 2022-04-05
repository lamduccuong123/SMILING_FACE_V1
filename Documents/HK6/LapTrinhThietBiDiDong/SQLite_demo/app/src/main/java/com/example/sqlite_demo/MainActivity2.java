package com.example.sqlite_demo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView lvDiaDiem;
    DiaDiemAdapter diaDiemAdapter;
    ArrayList<DiaDiem> diaDiems;
    DatabaseHandler2 db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnCancel = findViewById(R.id.btnHuy);
        EditText edtNhap = findViewById(R.id.edtDiaDiem);
        ImageButton btnChinhSua = findViewById(R.id.imageChinhSua);
        ImageButton btnDelete = findViewById(R.id.imageXoa);

        lvDiaDiem = findViewById(R.id.lv2);
        db = new DatabaseHandler2(this);
        ArrayList<DiaDiem> diaDiemArrayList = (ArrayList<DiaDiem>) db.getAllContacts();
        rslv();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
//                int id = intent.getExtras().getInt("id");
                String name = edtNhap.getText().toString().trim();
                if (!name.equals("")) {

                    db.addContact(new DiaDiem(name));

                }

                edtNhap.setText("");
                rslv();
            }
        });

//        btnChinhSua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = getIntent();
//                int id = intent.getExtras().getInt("id");
//                String name = intent.getExtras().getString("name");
//                edtNhap.setText(name);
//                rslv();
//                String tenMoi = edtNhap.getText().toString().trim();
//                if(TextUtils.isEmpty(tenMoi)){
//                    Toast.makeText(MainActivity2.this, "Noi Dung Sua Chua Duoc Nhap", Toast.LENGTH_SHORT).show();
//                    dialog.dismiss();
//                }
//                else{
//                    Ten tenUpdate = new Ten(ten.getID(), tenMoi);
//                    db.updateContact(tenUpdate);
//                    dialog.dismiss();
//                    resetLVTen();
//                }
//            }
//        });

//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = getIntent();
//                int id = intent.getExtras().getInt("id");
//                String name = intent.getExtras().getString("name");
//                DiaDiem diaDiem = new DiaDiem(id, name);
//                db.deleteContact(diaDiem);
//                rslv();
//            }
//        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStop();
                edtNhap.setText("");
                rslv();
            }
        });

    }

    private void rslv() {
        diaDiems = (ArrayList<DiaDiem>) db.getAllContacts();
        diaDiemAdapter = new DiaDiemAdapter(this, R.layout.mot_dong_2, diaDiems);
        lvDiaDiem.setAdapter(diaDiemAdapter);
    }
}