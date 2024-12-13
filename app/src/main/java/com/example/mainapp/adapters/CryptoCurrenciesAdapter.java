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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CryptoCurrenciesAdapter extends RecyclerView.Adapter<CryptoCurrenciesAdapter.ViewHolder> {
    private ArrayList<String> cryptoPrices;
    private ArrayList<String> cryptoNames;
    private ArrayList<Integer> cryptoLogos;
    private ArrayList<String> cryptoTitles;
    private ArrayList<String> cryptoUrls;

    public CryptoCurrenciesAdapter(ArrayList<String> cryptoNames, ArrayList<String> cryptoPrices,
                                   ArrayList<Integer> cryptoLogos, ArrayList<String> cryptoTitles,
                                   ArrayList<String> cryptoUrls) {
        this.cryptoNames = cryptoNames;
        this.cryptoPrices = cryptoPrices;
        this.cryptoLogos = cryptoLogos;
        this.cryptoTitles = cryptoTitles;
        this.cryptoUrls = cryptoUrls;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crypto_currencies_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoCurrenciesAdapter.ViewHolder holder, int position) {
        holder.cryptoName.setText(cryptoNames.get(position));
        holder.cryptoPrice.setText(cryptoPrices.get(position));
        holder.cryptoLogo.setImageResource(cryptoLogos.get(position));
        holder.cryptoTitle.setText(cryptoTitles.get(position));

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
                    .replace(R.id.frame_layout, detailFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }


    // Возвращаем количество элементов в списке
    @Override
    public int getItemCount() {
        return cryptoNames.size();
    }

    // Класс ViewHolder, который хранит ссылки на элементы в item
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cryptoName;
        public TextView cryptoPrice;
        public ImageView cryptoLogo;
        public TextView cryptoTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            cryptoName = itemView.findViewById(R.id.cryptyName); // Находим ID cryptoName в crypto_currencies_item.xml
            cryptoPrice = itemView.findViewById(R.id.cryptoPrice); // Находим ID cryptoPrice в crypto_currencies_item.xml
            cryptoLogo = itemView.findViewById(R.id.imageView); // Находим ID cryptoLogo в crypto_currencies_item.xml
            cryptoTitle = itemView.findViewById(R.id.cryptoTitle); // Находим ID cryptoTitle в crypto_currencies_item.xml
        }
    }
}
