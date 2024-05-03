package com.example.fruits;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UPIPaymentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UPIPaymentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Spinner cardTypeSpinner;

    public UPIPaymentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UPIPaymentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UPIPaymentFragment newInstance(String param1, String param2) {
        UPIPaymentFragment fragment = new UPIPaymentFragment();
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
        View view = inflater.inflate(R.layout.fragment_upi_payment, container, false);
        // Inflate the layout for this fragment
        cardTypeSpinner = view.findViewById(R.id.inputupitype);
        // Populate card type spinner
        List<String> cardTypes = new ArrayList<>();
        cardTypes.add("Google pay");
        cardTypes.add("Paytm");
        cardTypes.add("Phonepay");
        cardTypes.add("Amazon pay");

        ArrayAdapter<String> cardTypeAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, cardTypes);
        cardTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cardTypeSpinner.setAdapter(cardTypeAdapter);
        Button b1 = view.findViewById(R.id.paynow);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new PaymentSuccess());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}