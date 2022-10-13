package com.example.onthithuchanh_fisebase;

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
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PictureAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Picture> pictures;
    private ImageButton btnAdd;

    private int positionSelected = -1;

    public PictureAdapter(Context context, int layout,
                          ArrayList<Picture> pictures) {
        this.context = context;
        this.layout = layout;
        this.pictures = pictures;
    }


    @Override
    public int getCount() {
        return pictures.size();
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
        ImageView imageHinh;
//        Text
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview = view;
        ViewHolder holder = new ViewHolder();
        if (rowview == null) {
            rowview = inflater.inflate(layout, null);
//            holder.txtTen   =(TextView) rowview.findviewById(R.id.textViewTen);
            holder.imageHinh = (ImageView) rowview.findViewById(R.id.imgHinh);
            rowview.setTag(holder);
        } else {
            holder = (ViewHolder) rowview.getTag();
        }


//        holder.txtTen.setText (arrayHinh.get(i).TenHinh);

//        view = inflater.inflate(layout, null);
//        ImageView imgPicture = (ImageView) view.findViewById(R.id.imgHinh);

//        Picture picture = pictures.get(i);
//        imgPicture.setImageResource(picture.getPicture());
//        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(holder.imageHinh);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "" + pictures.getTen(), Toast.LENGTH_SHORT).show();
//                positionSelected = i;
//                notifyDataSetChanged();
//                Intent intent = new Intent(context, ChiTietSanPham_Activity.class);
//                intent.putExtra("name", product.getName().toString());
//                context.startActivity(intent);
//            }
//        });

        final ConstraintLayout layout01 = (ConstraintLayout) view.findViewById(R.id.linear01);
        if (positionSelected == i) {
            layout01.setBackgroundColor(Color.BLUE);
        } else layout01.setBackgroundColor(Color.WHITE);
        return rowview;
    }
}
