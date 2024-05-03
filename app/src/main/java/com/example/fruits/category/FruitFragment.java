package com.example.fruits.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruits.R;
import com.example.fruits.adapter.FruitAdapter;
import com.example.fruits.adapter.FruitAdapter2;
import com.example.fruits.model.FruitModel;

import java.util.ArrayList;
import java.util.List;

public class FruitFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);

        // First RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        List<FruitModel> dataList = new ArrayList<>();
        dataList.add(new FruitModel("cherries43", "Cherries", 150.0, "1kg"));
        dataList.add(new FruitModel("figs43", "Figs", 500.0, "1kg"));
        dataList.add(new FruitModel("grapefruits43", "Grapefruits", 300.0, "1kg"));
        dataList.add(new FruitModel("apricots43", "Apricots", 800.0, "1kg"));
        dataList.add(new FruitModel("avocados43", "Avocados", 400.0, "1kg"));
        dataList.add(new FruitModel("peaches43", "Peaches", 180.0, "1kg"));
        dataList.add(new FruitModel("raspberries43", "Raspberries", 750.0, "1kg"));
        dataList.add(new FruitModel("plums43", "Plums", 220.0, "1kg"));
        dataList.add(new FruitModel("strawberries43", "Strawberries", 100.0, "1kg"));
        dataList.add(new FruitModel("blackberries43", "Blackberries", 500.0, "1kg"));
        dataList.add(new FruitModel("blueberries43", "Blueberries", 750.0, "1kg"));
        dataList.add(new FruitModel("apples43", "Apples", 80.0, "1kg"));
        dataList.add(new FruitModel("tomatoes43", "Tomatoes", 30.0, "1kg"));
        dataList.add(new FruitModel("grapes43", "Grapes", 65.0, "1kg"));
        dataList.add(new FruitModel("cranberries43", "Cranberries", 520.0, "1kg"));
        dataList.add(new FruitModel("lemons43", "Lemons", 100.0, "1kg"));
        dataList.add(new FruitModel("guava43", "Guava", 40.0, "1kg"));
        dataList.add(new FruitModel("kiwi43", "Kiwi", 340.0, "1kg"));
        dataList.add(new FruitModel("pineapples43", "Pineapples", 60.0, "1kg"));



        FruitAdapter adapter = new FruitAdapter(dataList, requireContext());
        recyclerView.setAdapter(adapter);

        // Second RecyclerView
        RecyclerView recyclerView2 = view.findViewById(R.id.view2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        List<FruitModel> dataList2 = new ArrayList<>();
        dataList2.add(new FruitModel("peaches43", "Peaches", 180.0, "1kg"));
        dataList2.add(new FruitModel("raspberries43", "Raspberries", 750.0, "1kg"));
        dataList2.add(new FruitModel("plums43", "Plums", 220.0, "1kg"));
        dataList2.add(new FruitModel("strawberries43", "Strawberries", 100.0, "1kg"));
        dataList2.add(new FruitModel("blackberries43", "Blackberries", 500.0, "1kg"));
        dataList2.add(new FruitModel("blueberries43", "Blueberries", 750.0, "1kg"));
        dataList2.add(new FruitModel("apples43", "Apples", 80.0, "1kg"));
        dataList2.add(new FruitModel("kiwi43", "Kiwi", 340.0, "1kg"));
        dataList2.add(new FruitModel("pineapples43", "Pineapples", 60.0, "1kg"));
        dataList2.add(new FruitModel("pomegranates43", "Pomegranates", 90.0, "1kg"));
        dataList2.add(new FruitModel("grapes43", "Grapes", 65.0, "1kg"));
        dataList2.add(new FruitModel("cranberries43", "Cranberries", 520.0, "1kg"));
        dataList2.add(new FruitModel("lemons43", "Lemons", 100.0, "1kg"));
        dataList2.add(new FruitModel("guava43", "Guava", 40.0, "1kg"));

        FruitAdapter adapter2 = new FruitAdapter(dataList2, requireContext());
        recyclerView2.setAdapter(adapter2);

        return view;
    }
}
