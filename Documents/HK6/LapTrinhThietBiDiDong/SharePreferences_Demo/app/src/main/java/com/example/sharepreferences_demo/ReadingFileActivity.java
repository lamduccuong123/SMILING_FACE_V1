package com.example.sharepreferences_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class ReadingFileActivity extends AppCompatActivity {
    TextView tvInternal, tvExternal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doc_file);
        tvInternal = (TextView)findViewById(R.id.txtDoc);
//        tvExternal = (TextView)findViewById(R.id.tvExternal);
        readFromInternal();
    }
    public void load(View view){
        readFromInternal();
//        readFromExternal();
    }
    private void readFromInternal(){
        try {
            InputStream is = openFileInput("chuthich_in.txt");
            int size = is.available();
            byte data[] = new byte[size];
            is.read(data);
            is.close();
            String s = new String(data); //s chứa dữ liệu đọc từ file
            tvInternal.setText(s);
        }catch (Exception ex){
        }
    }
//    private void readFromExternal(){
//        try {
//            File sdcard = Environment.getExternalStorageDirectory();
//            File f = new File(sdcard,"chuthich_ex.txt");
//            BufferedReader br = new BufferedReader(new FileReader(f));
//            String line;
//            //Read text from file
//            StringBuilder content = new StringBuilder();
//            while ((line = br.readLine()) != null) {
//                content.append(line);
//                content.append('\n');
//            }
//            br.close();
//            tvExternal.setText(content);
//        }catch (Exception ex){
//        }
//    }
}
