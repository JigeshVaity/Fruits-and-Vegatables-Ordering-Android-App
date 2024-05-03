package com.example.fruits.search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruits.model.FruitModel;
import com.example.fruits.R;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    SearchView s1;
    RecyclerView r1;
    private SearchView searchView;
    private List<FruitModel> itemList;


    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
        View view = inflater.inflate(R.layout.fragment_search, container, false);


        r1 = view.findViewById(R.id.searchrecylerview);
        s1 = view.findViewById(R.id.searchView);
        s1.setIconified(false);
        s1.clearFocus();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
        r1.setLayoutManager(layoutManager);
        SearchAdapter searchAdapter = new SearchAdapter(SearchFragment.this, getRecommendedList());
        //adapter2 = new RecommendedAdapter(getRecommendedList());
        r1.setAdapter(searchAdapter);

        s1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle query submission if needed
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchAdapter.filter(newText);
                return true;
            }
        });

        // Rest of your code...

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ImageView backButton = view.findViewById(R.id.backbutton);

        // Set OnClickListener for the backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous fragment
                requireActivity().onBackPressed();
            }
        });
    }
    private void showKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }



    private ArrayList<FruitModel> getRecommendedList() {
        List<FruitModel> dataList2 = new ArrayList<>();
        dataList2.add(new FruitModel("apricots43", "Apricots", 800.0, "1kg"));
        dataList2.add(new FruitModel("avocados43", "Avocados", 400.0, "1kg"));
        dataList2.add(new FruitModel("beets43", "Beets", 85.0, "1kg"));
        dataList2.add(new FruitModel("broccoli43", "Broccoli", 40.0, "1kg"));
        dataList2.add(new FruitModel("carrots43", "Carrots", 30.0, "1kg"));
        dataList2.add(new FruitModel("cauliflower43", "Cauliflower", 20.0, "1kg"));
        dataList2.add(new FruitModel("cherries43", "Cherries", 150.0, "1kg"));
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
        dataList2.add(new FruitModel("radish43", "Radish", 20.0, "1kg"));
        dataList2.add(new FruitModel("raspberries43", "Raspberries", 750.0, "1kg"));
        dataList2.add(new FruitModel("spinach43", "Spinach", 90.0, "1kg"));
        dataList2.add(new FruitModel("springonions43", "Spring Onions", 50.0, "1kg"));
        dataList2.add(new FruitModel("strawberries43", "Strawberries", 100.0, "1kg"));
        dataList2.add(new FruitModel("tomatoes43", "Tomatoes", 30.0, "1kg"));
        dataList2.add(new FruitModel("apples43", "Apples", 80.0, "1kg"));
        dataList2.add(new FruitModel("blackberries43", "Blackberries", 500.0, "1kg"));
        dataList2.add(new FruitModel("blueberries43", "Blueberries", 750.0, "1kg"));
        dataList2.add(new FruitModel("cabbage43", "Cabbage", 40.0, "1kg"));
        dataList2.add(new FruitModel("grapes43", "Grapes", 65.0, "1kg"));
        dataList2.add(new FruitModel("lemons43", "Lemons", 100.0, "1kg"));
        dataList2.add(new FruitModel("yams43", "Yams", 40.0, "1kg"));
        dataList2.add(new FruitModel("cranberries43", "Cranberries", 520.0, "1kg"));
        dataList2.add(new FruitModel("guava43", "Guava", 40.0, "1kg"));
        dataList2.add(new FruitModel("kiwi43", "Kiwi", 340.0, "1kg"));
        dataList2.add(new FruitModel("pineapples43", "Pineapples", 60.0, "1kg"));
        dataList2.add(new FruitModel("potatoes43", "Potatoes", 30.0, "1kg"));
        dataList2.add(new FruitModel("pomegranates43", "Pomegranates", 90.0, "1kg"));
        dataList2.add(new FruitModel("sweetpotatoes43", "Sweet Potatoes", 40.0, "1kg"));
        dataList2.add(new FruitModel("celery43", "Celery", 110.0, "1kg"));
        dataList2.add(new FruitModel("collards43", "Collards", 90.0, "1kg"));
        dataList2.add(new FruitModel("greenbeans43", "Green Beans", 80.0, "1kg"));
        dataList2.add(new FruitModel("greenonions43", "Green Onions", 60.0, "1kg"));
        dataList2.add(new FruitModel("greenpeas43", "Green Peas", 70.0, "1kg"));
        // Add more recommended items here
        return (ArrayList<FruitModel>) dataList2;
    }

}