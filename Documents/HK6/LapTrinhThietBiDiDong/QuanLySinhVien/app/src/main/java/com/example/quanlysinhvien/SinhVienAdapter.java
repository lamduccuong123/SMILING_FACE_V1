package com.example.quanlysinhvien;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SinhVien> sinhViens;
    private ImageButton btnXoa, btnCapNhap;
    private int positionSelected = -1;
    public SinhVienAdapter(Context context, int layout,
                          ArrayList<SinhVien> sinhViens) {
        this.context = context;
        this.layout = layout;
        this.sinhViens = sinhViens;
    }

    @Override
    public int getCount() {
        return sinhViens.size();
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
        view = inflater.inflate(layout,null);

        TextView txtName = (TextView) view.findViewById(R.id.txtHoTen);
        TextView txtLop = (TextView) view.findViewById(R.id.txtLop);
        TextView txtTinhTrang = (TextView) view.findViewById(R.id.txtTinhTrang);
        btnXoa = (ImageButton) view.findViewById(R.id.btnCapNhat);

        SinhVien sinhVien = sinhViens.get(i);
        txtName.setText(sinhVien.getHoTen());
        txtLop.setText(sinhVien.getLop());
        txtTinhTrang.setText(sinhVien.getTinhTrang());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + sinhVien.getHoTen(), Toast.LENGTH_SHORT).show();
                positionSelected = i;
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
