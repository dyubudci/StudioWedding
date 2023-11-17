package com.example.studiowedding.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.studiowedding.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServicesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        // Dữ liệu giả
        List<ProductModel> productList = new ArrayList<>();
        productList.add(new ProductModel("Váy cưới 1", "9999999"));
        productList.add(new ProductModel("Váy cưới 2", "999999" ));
        productList.add(new ProductModel("Váy cưới 3", "999999" ));
        productList.add(new ProductModel("Váy cưới 4", "999999"));
        productList.add(new ProductModel("Váy cưới 5", "999999" ));
        productList.add(new ProductModel("Váy cưới 6", "999999"));
        productList.add(new ProductModel("Váy cưới 7", "999999" ));
        productList.add(new ProductModel("Váy cưới 8", "999999" ));

        // Tạo adapter tùy chỉnh
        ProductAdapter adapter = new ProductAdapter(requireContext(), R.layout.item_product, productList);

        // Đặt adapter cho ListView
        ListView listView = view.findViewById(R.id.lvdichvu);
        listView.setAdapter(adapter);

        return view;
    }
}