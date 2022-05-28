package com.example.a19474711_lamduccuong_thongkenhapxuat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<Product> list_product;

    public ProductAdapter(MainActivity context, int layout, List<Product> list_product) {
        this.context = context;
        this.layout = layout;
        this.list_product = list_product;
    }

    @Override
    public int getCount() {
        return list_product.size();
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
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.txtTen = view.findViewById(R.id.txtTenSach);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Product product = list_product.get(i);
        holder.txtTen.setText(product.getTenHangHoa());

        return view;
    }
}
