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

public class AllFragment extends Fragment {

    private RecyclerView recyclerViewCategoryList, recyclerViewRecommendedList;
    private RecyclerView.Adapter adapter1, adapter2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);

        // First RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        List<FruitModel> dataList = new ArrayList<>();
        dataList.add(new FruitModel("apricots43", "Apricots", 800.0, "1kg"));
        dataList.add(new FruitModel("avocados43", "Avocados", 400.0, "1kg"));
        dataList.add(new FruitModel("beets43", "Beets", 85.0, "1kg"));
        dataList.add(new FruitModel("broccoli43", "Broccoli", 40.0, "1kg"));
        dataList.add(new FruitModel("carrots43", "Carrots", 30.0, "1kg"));
        dataList.add(new FruitModel("cauliflower43", "Cauliflower", 20.0, "1kg"));
        dataList.add(new FruitModel("cherries43", "Cherries", 150.0, "1kg"));
        dataList.add(new FruitModel("corn43", "Corn", 30.0, "1kg"));
        dataList.add(new FruitModel("cucumber43", "Cucumber", 40.0, "1kg"));
        dataList.add(new FruitModel("eggplant43", "Eggplant", 40.0, "1kg"));
        dataList.add(new FruitModel("figs43", "Figs", 500.0, "1kg"));
        dataList.add(new FruitModel("garlic43", "Garlic", 120.0, "1kg"));
        dataList.add(new FruitModel("grapefruits43", "Grapefruits", 300.0, "1kg"));
        dataList.add(new FruitModel("mushrooms43", "Mushrooms", 160.0, "1kg"));
        dataList.add(new FruitModel("lettuce43", "Lettuce", 140.0, "1kg"));
        dataList.add(new FruitModel("peabeans43", "Pea Beans", 60.0, "1kg"));
        dataList.add(new FruitModel("peaches43", "Peaches", 180.0, "1kg"));
        dataList.add(new FruitModel("plums43", "Plums", 220.0, "1kg"));
        dataList.add(new FruitModel("radish43", "Radish", 20.0, "1kg"));
        dataList.add(new FruitModel("raspberries43", "Raspberries", 750.0, "1kg"));
        dataList.add(new FruitModel("spinach43", "Spinach", 90.0, "1kg"));
        dataList.add(new FruitModel("strawberries43", "Strawberries", 100.0, "1kg"));
        dataList.add(new FruitModel("tomatoes43", "Tomatoes", 30.0, "1kg"));
        dataList.add(new FruitModel("apples43", "Apples", 80.0, "1kg"));
        dataList.add(new FruitModel("blackberries43", "Blackberries", 500.0, "1kg"));
        dataList.add(new FruitModel("blueberries43", "Blueberries", 750.0, "1kg"));
        dataList.add(new FruitModel("cabbage43", "Cabbage", 40.0, "1kg"));
        dataList.add(new FruitModel("grapes43", "Grapes", 65.0, "1kg"));
        dataList.add(new FruitModel("lemons43", "Lemons", 100.0, "1kg"));
        dataList.add(new FruitModel("yams43", "Yams", 40.0, "1kg"));
        dataList.add(new FruitModel("cranberries43", "Cranberries", 520.0, "1kg"));
        dataList.add(new FruitModel("guava43", "Guava", 40.0, "1kg"));
        dataList.add(new FruitModel("kiwi43", "Kiwi", 340.0, "1kg"));
        dataList.add(new FruitModel("pineapples43", "Pineapples", 60.0, "1kg"));
        dataList.add(new FruitModel("potatoes43", "Potatoes", 30.0, "1kg"));
        dataList.add(new FruitModel("celery43", "Celery", 110.0, "1kg"));
        dataList.add(new FruitModel("collards43", "Collards", 90.0, "1kg"));
        dataList.add(new FruitModel("greenbeans43", "Green Beans", 80.0, "1kg"));
        dataList.add(new FruitModel("greenonions43", "Green Onions", 60.0, "1kg"));
        dataList.add(new FruitModel("greenpeas43", "Green Peas", 70.0, "1kg"));


        FruitAdapter adapter = new FruitAdapter(dataList, requireContext());
        recyclerView.setAdapter(adapter);

        // Second RecyclerView
        RecyclerView recyclerView2 = view.findViewById(R.id.view2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        List<FruitModel> dataList2 = new ArrayList<>();


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
        dataList2.add(new FruitModel("radish43", "Radish", 20.0, "1kg"));
        dataList2.add(new FruitModel("raspberries43", "Raspberries", 750.0, "1kg"));
        dataList2.add(new FruitModel("spinach43", "Spinach", 90.0, "1kg"));
        dataList2.add(new FruitModel("tomatoes43", "Tomatoes", 30.0, "1kg"));
        dataList2.add(new FruitModel("apples43", "Apples", 80.0, "1kg"));
        dataList2.add(new FruitModel("blackberries43", "Blackberries", 500.0, "1kg"));
        dataList2.add(new FruitModel("cabbage43", "Cabbage", 40.0, "1kg"));
        dataList2.add(new FruitModel("grapes43", "Grapes", 65.0, "1kg"));
        dataList2.add(new FruitModel("lemons43", "Lemons", 100.0, "1kg"));
        dataList2.add(new FruitModel("yams43", "Yams", 40.0, "1kg"));
        dataList2.add(new FruitModel("cranberries43", "Cranberries", 520.0, "1kg"));
        dataList2.add(new FruitModel("guava43", "Guava", 40.0, "1kg"));
        dataList2.add(new FruitModel("kiwi43", "Kiwi", 340.0, "1kg"));
        dataList2.add(new FruitModel("pineapples43", "Pineapples", 60.0, "1kg"));
        dataList2.add(new FruitModel("potatoes43", "Potatoes", 30.0, "1kg"));
        dataList2.add(new FruitModel("celery43", "Celery", 110.0, "1kg"));
        dataList2.add(new FruitModel("collards43", "Collards", 90.0, "1kg"));
        dataList2.add(new FruitModel("greenbeans43", "Green Beans", 80.0, "1kg"));


        FruitAdapter adapter2 = new FruitAdapter(dataList2, requireContext());
        recyclerView2.setAdapter(adapter2);

        return view;
    }
}
