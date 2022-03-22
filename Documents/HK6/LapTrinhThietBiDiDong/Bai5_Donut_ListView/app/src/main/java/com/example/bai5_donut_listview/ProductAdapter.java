package com.example.bai5_donut_listview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Product> products;
    private ImageButton btnAdd;

    private int positionSelected = -1;

    public ProductAdapter(Context context, int layout,
                          ArrayList<Product> products) {
        this.context = context;
        this.layout = layout;
        this.products = products;
    }



    @Override
    public int getCount() {
        return products.size();
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

        Product product = products.get(i);
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
                Intent intent = new Intent(context, ChiTietSanPham_Activity.class);
                intent.putExtra("name", product.getName().toString());
                context.startActivity(intent);
            }
        });

        final ConstraintLayout layout01 = (ConstraintLayout) view.findViewById(R.id.linear01);
        if(positionSelected == i){
            layout01.setBackgroundColor(Color.YELLOW);
        }
        else layout01.setBackgroundColor(Color.WHITE);
        return view;
    }
}
