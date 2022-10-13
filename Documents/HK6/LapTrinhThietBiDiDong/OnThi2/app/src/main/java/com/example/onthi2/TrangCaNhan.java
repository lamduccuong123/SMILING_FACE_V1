package com.example.onthi2;

import android.content.Intent;
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
import com.google.firebase.database.ValueEventListener;

public class TrangCaNhan extends AppCompatActivity {
    private ImageButton btnReturnTrangCaNhan, btnLogoutTrangCaNhan, btnUpdateTrangCaNhan;
    private ImageView btnThemTrangCaNhan, imageView;
    private TextView txtTenTrangCaNhan, txtNgaySinhTrangCaNhan;
    private ListView lvTrangCaNhan;
    private DatabaseReference mDatabase;
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

        mDatabase.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 :
                        snapshot.getChildren()) {
                    if (snapshot1.getValue(User.class).getId() == 1) {
                        txtTenTrangCaNhan.setText(snapshot1.getValue(User.class).getHoTen());
                        txtNgaySinhTrangCaNhan.setText(snapshot1.getValue(User.class).getNgaySinh());
                        break;
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        btnUpdateTrangCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangCaNhan.this, ChinhSua.class);
                startActivity(intent);
            }
        });


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
