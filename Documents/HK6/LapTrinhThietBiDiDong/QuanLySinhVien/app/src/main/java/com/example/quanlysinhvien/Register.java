package com.example.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private ImageButton btnRegister;
    private EditText edtUsername, edtPass, edtPassNhapLai;
    private TextView txtSignIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        btnRegister = findViewById(R.id.btnRegister);
        edtUsername = findViewById(R.id.edtUserNameRegister);
        edtPass = findViewById(R.id.edtPassRegister);
        edtPassNhapLai = findViewById(R.id.edtPass2Register);
        txtSignIn = findViewById(R.id.txtSigninSignup);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, SignIn.class);
                startActivity(intent);
            }
        });

    }

    private void register() {
        String email, pass, pass2;
        email = edtUsername.getText().toString();
        pass = edtPass.getText().toString();
        pass2 = edtPassNhapLai.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui long nhap email", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Vui long nhap password", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(pass2)) {
            Toast.makeText(this, "Vui long nhap lai password", Toast.LENGTH_SHORT).show();
            return;
        } else if (!pass2.equals(pass)) {
            Toast.makeText(this, "Vui long nhap lai password", Toast.LENGTH_SHORT).show();
            return;
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Dang ky that bai", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
