package com.example.onthithuchanh_fisebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TrangChu extends AppCompatActivity {
    private ImageButton btnReturnTrangChu, btnProfileTrangCaNhan, btnSearchTrangChu;
    private EditText edttimkiem;
    private TextView txtAll, txtScenery, txtAnime, txtCubes;
    private ListView lvTrangChu;
    private DatabaseReference mDatabase;
    int REQUEST_CODE_IMAGE = 1;
    PictureAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

//        mDatabase = FirebaseDatabase.getInstance().getReference();
//        mDatabase.child("HoTen").setValue("Lam Duc Cuong", new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
//                if (error == null) {
//                    Toast.makeText(getApplicationContext(), "Luu thanh cong", Toast.LENGTH_SHORT).show();
//
//                } else {
//                    Toast.makeText(getApplicationContext(), "Luu khong thanh cong", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });


//        SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
//        Date date = new Date(2001, 10, 27);
//
//        User user = new User("Lin De Qiang", date);
//        mDatabase.child("User").setValue(user);


//        Map<String, Integer> myMap = new HashMap<String, Integer>();
//        myMap.put("Anh", 2);
//        mDatabase.child("Wallper").setValue(myMap);
//
//        User user1 = new User("Halu", date);
//        mDatabase.child("Hahalulu").push().setValue(user1);


        btnReturnTrangChu = findViewById(R.id.btnReturnTrangChu);
        btnProfileTrangCaNhan = findViewById(R.id.btnProfileTrangCaNhan);
        btnSearchTrangChu = findViewById(R.id.btnSearchTrangChu);
        edttimkiem = findViewById(R.id.edttimkiem);
        txtScenery = findViewById(R.id.txtScenery);
        txtAll = findViewById(R.id.txtAll);
        txtAnime = findViewById(R.id.txtAnime);
        txtCubes = findViewById(R.id.txtCubes);
        lvTrangChu = findViewById(R.id.lvTrangChu);

        btnProfileTrangCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChu.this, TrangCaNhan.class);
                startActivity(intent);
            }
        });


//        adapter = new PictureAdapter(this, R.layout.mot_anh, );
//        lvHinhAnh.setAdapter(adapter);
//
//        LoadData();
//
//        private void LoadData () {
//            mData.child("HinhAnh").addChildEventlistener(new ChildEventListener() {
//                @Override
//                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                    HinhAnh hinhAnh = dataSnapshot.getValue(HinhAnh.class);
//                    mangHinhAnh.add(new HinhAnh(hinhAnh.TenHinh, hinhAnh.LinkHinh));
//                    adapter.notifyDataSetChanged();|
//                    @override
//                    public void onChildChanged (DataSnapshot dataSnapshot, string s){
//                    }
    }
}