package com.example.donut;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class ChiTietSanPham_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private Product product;
    private ImageButton btnAdd;
    private int positionSelected = -1;

    public ChiTietSanPham_Adapter(Context context, int layout,
                                  Product product) {
        this.context = context;
        this.layout = layout;
        this.product = product;
    }



    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        TextView txtMoTa = (TextView) view.findViewById(R.id.txtMoTa);
        TextView txtGia = (TextView) view.findViewById(R.id.txtGia);
        btnAdd = (ImageButton) view.findViewById(R.id.btnAdd);
        ImageView imgPicture = (ImageView) view.findViewById(R.id.imgHinh);


//        com.example.donut.Product p = product.get(i);
        txtName.setText(product.getName());
        txtMoTa.setText(product.getMoTa());
        txtGia.setText(product.getGia());
        imgPicture.setImageResource(product.getPicture());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + product.getName(), Toast.LENGTH_SHORT).show();
                positionSelected = i;
                notifyDataSetChanged();

            }
        });
        return view;
    }

    }
