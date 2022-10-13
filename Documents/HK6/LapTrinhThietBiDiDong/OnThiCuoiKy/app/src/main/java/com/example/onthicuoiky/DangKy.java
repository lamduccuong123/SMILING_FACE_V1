package com.example.onthicuoiky;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DangKy extends AppCompatActivity {
    private ImageButton btnDangKy;
    private EditText edtEmail, edtPass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_ky);
        anhXa();

        mAuth = FirebaseAuth.getInstance();

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangKy();
            }
        });


    }

    private void dangKy() {
        String email, pass;
        email = edtEmail.getText().toString();
        pass = edtPass.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Hay nhap email", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Hay nhap password", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(DangKy.this, "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DangKy.this, MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(DangKy.this, "Dang ky that bai", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void anhXa() {
        btnDangKy = findViewById(R.id.btnDangKy_dangky);
        edtEmail = findViewById(R.id.edtEmail_dangky);
        edtPass = findViewById(R.id.edtPass_dangky);

    }
}
