package com.example.mainapp.adapters;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainapp.R;
import com.example.mainapp.views.components.TopCryptoCurrency;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TopCryptoCurrencyAdapter extends RecyclerView.Adapter<TopCryptoCurrencyAdapter.ViewHolder> {

    private ArrayList<Integer> colors; // Список цветов
    private ArrayList<String> cryptoNames; // Список названий криптовалют
    private ArrayList<String> cryptoPrices;

    // Конструктор адаптера
    public TopCryptoCurrencyAdapter(ArrayList<Integer> colors, ArrayList<String> cryptoNames, ArrayList<String> cryptoPrices) {
        this.colors = colors;
        this.cryptoNames = cryptoNames;
        this.cryptoPrices = cryptoPrices;

    }

    // Создание ViewHolder, где мы подключаем макет элемента
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_crypto, parent, false);  // Убедись, что этот макет правильный
        return new ViewHolder(view);
    }

    // Связываем данные с элементами ViewHolder

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Получаем фоновый drawable из RelativeLayout
        GradientDrawable background = (GradientDrawable) holder.itemBackground.getBackground();

        // Меняем цвет в drawable программно
        background.setColor(colors.get(position));

        // Устанавливаем текст для TextView
        holder.cryptoName.setText(cryptoNames.get(position));
        holder.cryptoPrice.setText(cryptoPrices.get(position));
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
        public RelativeLayout itemBackground;


        public ViewHolder(View itemView) {
            super(itemView);
            cryptoName = itemView.findViewById(R.id.cryptyName); // Находим ID cryptoName в top_crypto.xml
            cryptoPrice = itemView.findViewById(R.id.cryptoPrice); // Находим ID cryptoPrice в top_crypto.xml
            itemBackground = itemView.findViewById(R.id.top_crypto_item); // Находим ID top_crypto_item в top_crypto.xml
        }
    }
}