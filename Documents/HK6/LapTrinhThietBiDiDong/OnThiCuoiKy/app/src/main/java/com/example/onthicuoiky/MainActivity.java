package com.example.onthicuoiky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    KetNoiSQL ketNoiSQL;
    ListView listView;
    ArrayList<Sach> sachArrayList;
    SachAdapter sachAdapter;
    ImageButton btnThem;
//    EditText edtThem;
    FirebaseFirestore db;
    RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        sachArrayList = new ArrayList<>();
        sachAdapter = new SachAdapter(this, R.layout.dong_sach, sachArrayList);
        listView.setAdapter(sachAdapter);
        db = FirebaseFirestore.getInstance();

        //Tạo database
        ketNoiSQL = new KetNoiSQL(this, "Sach.sqlite", null, 1);

        //Tạo bảng
        ketNoiSQL.QueryData("CREATE TABLE IF NOT EXISTS NoiDung(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenNoiDung VARCHAR(200))");


        //Thêm dữ liệu
        //ketNoiSQL.QueryData("INSERT INTO NoiDung VALUES(null, 'Làm bạn với bầu trời')");
        //ketNoiSQL.QueryData("INSERT INTO NoiDung VALUES(null, 'Làm người tốt')");

        //Hiển thị
        showData();
//        actionGetData();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String sach = edtThem.getText().toString().trim();
//                if (TextUtils.isEmpty(sach)) {
//                    Toast.makeText(MainActivity.this, "Nhập tên sách", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                ketNoiSQL.QueryData("INSERT INTO NoiDung VALUES (null, '" + sach + "')");
////                actionGetData();
//                showData();
//                edtThem.setText("");
//                taoFirestore(sach);
                DialogThem();
            }
        });
    }

    public void DialogThem() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_them);

        EditText edtTen = (EditText) dialog.findViewById(R.id.edtTenSach_Them);
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
                String ten = edtTen.getText().toString().trim();
                if (TextUtils.isEmpty(ten)) {
                    Toast.makeText(MainActivity.this, "Nhập tên sách", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    return;
                }
                ketNoiSQL.QueryData("INSERT INTO NoiDung VALUES (null, '" + ten + "')");
                dialog.dismiss();
                taoFirestore(ten);
                showData();
            }
        });
        dialog.show();
    }

    private void taoFirestore(String sach) {
        String id = UUID.randomUUID().toString();
        Map<String, Object> doc = new HashMap<>();
        doc.put("Id", id);
        doc.put("TenNoiDung", sach);
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
        sachArrayList.clear();
        db.collection("documents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot doc : task.getResult()) {
                            Sach sach = new Sach(doc.getString("Id"), doc.getString("TenNoiDung"));
                            sachArrayList.add(sach);
                        }
                        sachAdapter = new SachAdapter(MainActivity.this, R.layout.dong_sach, sachArrayList);
//                        sachAdapter.notifyDataSetChanged();
                        listView.setAdapter(sachAdapter);
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

    public void DialogDelete(String ten, String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có muốn xóa quyển sách: '" + ten + "' này không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ketNoiSQL.QueryData("DELETE FROM NoiDung WHERE Id = '" + id + "'");
//                actionGetData();
                showData();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        db.collection("documents").document(id)
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this, "Delete thanh cong", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();

    }

    public void DialogUpdate(String ten, String id) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sua);

        EditText edtSua = (EditText) dialog.findViewById(R.id.edtTenSach_CapNhat);
        Button btnSua = dialog.findViewById(R.id.btnSua_CapNhat);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);

        edtSua.setText(ten);


        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenMoi = edtSua.getText().toString().trim();
                if (TextUtils.isEmpty(tenMoi)) {
                    Toast.makeText(MainActivity.this, "Nhập tên sách", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    return;
                }
                ketNoiSQL.QueryData("UPDATE NoiDung SET TenNoiDung  = '" + tenMoi + "' WHERE Id= '" + id + "'");
                dialog.dismiss();
//                actionGetData();
                showData();

                db.collection("documents").document(id)
                        .update("TenNoiDung", tenMoi)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(MainActivity.this, "Updating..", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }


        });


        dialog.show();


    }


    private void anhXa() {
        listView = findViewById(R.id.lvSach);
//        edtThem = findViewById(R.id.edtSearch);
        btnThem = findViewById(R.id.btnThem);
    }

    private void actionGetData() {
        Cursor dataSach = ketNoiSQL.GetData("SELECT * from NoiDung");
        sachArrayList.clear();
        while (dataSach.moveToNext()) {
            String ten = dataSach.getString(1);
            String id = dataSach.getString(0);
            //Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();

            sachArrayList.add(new Sach(id, ten));
        }
        sachAdapter.notifyDataSetChanged();
        showData();
    }
}