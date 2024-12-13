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
        public TextView cryptoUrl;

        public ViewHolder(View itemView) {
            super(itemView);
            cryptoName = itemView.findViewById(R.id.cryptyName1);
            cryptoPrice = itemView.findViewById(R.id.cryptoPrice);
            cryptoLogo = itemView.findViewById(R.id.imageView);
            cryptoTitle = itemView.findViewById(R.id.cryptoTitle);
        }
    }
}