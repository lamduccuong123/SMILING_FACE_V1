package com.example.sqlite_demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DiaDiemAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DiaDiem> diaDiems;
    private ImageButton btnChinhSua, btnDelete;
    private EditText edtDiaDiem;
    private DatabaseHandler2 db;

    private int positionSelected = -1;

    public DiaDiemAdapter(Context context, int layout, List<DiaDiem> diaDiems) {
        this.context = context;
        this.layout = layout;
        this.diaDiems = diaDiems;
    }

    @Override
    public int getCount() {
        return diaDiems.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView txtName = (TextView) view.findViewById(R.id.txtDiaDiem);
        DiaDiem dd = diaDiems.get(i);
        txtName.setText(diaDiems.get(i).getTenDiaDiem());
        btnChinhSua = view.findViewById(R.id.imageChinhSua);
        btnDelete = view.findViewById(R.id.imageXoa);
        edtDiaDiem = view.findViewById(R.id.edtDiaDiem);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + dd.getTenDiaDiem(), Toast.LENGTH_SHORT).show();
                positionSelected = i;
                notifyDataSetChanged();
//                Intent intent = new Intent(context, MainActivity2.class);
//                intent.putExtra("id" , dd.getId());
//                intent.putExtra("name", dd.getTenDiaDiem());
//                context.startActivity(intent);
            }
        });

        btnChinhSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = dd.getId();
                String name = dd.getTenDiaDiem();
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("id", dd.getId());
                intent.putExtra("name", dd.getTenDiaDiem());
                context.startActivity(intent);
                edtDiaDiem.setText(name);
                }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = dd.getId();
                String name = dd.getTenDiaDiem();
                DiaDiem diaDiem = new DiaDiem(id, name);
                db.deleteContact(diaDiem);
//                rslv();
            }
        });


        return view;
    }

}
