package com.example.list_giay;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class chiTiet extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet);

        TextView txtName = findViewById(R.id.txtName);
        TextView txtMoTa = findViewById(R.id.txtMoTa);
        TextView txtChiTiet = findViewById(R.id.txtChiTiet);
        TextView txtGia = findViewById(R.id.txtGia);

        ImageView imgHinh = findViewById(R.id.imgGiayChiTiet);


        String name = getIntent().getExtras().getString("name");
        List<Giay> giays = new ArrayList<Giay>();
        giays.add(new Giay("Nike shoes-discount 50%", R.drawable.shoes_rm_preview_b, "adidas Women's Stan Smith Low Top Fashion Sneakers Shoes", "Sole: Rubber\n" +
                "Closure: Lace-Up\n" +
                "Shoe Width: Medium\n" +
                "Lace Up\n" +
                "Grip Rubber Sole\n" +
                "Padded Insole", "100$"));
        giays.add(new Giay("Adidas shoes-discount 80%", R.drawable.shoes_rm_preview_a, "adidas Women's Stan Smith Low Top Fashion Sneakers Shoes", "Sole: Rubber\n" +
                "Closure: Lace-Up\n" +
                "Shoe Width: Medium\n" +
                "Lace Up\n" +
                "Grip Rubber Sole\n" +
                "Padded Insole", "590$"));
        giays.add(new Giay("Nike Bicycle-discount 30%", R.drawable.shoes_rm_purple, "adidas Women's Stan Smith Low Top Fashion Sneakers Shoes", "Sole: Rubber\n" +
                "Closure: Lace-Up\n" +
                "Shoe Width: Medium\n" +
                "Lace Up\n" +
                "Grip Rubber Sole\n" +
                "Padded Insole", "199$"));
        giays.add(new Giay("Yonex shoes-discount 50%", R.drawable.shoes_rm_preview, "adidas Women's Stan Smith Low Top Fashion Sneakers Shoes", "Sole: Rubber\n" +
                "Closure: Lace-Up\n" +
                "Shoe Width: Medium\n" +
                "Lace Up\n" +
                "Grip Rubber Sole\n" +
                "Padded Insole", "290$"));
        giays.add(new Giay("Victor shoes-discount 50%", R.drawable.shoes_rm_yellow, "adidas Women's Stan Smith Low Top Fashion Sneakers Shoes", "Sole: Rubber\n" +
                "Closure: Lace-Up\n" +
                "Shoe Width: Medium\n" +
                "Lace Up\n" +
                "Grip Rubber Sole\n" +
                "Padded Insole", "150$"));
        giays.add(new Giay("Lining shoes-discount 50%", R.drawable.shoes_white_removebg_preview, "adidas Women's Stan Smith Low Top Fashion Sneakers Shoes", "Sole: Rubber\n" +
                "Closure: Lace-Up\n" +
                "Shoe Width: Medium\n" +
                "Lace Up\n" +
                "Grip Rubber Sole\n" +
                "Padded Insole", "190$"));
        giays.add(new Giay("Binh Minh shoes-discount 90%", R.drawable.color_removebg_preview, "adidas Women's Stan Smith Low Top Fashion Sneakers Shoes", "Sole: Rubber\n" +
                "Closure: Lace-Up\n" +
                "Shoe Width: Medium\n" +
                "Lace Up\n" +
                "Grip Rubber Sole\n" +
                "Padded Insole", "100$"));

        for (Giay giay :
                giays) {
            if (giay.getTenGiay().equals(name)) {
                txtMoTa.setText(giay.getMoTa());
                txtChiTiet.setText(giay.getChiTiet());
                txtGia.setText(giay.getGia());
                imgHinh.setImageResource(giay.getHinh());
                break;
            }
        }
    }

}
