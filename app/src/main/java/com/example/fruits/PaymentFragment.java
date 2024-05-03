package com.example.fruits;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentFragment extends Fragment {

    private RadioButton radioButtonOption1;
    private RadioButton radioButtonOption2;

    private RadioButton radioButtonOption4;
    private TextView submitButton;
    private RadioButton lastSelectedRadioButton;
    private TextView totalPaymentTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        // Initialize UI components
        radioButtonOption1 = view.findViewById(R.id.radioButtonOption1);
        radioButtonOption2 = view.findViewById(R.id.radioButtonOption2);
        radioButtonOption4 = view.findViewById(R.id.radioButtonOption4);
        submitButton = view.findViewById(R.id.submitButton);
        totalPaymentTextView = view.findViewById(R.id.totalpayment);

        getParentFragmentManager().setFragmentResultListener("datafrom", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("totalpayment");
                totalPaymentTextView.setText(data);
            }
        });

        radioButtonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRadioButtonClick(radioButtonOption1);
            }
        });

        radioButtonOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRadioButtonClick(radioButtonOption2);
            }
        });



        radioButtonOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRadioButtonClick(radioButtonOption4);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonOption1.isChecked()) {
                    navigateToCartPaymnetFragment();
                } else if (radioButtonOption2.isChecked()) {
                    navigateToUPIPaymnetFragment();
                } else if (radioButtonOption4.isChecked()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Payment", lastSelectedRadioButton.getText().toString());
                    getParentFragmentManager().setFragmentResult("datafrom2", bundle);

                    PlaceOrderFragment paymentSuccessFragment = new PlaceOrderFragment();
                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, paymentSuccessFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }

    private void handleRadioButtonClick(RadioButton radioButton) {
        if (lastSelectedRadioButton != null) {
            lastSelectedRadioButton.setChecked(false);
        }
        radioButton.setChecked(true);
        lastSelectedRadioButton = radioButton;
    }



/*
    private void loadPaymentSuccessFragment() {
        PlaceOrderFragment paymentSuccessFragment = new PlaceOrderFragment();
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, paymentSuccessFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }*/



    private void navigateToCartPaymnetFragment() {
        // Replace 'YourFragmentContainer' with the ID of the container (e.g., FrameLayout) in your activity's layout
        // Create the instance of the fragment where you want to pass the data
        CartPaymentFragment orderConfirmed = new CartPaymentFragment();
        // Use FragmentTransaction to replace the current fragment with the new one
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, orderConfirmed);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void navigateToUPIPaymnetFragment() {
        // Replace 'YourFragmentContainer' with the ID of the container (e.g., FrameLayout) in your activity's layout
        // Create the instance of the fragment where you want to pass the data
        UPIPaymentFragment orderConfirmed = new UPIPaymentFragment();
        // Use FragmentTransaction to replace the current fragment with the new one
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, orderConfirmed);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
