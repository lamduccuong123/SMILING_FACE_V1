package com.example.a19474711_lamduccuong_thongkenhapxuat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    Database database;
    ListView listView;
    ArrayList<Product> productArrayList;
    ProductAdapter productAdapter;
    ImageButton btnThem, btnSave, btnSynchronize, btnThongKe;
    FirebaseFirestore db;
    RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        productArrayList = new ArrayList<>();
        productAdapter = new ProductAdapter(this, R.layout.dong_product, productArrayList);
        listView.setAdapter(productAdapter);
        db = FirebaseFirestore.getInstance();

        //Tạo database
        this.database = new Database(this, "Sach.sqlite", null, 1);

        //Tạo bảng
        this.database.QueryData("CREATE TABLE IF NOT EXISTS Product(Id INTEGER PRIMARY KEY AUTOINCREMENT, nhapXuat VARCHAR(200), soLuong VARCHAR(200), tenHangHoa VARCHAR(200), ngay String)");


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                luuLenFirebase();
            }
        });

        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThongKe.class);
                startActivity(intent);
            }
        });

        btnSynchronize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showData();
                actionGetData();
            }
        });

//        actionGetData();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogThem();
            }
        });
    }



    public void DialogThem() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_them);

        RadioButton rdoNhap =  dialog.findViewById(R.id.rdoNhap);
        RadioButton rdoXuat =  dialog.findViewById(R.id.rdoXuat);
        EditText edtSoLuong = dialog.findViewById(R.id.edtSoLuong);
        EditText edtTen = (EditText) dialog.findViewById(R.id.edtTen_Them);
        EditText edtNgay = (EditText) dialog.findViewById(R.id.edtNgay);

        Button btnThem = dialog.findViewById(R.id.btnThem_Them);
        Button btnHuy = dialog.findViewById(R.id.btnHuy2);


        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Boolean nhapXuat = rdoNhap.get
                String nhapXuat = "nhap";
                String soLuong = edtSoLuong.getText().toString().trim();
                String ten = edtTen.getText().toString().trim();
                String ngay = new Date().toString();
                if (TextUtils.isEmpty(ten)) {
                    Toast.makeText(MainActivity.this, "Nhập tên hàng hóa", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    return;
                }
                database.QueryData("INSERT INTO Product VALUES (null, '" + nhapXuat + "','" + soLuong + "', '" + ten + "''" + ngay + "',)");
                dialog.dismiss();
                taoFirestore(nhapXuat, soLuong, ten, ngay);
                showData();
            }
        });
        dialog.show();
    }

    private void taoFirestore(String nhapXuat, String soLuong, String ten, String ngay) {
        String id = UUID.randomUUID().toString();
        Map<String, Object> doc = new HashMap<>();
        doc.put("Id", id);
        doc.put("nhapXuat", nhapXuat);
        doc.put("soLuong", soLuong);
        doc.put("tenHangHoa", ten);
        doc.put("ngay", ngay);
        db.collection("documents").document(id).set(doc).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(MainActivity.this, "Add successed", Toast.LENGTH_SHORT).show();
//                edtThem.setText("");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showData() {
        productArrayList.clear();
        db.collection("documents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot doc : task.getResult()) {
                            Product product = new Product(doc.getString("Id"), doc.getBoolean("nhapXuat"), doc.getString("soLuong"), doc.getString("tenHangHoa"), doc.getDate("ngay"));
                            productArrayList.add(product);
                        }
                        productAdapter = new ProductAdapter(MainActivity.this, R.layout.dong_product, productArrayList);
//                        sachAdapter.notifyDataSetChanged();
                        listView.setAdapter(productAdapter);
                        Toast.makeText(MainActivity.this, "Succeed", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
//                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void anhXa() {


        listView = findViewById(R.id.lvSach);
        btnThem = findViewById(R.id.btnThem);
        btnSave = findViewById(R.id.btnSave);
        btnSynchronize = findViewById(R.id.btnSynchronize);
        btnThongKe = findViewById(R.id.btnThongKe);
    }

    private void actionGetData() {
        productArrayList.clear();
        db.collection("documents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot doc : task.getResult()) {
                            Product product = new Product(doc.getString("Id"), doc.getBoolean("nhapXuat"), doc.getString("soLuong"), doc.getString("tenHangHoa"), doc.getDate("ngay"));
                            productArrayList.add(product);
                            String nhapXuat = "nhap";
                            String soLuong = doc.getString("soLuong");
                            String ten = doc.getString("tenHangHoa");
                            String ngay = new Date().toString();
                            database.QueryData("INSERT INTO Product VALUES (null, '" + nhapXuat + "','" + soLuong + "', '" + ten + "''" + ngay + "',)");

                        }
                        productAdapter = new ProductAdapter(MainActivity.this, R.layout.dong_product, productArrayList);
//                        sachAdapter.notifyDataSetChanged();
                        listView.setAdapter(productAdapter);
                        Toast.makeText(MainActivity.this, "Succeed", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
//                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void luuLenFirebase() {
        Cursor data = database.GetData("SELECT * from Product");
        productArrayList.clear();
        while (data.moveToNext()) {

            String id = data.getString(0);
            String nhapXuat = data.getString(1);
            Boolean nhapXuat2;
            if (nhapXuat.equals("nhap")){
                nhapXuat2 = true;
            }else{
                nhapXuat2 = false;
            }
            String soLuong = data.getString(2);
            String ten = data.getString(3);
            String ngay = data.getString(4);
            productArrayList.add(new Product(id, nhapXuat2, soLuong, ten, new Date()));
            taoFirestore(nhapXuat, soLuong, ten, new Date().toString());
        }
        productAdapter.notifyDataSetChanged();
        showData();
    }
}
