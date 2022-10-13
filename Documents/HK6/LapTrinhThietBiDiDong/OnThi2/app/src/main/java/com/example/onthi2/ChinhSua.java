package com.example.onthi2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChinhSua extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageButton btnReturnChinhSua, btnSignUpTrangChinhSua;
    private EditText edtUsernameChinhSua, edtPasswordChinhSua, edtPassword2ChinhSua, hoTenChinhSua, ngaySinhChinhSua;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabase;
//    private String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_thong_tin);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = firebaseDatabase.getReference();

        mAuth = FirebaseAuth.getInstance();
        btnReturnChinhSua = findViewById(R.id.btnReturnChinhSua);
        btnSignUpTrangChinhSua = findViewById(R.id.btnSignUpTrangChinhSua);
        edtUsernameChinhSua = findViewById(R.id.edtUsernameChinhSua);
        edtPasswordChinhSua = findViewById(R.id.edtPasswordChinhSua);
        edtPassword2ChinhSua = findViewById(R.id.edtPassword2ChinhSua);
        hoTenChinhSua = findViewById(R.id.edtHoTenChinhSua);
        ngaySinhChinhSua = findViewById(R.id.edtNgaySinhChinhSua);



        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnSignUpTrangChinhSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        String email, pass, pass2, hoVaTen, ngaySinh2;
        email = edtUsernameChinhSua.getText().toString();
        hoVaTen = hoTenChinhSua.getText().toString();
        ngaySinh2 = ngaySinhChinhSua.getText().toString();
        pass = edtPasswordChinhSua.getText().toString();
        pass2 = edtPassword2ChinhSua.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui long nhap email", Toast.LENGTH_SHORT).show();
            return;
        }else
        if (TextUtils.isEmpty(hoVaTen)) {
            Toast.makeText(this, "Vui long nhap lai password", Toast.LENGTH_SHORT).show();
            return;
        }else
        if (TextUtils.isEmpty(ngaySinh2)) {
            Toast.makeText(this, "Vui long nhap lai password", Toast.LENGTH_SHORT).show();
            return;
        }else
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Vui long nhap password", Toast.LENGTH_SHORT).show();
            return;
        }else
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Vui long nhap lai password", Toast.LENGTH_SHORT).show();
            return;
        }else
        if (!pass2.equals(pass)) {
            Toast.makeText(this, "Vui long nhap lai password", Toast.LENGTH_SHORT).show();
            return;
        }else{
            mDatabase.child("users").child("user1").child("hoTen").setValue(hoVaTen);
            mDatabase.child("users").child("user1").child("ngaySinh").setValue(ngaySinh2);

            Intent intent = new Intent(ChinhSua.this, TrangCaNhan.class);
            startActivity(intent);
        }


    }
}