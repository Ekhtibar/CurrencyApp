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

public class AllCryptoCurrenciesAdapter extends RecyclerView.Adapter<AllCryptoCurrenciesAdapter.ViewHolder> {
    private ArrayList<String> cryptoPrices;
    private ArrayList<String> cryptoNames;
    private ArrayList<Integer> cryptoLogos;
    private ArrayList<String> cryptoTitles;
    private ArrayList<String> cryptoUrls;

    public AllCryptoCurrenciesAdapter(ArrayList<String> cryptoNames, ArrayList<String> cryptoPrices,
                                      ArrayList<Integer> cryptoLogos, ArrayList<String> cryptoTitles,
                                      ArrayList<String> cryptoUrls) {
        this.cryptoNames = cryptoNames;
        this.cryptoPrices = cryptoPrices;
        this.cryptoLogos = cryptoLogos;
        this.cryptoTitles = cryptoTitles;
        this.cryptoUrls = cryptoUrls;

        // Сортируем по cryptoTitle
        sortByTitle();
    }

    private void sortByTitle() {
        // Создаем список индексов
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < cryptoTitles.size(); i++) {
            indices.add(i);
        }

        // Сортируем индексы на основе значений в cryptoTitles
        Collections.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer index1, Integer index2) {
                return cryptoTitles.get(index1).compareTo(cryptoTitles.get(index2));
            }
        });

        // Создаем новые отсортированные списки
        ArrayList<String> sortedCryptoTitles = new ArrayList<>();
        ArrayList<String> sortedCryptoNames = new ArrayList<>();
        ArrayList<String> sortedCryptoPrices = new ArrayList<>();
        ArrayList<Integer> sortedCryptoLogos = new ArrayList<>();
        ArrayList<String> sortedCryptoUrls = new ArrayList<>();

        for (int index : indices) {
            sortedCryptoTitles.add(cryptoTitles.get(index));
            sortedCryptoNames.add(cryptoNames.get(index));
            sortedCryptoPrices.add(cryptoPrices.get(index));
            sortedCryptoLogos.add(cryptoLogos.get(index));
            sortedCryptoUrls.add(cryptoUrls.get(index));
        }

        // Обновляем оригинальные списки
        cryptoTitles = sortedCryptoTitles;
        cryptoNames = sortedCryptoNames;
        cryptoPrices = sortedCryptoPrices;
        cryptoLogos = sortedCryptoLogos;
        cryptoUrls = sortedCryptoUrls;
    }

    // Создание ViewHolder, где мы подключаем макет элемента
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_crypto_currencies_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCryptoCurrenciesAdapter.ViewHolder holder, int position) {
        // Устанавливаем текст для TextView
        holder.cryptoName.setText(cryptoNames.get(position));
        holder.cryptoPrice.setText(cryptoPrices.get(position));
        holder.cryptoLogo.setImageResource(cryptoLogos.get(position));
        holder.cryptoTitle.setText(cryptoTitles.get(position));

        String cryptoExchangeUrl = cryptoUrls.get(position);

        // Устанавливаем слушатель клика для перехода в DetailFragment
        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("url", cryptoExchangeUrl);

            // Создаем новый экземпляр CrytpoCurrencyDetail и передаем аргументы
            CrytpoCurrencyDetail detailFragment = new CrytpoCurrencyDetail();
            detailFragment.setArguments(bundle);

            // Выполняем транзакцию замены фрагмента
            ((FragmentActivity) v.getContext()).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, detailFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return cryptoNames.size();
    }
        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView cryptoName;
            public TextView cryptoPrice;
            public ImageView cryptoLogo;
            public TextView cryptoTitle;

            public ViewHolder(View itemView) {
                super(itemView);
                cryptoName = itemView.findViewById(R.id.cryptyName1); // Находим ID cryptoName в all_crypto_currencies_item.xml
                cryptoPrice = itemView.findViewById(R.id.cryptoPrice); // Находим ID cryptoPrice в all_crypto_currencies_item.xml
                cryptoLogo = itemView.findViewById(R.id.imageView); // Находим ID cryptoLogo в all_crypto_currencies_item.xml
                cryptoTitle = itemView.findViewById(R.id.cryptoTitle); // Находим ID cryptoTitle в all_crypto_currencies_item.xml
            }
        }
    }