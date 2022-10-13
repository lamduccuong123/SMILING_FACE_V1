package com.example.sharepreferences_demo;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WrittingFileActivity extends AppCompatActivity {
    EditText etChuThich;
//    RadioButton rbInternal, rbExternal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luu_file);
        etChuThich = (EditText) findViewById(R.id.edtGhi);
//        rbInternal = (RadioButton) findViewById(R.id.rbInternal);
//        rbExternal = (RadioButton) findViewById(R.id.rbExternal);

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                writeInternal();
                Toast.makeText(WrittingFileActivity.this, "Ghi dữ liệu thành công!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
            }
            }
        });
    }
//    public void writeExternal(View view) {
//        try {
////            if (rbInternal.isChecked()) {
////                writeInternal();
////            } else if (rbExternal.isChecked()) {
////                writeExternal();
////            } else {
//                writeInternal();
////                writeExternal();
////            }
//            Toast.makeText(this, "Ghi dữ liệu thành công!", Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//        }
//    }
    public void writeInternal() {
        try {
            OutputStream os = openFileOutput("chuthich_in.txt", MODE_PRIVATE);
            String string = etChuThich.getText().toString();
            os.write(string.getBytes());
            os.close();
        } catch (Exception e) {
        }
    }
    public void writeExternal() {
        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File f = new File(sdcard,"chuthich_ex.txt");
            OutputStream os = new FileOutputStream(f);
            String string = etChuThich.getText().toString();
            os.write(string.getBytes());
            os.close();
        } catch (Exception e) {
        }
    }
}