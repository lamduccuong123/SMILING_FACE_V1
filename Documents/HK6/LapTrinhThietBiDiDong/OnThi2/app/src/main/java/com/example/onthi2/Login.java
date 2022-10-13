package com.example.onthi2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ImageButton btnReturnSignIn, btnSignInSignIn;
    private EditText edtUsernameSignUp, edtPasswordSignUp;
    private TextView txtSignUpSignIn, txtForgotPassSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        btnReturnSignIn = findViewById(R.id.btnReturnSignIn);
        btnSignInSignIn = findViewById(R.id.btnSigninTrangLogin);
        edtUsernameSignUp = findViewById(R.id.edtUsernameSignUp);
        edtPasswordSignUp = findViewById(R.id.edtPasswordSignUp);
        txtSignUpSignIn = findViewById(R.id.txtSignUpSignIn);
        txtForgotPassSignin = findViewById(R.id.txtForgotPassSignin);

        btnSignInSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        txtSignUpSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
        btnReturnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void register() {
    }

    private void login() {
        String email, pass;
        email = edtUsernameSignUp.getText().toString();
        pass = edtPasswordSignUp.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui long nhap email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Vui long nhap password", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
//                    final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users").
//                            child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("role");


                    Toast.makeText(getApplicationContext(), "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, TrangChu.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Dang nhap khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}