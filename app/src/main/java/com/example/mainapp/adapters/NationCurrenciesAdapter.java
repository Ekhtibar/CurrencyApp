package com.example.mainapp.adapters;

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

public class NationCurrenciesAdapter extends RecyclerView.Adapter<NationCurrenciesAdapter.ViewHolder> {
    private ArrayList<String> currencyPricesInRubl;
    private ArrayList<String> currencyNames;
    private ArrayList<Integer> countryFlags;
    private ArrayList<String> currencyTitles;
    private ArrayList<String> cryptoUrls;


    public NationCurrenciesAdapter(ArrayList<String> currencyNames, ArrayList<String> currencyPricesInRubl,
                                   ArrayList<Integer> countryFlags, ArrayList<String> currencyTitles,
                                   ArrayList<String> cryptoUrls) {
        this.currencyNames = currencyNames;
        this.currencyPricesInRubl = currencyPricesInRubl;
        this.countryFlags = countryFlags;
        this.currencyTitles = currencyTitles;
        this.cryptoUrls = cryptoUrls;


    }

    // Создание ViewHolder, где мы подключаем макет элемента
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nation_currency_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NationCurrenciesAdapter.ViewHolder holder, int position) {


        // Устанавливаем текст для TextView
        holder.currencyName.setText(currencyNames.get(position));
        holder.currencyPrice.setText(currencyPricesInRubl.get(position));
        holder.countryFlag.setImageResource(countryFlags.get(position));
        holder.currencyTitle.setText(currencyTitles.get(position));

        String cryptoExchangeUrl = cryptoUrls.get(position);

        // Устанавливаем слушатель клика для перехода в DetailFragment
        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("url", cryptoExchangeUrl);  // Передаем URL из массива

            // Создаем новый экземпляр CrytpoCurrencyDetail и передаем аргументы
            CrytpoCurrencyDetail detailFragment = new CrytpoCurrencyDetail();
            detailFragment.setArguments(bundle);

            // Выполняем транзакцию замены фрагмента
            ((FragmentActivity) v.getContext()).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, detailFragment)  // Замените на ID контейнера для фрагментов
                    .addToBackStack(null)
                    .commit();
        });
    }

    // Связываем данные с элементами ViewHolder



    // Возвращаем количество элементов в списке
    @Override
    public int getItemCount() {
        return currencyNames.size();
    }

    // Класс ViewHolder, который хранит ссылки на элементы в item
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView currencyName;
        public TextView currencyPrice;
        public ImageView countryFlag;
        public TextView currencyTitle;


        public ViewHolder(View itemView) {
            super(itemView);
            currencyName = itemView.findViewById(R.id.currencyName); // Находим ID currencyName в nation_currency_item.xml
            currencyPrice = itemView.findViewById(R.id.currencyPriceInRubl); // Находим ID currencyPriceInRubl в nation_currency_item.xml
            countryFlag = itemView.findViewById(R.id.countryFlag); // Находим ID countryFlag в nation_currency_item.xml
            currencyTitle = itemView.findViewById(R.id.currencyTitle); // Находим ID currencyTitle в nation_currency_item.xml
        }
    }
}