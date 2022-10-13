package com.example.onthithuchanh_fisebase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PostProcessor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class TrangCaNhan extends AppCompatActivity {
    private ImageButton btnReturnTrangCaNhan, btnLogoutTrangCaNhan, btnUpdateTrangCaNhan;
    private ImageView btnThemTrangCaNhan, imageView;
    private TextView txtTenTrangCaNhan, txtNgaySinhTrangCaNhan;
    private ListView lvTrangCaNhan;
    private DatabaseReference mDatabase;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    int REQUEST_CODE_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_ca_nhan);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        btnReturnTrangCaNhan = findViewById(R.id.btnReturnTrangCaNhan);
        btnLogoutTrangCaNhan = findViewById(R.id.btnLogoutTrangCaNhan);
        btnUpdateTrangCaNhan = findViewById(R.id.btnUpdateTrangCaNhan);
        btnThemTrangCaNhan = findViewById(R.id.btnThemTrangCaNhan);
        txtTenTrangCaNhan = findViewById(R.id.txtTenTrangCaNhan);
        txtNgaySinhTrangCaNhan = findViewById(R.id.txtNgaySinhTrangCaNhan);
        imageView = findViewById(R.id.imgDaiDienTrangCaNhan);
        lvTrangCaNhan = findViewById(R.id.lvTrangCaNhan);

//        Query post = FirebaseDatabase.getInstance()
//                .getReference()
//                .child("Posts")
//                .orderByChild("id")
//                .equalTo("ABCXYZ");

//        post.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Post post = dataSnapshot.getValue(Post.class);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


//        mDatabase.child("User").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                txtTenTrangCaNhan.setText(snapshot.getValue().toString());
////                txtNgaySinhTrangCaNhan.setText(snapshot.getValue().toString());
//            }

//        User user = new User("Lin De Qiang", "27/10/2001", lv);
//        mDatabase.child("User").setValue(user);

        mDatabase.child("User").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                txtTenTrangCaNhan.setText(snapshot.getValue().toString());
                txtNgaySinhTrangCaNhan.setText(snapshot.getValue().toString());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        btnThemTrangCaNhan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, REQUEST_CODE_IMAGE);
//            }
//        });


    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data != null){
//            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//            imageView.setImageBitmap(bitmap);
//
//
//        }
//
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}
