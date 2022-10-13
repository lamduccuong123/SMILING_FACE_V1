package com.example.onthithuchanh_fisebase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
    private DatabaseReference mDatabase;
    private String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_thong_tin);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();
        btnReturnChinhSua = findViewById(R.id.btnReturnChinhSua);
        btnSignUpTrangChinhSua = findViewById(R.id.btnSignUpTrangChinhSua);
        edtUsernameChinhSua = findViewById(R.id.edtUsernameChinhSua);
        edtPasswordChinhSua = findViewById(R.id.edtPasswordChinhSua);
        edtPassword2ChinhSua = findViewById(R.id.edtPassword2ChinhSua);
        hoTenChinhSua = findViewById(R.id.edtHoTenChinhSua);
        ngaySinhChinhSua = findViewById(R.id.edtNgaySinhChinhSua);


        // get reference to 'users' node
        mDatabase = FirebaseDatabase.getInstance().getReference("users");

        // store app title to 'app_title' node
        FirebaseDatabase.getInstance().getReference("app_title").setValue("Realtime Database");

        // app_title change listener
        FirebaseDatabase.getInstance().getReference("app_title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(TAG, "App title updated");

                String appTitle = dataSnapshot.getValue(String.class);

                // update toolbar title
                getSupportActionBar().setTitle(appTitle);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read app title value.", error.toException());
            }
        });

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
            mDatabase.child(userId).child("name").setValue(hoVaTen);
            mDatabase.child(userId).child("name").setValue(ngaySinh2);
            mDatabase.child(userId).child("name").setValue(pass2);
        }



//        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    String userId = mDatabase.push().getKey();
//                    User user = new User(hoVaTen, ngaySinh2, R.drawable.anhdaidien);
//                    mDatabase.child(userId).setValue(user);
//
//                    Toast.makeText(getApplicationContext(), "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(ChinhSua.this, TrangChu.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Dang ky khong thanh cong", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }
}