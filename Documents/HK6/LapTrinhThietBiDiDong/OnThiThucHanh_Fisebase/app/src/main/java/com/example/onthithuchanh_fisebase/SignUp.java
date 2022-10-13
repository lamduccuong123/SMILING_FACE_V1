package com.example.onthithuchanh_fisebase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    private ImageButton btnReturnSignUp, btnSignUpTrangSignUp;
    private EditText edtUsernameSignUp, edtPasswordSignUp, edtPassword2SignUp, hoTen, ngaySinh;
    private FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = firebaseDatabase.getReference();

        mAuth = FirebaseAuth.getInstance();
        btnReturnSignUp = findViewById(R.id.btnReturnSignUp);
        btnSignUpTrangSignUp = findViewById(R.id.btnSignUpTrangSignUp);
        edtUsernameSignUp = findViewById(R.id.edtUsernameSignUp);
        edtPasswordSignUp = findViewById(R.id.edtPasswordSignUp);
        edtPassword2SignUp = findViewById(R.id.edtPassword2SignUp);
        hoTen = findViewById(R.id.edtHoTen);
        ngaySinh = findViewById(R.id.edtNgaySinh);


        btnSignUpTrangSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        String email, pass, pass2, hoVaTen, ngaySinh2;
        email = edtUsernameSignUp.getText().toString();
        hoVaTen = hoTen.getText().toString();
        ngaySinh2 = ngaySinh.getText().toString();
        pass = edtPasswordSignUp.getText().toString();
        pass2 = edtPassword2SignUp.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui long nhap email", Toast.LENGTH_SHORT).show();
            return;
        }else
        if (TextUtils.isEmpty(hoVaTen)) {
            Toast.makeText(this, "Vui long nhap ho va ten", Toast.LENGTH_SHORT).show();
            return;
        }else
        if (TextUtils.isEmpty(ngaySinh2)) {
            Toast.makeText(this, "Vui long nhap ngay sinh", Toast.LENGTH_SHORT).show();
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
        }else {


            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
//                    String userId = mDatabase.push().getKey();
                        User user = new User(email, hoVaTen, ngaySinh2, R.drawable.anhdaidien);
                        mDatabase.child("users").child(email).setValue(user);

                        Toast.makeText(getApplicationContext(), "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUp.this, TrangChu.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Dang ky that bai", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}