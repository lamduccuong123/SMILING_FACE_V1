package com.example.onthicuoiky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SachAdapter extends BaseAdapter {

    private MainActivity context;
    private int layout;
    private List<Sach> sachList;

    public SachAdapter(MainActivity context, int layout, List<Sach> sachList) {
        this.context = context;
        this.layout = layout;
        this.sachList = sachList;
    }

    @Override
    public int getCount() {
        return sachList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView txtTen;
        ImageButton btnSua, btnXoa;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.txtTen = view.findViewById(R.id.txtTenSach);
            holder.btnSua = view.findViewById(R.id.btnEdit);
            holder.btnXoa = view.findViewById(R.id.btnDelete);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Sach sach = sachList.get(i);
        holder.txtTen.setText(sach.getTenSach());
        holder.btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Sửa", Toast.LENGTH_SHORT).show();
                context.DialogUpdate(sach.getTenSach(), sach.getId());

            }
        });

        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Xóa", Toast.LENGTH_SHORT).show();
                context.DialogDelete(sach.getTenSach(), sach.getId());

            }
        });
        return view;
    }
}
