package com.example.list_giay;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GiayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GiayFragment extends Fragment {
    ListView lvGiay;
    GiayAdapter giayAdapter;
    List<Giay> giays;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GiayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GiayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GiayFragment newInstance(String param1, String param2) {
        GiayFragment fragment = new GiayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_giay, container, false);
        lvGiay = view.findViewById(R.id.lvGiay);
        giays = new ArrayList<Giay>();
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

        giayAdapter = new GiayAdapter(view.getContext(), R.layout.mot_dong, giays);
        lvGiay.setAdapter(giayAdapter);

        return view;
    }
}