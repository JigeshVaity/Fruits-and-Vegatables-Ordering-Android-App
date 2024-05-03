package com.example.fruits.category;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fruits.R;
import com.example.fruits.adapter.FruitAdapter2;
import com.example.fruits.model.FruitModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SpringFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpringFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SpringFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CitrusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpringFragment newInstance(String param1, String param2) {
        SpringFragment fragment = new SpringFragment();
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
        View view = inflater.inflate(R.layout.fragment_spring, container, false);
        // Inflate the layout for this fragment
        RecyclerView recyclerView2 = view.findViewById(R.id.view2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));

        List<FruitModel> dataList2 = new ArrayList<>();

        dataList2.add(new FruitModel("apricots43", "Apricots", 800.0, "1kg"));
        dataList2.add(new FruitModel("cherries43", "Cherries", 150.0, "1kg"));
        dataList2.add(new FruitModel("avocados43", "Avocados", 400.0, "1kg"));
        dataList2.add(new FruitModel("beets43", "Beets", 85.0, "1kg"));
        dataList2.add(new FruitModel("broccoli43", "Broccoli", 40.0, "1kg"));
        dataList2.add(new FruitModel("carrots43", "Carrots", 30.0, "1kg"));
        dataList2.add(new FruitModel("cauliflower43", "Cauliflower", 20.0, "1kg"));
        dataList2.add(new FruitModel("corn43", "Corn", 30.0, "1kg"));
        dataList2.add(new FruitModel("cucumber43", "Cucumber", 40.0, "1kg"));
        dataList2.add(new FruitModel("eggplant43", "Eggplant", 40.0, "1kg"));
        dataList2.add(new FruitModel("figs43", "Figs", 500.0, "1kg"));
        dataList2.add(new FruitModel("garlic43", "Garlic", 120.0, "1kg"));
        dataList2.add(new FruitModel("grapefruits43", "Grapefruits", 300.0, "1kg"));
        dataList2.add(new FruitModel("mushrooms43", "Mushrooms", 160.0, "1kg"));
        dataList2.add(new FruitModel("lettuce43", "Lettuce", 140.0, "1kg"));
        dataList2.add(new FruitModel("peabeans43", "Pea Beans", 60.0, "1kg"));
        dataList2.add(new FruitModel("peaches43", "Peaches", 180.0, "1kg"));
        dataList2.add(new FruitModel("plums43", "Plums", 220.0, "1kg"));
        dataList2.add(new FruitModel("potatoes43", "Potatoes", 30.0, "1kg"));
        dataList2.add(new FruitModel("radish43", "Radish", 20.0, "1kg"));
        dataList2.add(new FruitModel("raspberries43", "Raspberries", 750.0, "1kg"));
        dataList2.add(new FruitModel("spinach43", "Spinach", 90.0, "1kg"));
        dataList2.add(new FruitModel("springonions43", "Spring Onions", 50.0, "1kg"));
        dataList2.add(new FruitModel("strawberries43", "Strawberries", 100.0, "1kg"));
        dataList2.add(new FruitModel("tomatoes43", "Tomatoes", 30.0, "1kg"));


        FruitAdapter2 adapter2 = new FruitAdapter2(dataList2, requireContext());
        recyclerView2.setAdapter(adapter2);
        return view;
    }
}