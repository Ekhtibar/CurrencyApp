package com.example.mainapp.adapters.OpenAllAdapaters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainapp.R;
import com.example.mainapp.views.CrytpoCurrencyDetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AllNationCurrenciesAdapter extends RecyclerView.Adapter<AllNationCurrenciesAdapter.ViewHolder> {

    private ArrayList<String> currencyPricesInRubl;
    private ArrayList<String> currencyNames;
    private ArrayList<Integer> countryFlags;
    private ArrayList<String> currencyTitles;
    private ArrayList<String> cryptoUrls;

    public AllNationCurrenciesAdapter(ArrayList<String> currencyPricesInRubl, ArrayList<String> currencyNames,
                                      ArrayList<Integer> countryFlags, ArrayList<String> currencyTitles,
                                      ArrayList<String> cryptoUrls) {
        this.currencyPricesInRubl = currencyPricesInRubl;
        this.currencyNames = currencyNames;
        this.countryFlags = countryFlags;
        this.currencyTitles = currencyTitles;
        this.cryptoUrls = cryptoUrls;

        // Сортируем по currencyTitle
        sortByTitle();
    }

    private void sortByTitle() {
        // Создаем список индексов
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < currencyTitles.size(); i++) {
            indices.add(i);
        }

        // Сортируем индексы на основе значений в currencyTitles
        Collections.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer index1, Integer index2) {
                return currencyTitles.get(index1).compareTo(currencyTitles.get(index2));
            }
        });

        // Создаем новые отсортированные списки
        ArrayList<String> sortedCurrencyTitles = new ArrayList<>();
        ArrayList<String> sortedCurrencyNames = new ArrayList<>();
        ArrayList<String> sortedCurrencyPricesInRubl = new ArrayList<>();
        ArrayList<Integer> sortedCountryFlags = new ArrayList<>();
        ArrayList<String> sortedCryptoUrls = new ArrayList<>();

        for (int index : indices) {
            sortedCurrencyTitles.add(currencyTitles.get(index));
            sortedCurrencyNames.add(currencyNames.get(index));
            sortedCurrencyPricesInRubl.add(currencyPricesInRubl.get(index));
            sortedCountryFlags.add(countryFlags.get(index));
            sortedCryptoUrls.add(cryptoUrls.get(index));
        }

        // Обновляем оригинальные списки
        currencyTitles = sortedCurrencyTitles;
        currencyNames = sortedCurrencyNames;
        currencyPricesInRubl = sortedCurrencyPricesInRubl;
        countryFlags = sortedCountryFlags;
        cryptoUrls = sortedCryptoUrls;
    }

    // Создание ViewHolder, где мы подключаем макет элемента
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_nation_currencies_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Устанавливаем текст для TextView
        holder.currencyPrice.setText(currencyPricesInRubl.get(position));
        holder.currencyName.setText(currencyNames.get(position));
        holder.countryFlag.setImageResource(countryFlags.get(position));
        holder.currencyTitle.setText(currencyTitles.get(position));

        String cryptoExchangeUrl = cryptoUrls.get(position);

        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("url", cryptoExchangeUrl);  // Передаем URL из массива

            CrytpoCurrencyDetail detailFragment = new CrytpoCurrencyDetail();
            detailFragment.setArguments(bundle);

            ((FragmentActivity) v.getContext()).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, detailFragment)  // Замените на ID контейнера для фрагментов
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return currencyNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView currencyName;
        public TextView currencyPrice;
        public ImageView countryFlag;
        public TextView currencyTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            currencyName = itemView.findViewById(R.id.currencyName); // Находим ID currencyName в all_nation_currencies_item.xml
            currencyPrice = itemView.findViewById(R.id.currencyPriceInRubl); // Находим ID currencyPriceInRubl в all_nation_currencies_item.xml
            countryFlag = itemView.findViewById(R.id.countryFlag); // Находим ID countryFlag в all_nation_currencies_item.xml
            currencyTitle = itemView.findViewById(R.id.currencyTitle); // Находим ID currencyTitle в all_nation_currencies_item.xml
        }
    }
}