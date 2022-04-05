package com.example.sqlite_demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class People_adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<People> peopleList;
    private ImageButton btnAdd;

    private int positionSelected = -1;

    public People_adapter(Context context, int layout,
                          ArrayList<People> people) {
        this.context = context;
        this.layout = layout;
        this.peopleList = people;
    }

    @Override
    public int getCount() {
        return peopleList.size();
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
        TextView txtName = (TextView) view.findViewById(R.id.txtTen);
        People peo = peopleList.get(i);
        txtName.setText(peopleList.get(i).getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                People people = peopleList.get(i);
                Toast.makeText(context, "" + peo.getName(), Toast.LENGTH_SHORT).show();
                positionSelected = i;
                notifyDataSetChanged();

                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("id" , peo.getID());
                intent.putExtra("name", peo.getName());
                context.startActivity(intent);

            }
        });
        return view;
    }
}
