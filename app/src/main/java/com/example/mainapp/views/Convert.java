package com.example.mainapp.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.example.mainapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Convert extends Fragment {

    public Convert() {
        // Required empty public constructor
    }

    public static Convert newInstance() {
        return new Convert();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_convert, container, false);

        // Инициализация TabLayout и ViewPager2
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);

        // Установка адаптера для ViewPager2
        com.example.mainapp.views.ConvertPagerAdapter adapter = new com.example.mainapp.views.ConvertPagerAdapter(getActivity());
        viewPager.setAdapter(adapter);

        // Связывание TabLayout с ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("Валюта");
            } else if (position == 1) {
                tab.setText("Криптовалюта");
            }
        }).attach();

        return view;
    }
}