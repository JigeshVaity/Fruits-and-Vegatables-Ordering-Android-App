package com.example.fruits.fruitpage;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import com.example.fruits.category.AllFragment;
import com.example.fruits.category.FruitFragment;
import com.example.fruits.R;
import com.example.fruits.category.VegetablesFragment;
import com.example.fruits.adapter.AdvertisementAdapter;
import com.example.fruits.search.SearchFragment;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewCategoryList, recyclerViewRecommendedList;
    private RecyclerView.Adapter adapter1, adapter2;

    private TextView text1, text2, text3;
    private FrameLayout frameOne;
    //advertisement
    private ViewPager viewPager;

    private int currentPage = 0;
    private Timer timer;
    final long delay = 5000;
    //
    ImageView searchImageView;


    //int[] imgList = new int[]{R.drawable.fish1,R.drawable.fish1,R.drawable.fooddish1,R.drawable.brfood,R.drawable.fooddish1};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        //adv
        viewPager = view.findViewById(R.id.adv);
        AdvertisementAdapter viewPagerAdapter = new AdvertisementAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);

        // Set up a timer to auto-scroll the ViewPager
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == viewPagerAdapter.getCount()) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, delay, delay);
        //

        text1 = view.findViewById(R.id.text1);
        text2 = view.findViewById(R.id.text2);
        text3 = view.findViewById(R.id.text3);
        frameOne =view.findViewById(R.id.frame_one);
        text1.setBackgroundResource(R.drawable.btnbox);
        //text1.setTextColor(getResources().getColor(R.color.your_selected_text_color));
        // Set initial fragment
        switchFragment(new AllFragment());

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for text1
                setBackgroundColorAndSwitchFragment(text1, new AllFragment());
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for text2
                setBackgroundColorAndSwitchFragment(text2, new FruitFragment());
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for text3
                setBackgroundColorAndSwitchFragment(text3, new VegetablesFragment());
            }
        });
        searchImageView = view.findViewById(R.id.search);

        searchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace "YourFragment" with the fragment you want to switch to
                Fragment newFragment = new SearchFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, newFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        searchImageView = view.findViewById(R.id.search);

        searchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace "YourFragment" with the fragment you want to switch to
                Fragment newFragment = new SearchFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, newFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    private void setBackgroundColorAndSwitchFragment(TextView textView, Fragment fragment) {
        // Reset background color for all TextViews
        text1.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        text2.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        text3.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        // Set background color for the clicked TextView
        textView.setBackgroundResource(R.drawable.btnbox);


        // Switch to the desired fragment
        switchFragment(fragment);
    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_one, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
