package com.example.mainapp.views;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainapp.R;
import com.example.mainapp.adapters.SearchAdapter;

import java.util.ArrayList;

public class Search extends Fragment {

    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private ArrayList<String> cryptoPrices;
    private ArrayList<String> cryptoNames;
    private ArrayList<Integer> cryptoLogos;
    private ArrayList<String> cryptoTitles;
    private ArrayList<String> cryptoUrls;

    // Списки для фильтрации
    private ArrayList<String> filteredPrices;
    private ArrayList<String> filteredNames;
    private ArrayList<Integer> filteredLogos;
    private ArrayList<String> filteredTitles;
    private ArrayList<String> filteredUrls;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Инициализация данных
        initializeData();

        // Настройка RecyclerView
        recyclerView = view.findViewById(R.id.top_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        searchAdapter = new SearchAdapter(cryptoPrices, cryptoNames, cryptoLogos, cryptoTitles, cryptoUrls);
        recyclerView.setAdapter(searchAdapter);

        // Настройка EditText для поиска
        EditText edtSearchText = view.findViewById(R.id.edt_search_text);
        edtSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        return view;
    }

    private void initializeData() {
        // Здесь вы должны инициализировать ваши данные
        cryptoPrices = new ArrayList<>();
        cryptoNames = new ArrayList<>();
        cryptoLogos = new ArrayList<>();
        cryptoTitles = new ArrayList<>();
        cryptoUrls = new ArrayList<>();

        // Пример данных
        cryptoNames.add("Bitcoin");
        cryptoPrices.add("$50,000");
        cryptoLogos.add(R.drawable.bitcoin_btc_logo); // Замените на ваши ресурсы
        cryptoTitles.add("Bitcoin Title");
        cryptoUrls.add("https://www.flaticon.com/free-icons/search");

        cryptoNames.add("Altcoin");
        cryptoPrices.add("$50,000");
        cryptoLogos.add(R.drawable.bitcoin_btc_logo); // Замените на ваши ресурсы
        cryptoTitles.add("Bitcoin Title");
        cryptoUrls.add("https://www.flaticon.com/free-icons/search");

        // Добавьте больше данных по мере необходимости
    }

    private void filter(String text) {
        filteredNames = new ArrayList<>();
        filteredPrices = new ArrayList<>();
        filteredLogos = new ArrayList<>();
        filteredTitles = new ArrayList<>();
        filteredUrls = new ArrayList<>();

        for (int i = 0; i < cryptoNames.size(); i++) {
            if (cryptoNames.get(i).toLowerCase().contains(text.toLowerCase())) {
                filteredNames.add(cryptoNames.get(i));
                filteredPrices.add(cryptoPrices.get(i));
                filteredLogos.add(cryptoLogos.get(i));
                filteredTitles.add(cryptoTitles.get(i));
                filteredUrls.add(cryptoUrls.get(i));
            }
        }

        // Обновляем адаптер с отфильтрованными данными
        searchAdapter.filterList(filteredPrices, filteredNames, filteredLogos, filteredTitles, filteredUrls);
    }
}