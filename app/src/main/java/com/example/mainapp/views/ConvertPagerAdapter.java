package com.example.mainapp.views;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ConvertPagerAdapter extends FragmentStateAdapter {

    public ConvertPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new CurrencyConverterFragment(); // Фрагмент для валют
            case 1:
                return new CryptoConverterFragment(); // Фрагмент для криптовалют
            default:
                return new CurrencyConverterFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Количество табов
    }
}