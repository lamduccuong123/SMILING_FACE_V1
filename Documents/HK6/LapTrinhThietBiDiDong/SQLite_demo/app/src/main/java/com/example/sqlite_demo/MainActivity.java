package com.example.sqlite_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvPeople;
    People_adapter peopleAdapter;
    ArrayList<People> people;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnRemove = findViewById(R.id.btnRemove);
        Button btnCancel = findViewById(R.id.btnCancel);
        EditText edtNhap = findViewById(R.id.edtNhap);
        lvPeople = findViewById(R.id.lv1);
        db = new DatabaseHandler(this);
        rslv();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtNhap.getText().toString().trim();
                if(!name.equals("")){
                    db.addContact(new People(name));
                    edtNhap.setText("");
                    rslv();
                }
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                int id = intent.getExtras().getInt("id");
                String name = intent.getExtras().getString("name");
                People people = new People(id, name);
                db.deleteContact(people);
                rslv();
            }
        });

    }

    private void rslv(){
        people = (ArrayList<People>) db.getAllContacts();
        peopleAdapter = new People_adapter(this, R.layout.mot_dong_activity, people);
        lvPeople.setAdapter(peopleAdapter);
    }
}