package com.example.mainapp.views;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mainapp.R;
import com.example.mainapp.views.components.CryptoCurrencies;
import com.example.mainapp.views.components.TopCryptoCurrency;

public class Home extends Fragment {

    public Home() {
        // Required empty public constructor
    }

    public static Home newInstance() {
        Home fragment = new Home();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setReenterTransition(true);
        // Добавление фрагмента MyComponent
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TopCryptoCurrency topCryptoCurrency = new TopCryptoCurrency(); // Создайте экземпляр вашего фрагмента
        fragmentTransaction.add(R.id.top_crypto_currency_component, topCryptoCurrency); // Проверьте идентификатор
        fragmentTransaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        return view;
    }

}
