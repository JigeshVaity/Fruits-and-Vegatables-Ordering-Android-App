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
 * Use the {@link SeasonalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeasonalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SeasonalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeasonalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SeasonalFragment newInstance(String param1, String param2) {
        SeasonalFragment fragment = new SeasonalFragment();
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
       View view = inflater.inflate(R.layout.fragment_seasonal, container, false);
        // Inflate the layout for this fragment
        RecyclerView recyclerView2 = view.findViewById(R.id.view2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));

        List<FruitModel> dataList2 = new ArrayList<>();
        dataList2.add(new FruitModel("apple2", "Apple", 100.0, "1kg"));
        dataList2.add(new FruitModel("gav", "Guava", 40.0, "1kg"));
        dataList2.add(new FruitModel("or", "Orange", 120.0, "1kg"));
        dataList2.add(new FruitModel("pin", "Pineapple", 70.0, "1kg"));
        dataList2.add(new FruitModel("wat", "Watermelon", 90.0, "1kg"));
        dataList2.add(new FruitModel("banana1", "Bannana", 100.0, "1kg"));

        FruitAdapter2 adapter2 = new FruitAdapter2(dataList2, requireContext());
        recyclerView2.setAdapter(adapter2);
        return view;
    }
}