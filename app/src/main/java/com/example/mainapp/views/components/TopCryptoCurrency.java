package com.example.mainapp.views.components;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainapp.R;
import com.example.mainapp.adapters.TopCryptoCurrencyAdapter;
import com.example.mainapp.views.components.CryptoCurrencies;

import java.util.ArrayList;

public class TopCryptoCurrency extends Fragment {

    private RecyclerView recyclerView;

    public TopCryptoCurrency() {
        // Required empty public constructor
    }

    public static TopCryptoCurrency newInstance() {
        TopCryptoCurrency fragment = new TopCryptoCurrency();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // Добавление фрагмента CryptoCurrencies
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CryptoCurrencies cryptoCurrencies = new CryptoCurrencies();
        fragmentTransaction.add(R.id.crypto_currencies_component, cryptoCurrencies);
        fragmentTransaction.commit();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_crypto_currency, container, false);

        // Инициализация RecyclerView
        recyclerView = view.findViewById(R.id.top_recycler_view);

        // Data to populate the RecyclerView with
        ArrayList<Integer> viewColors = new ArrayList<>();
        viewColors.add(Color.rgb(246, 147, 26));
        viewColors.add(Color.rgb(99, 116, 195));
        viewColors.add(Color.rgb(112, 2, 203));

        ArrayList<String> cryptoNames = new ArrayList<>();
        cryptoNames.add("BTC");
        cryptoNames.add("ETH");
        cryptoNames.add("SOL");

        ArrayList<String> cryptoPrice = new ArrayList<>();
        cryptoPrice.add("$99,637.71");
        cryptoPrice.add("$3,984.13");
        cryptoPrice.add("$237.03");


        // Настройка RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        TopCryptoCurrencyAdapter adapter = new TopCryptoCurrencyAdapter(viewColors, cryptoNames, cryptoPrice);
        recyclerView.setAdapter(adapter);


        return view;
    }
}
