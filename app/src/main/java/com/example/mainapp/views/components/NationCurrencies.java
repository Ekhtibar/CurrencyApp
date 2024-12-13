package com.example.mainapp.views.components;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainapp.R;
import com.example.mainapp.adapters.NationCurrenciesAdapter;
import com.example.mainapp.views.AllNationCurrencies;

import java.util.ArrayList;


public class NationCurrencies extends Fragment {

    private RecyclerView recyclerView;


    private ArrayList<String> currencyPricesInRubl;
    private ArrayList<String> currencyNames;
    private ArrayList<Integer> countryFlags;
    private ArrayList<String> currencyTitles;
    private ArrayList<String> cryptoUrls;

    public NationCurrencies() {
        // Required empty public constructor
    }

    public static NationCurrencies newInstance(String param1, String param2) {
        NationCurrencies fragment = new NationCurrencies();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (currencyNames == null) {
            countryFlags = new ArrayList<>();
            countryFlags.add(R.drawable.eu);
            countryFlags.add(R.drawable.us);
            countryFlags.add(R.drawable.az);
            countryFlags.add(R.drawable.au);
            countryFlags.add(R.drawable.ae);
            countryFlags.add(R.drawable.bg);
            countryFlags.add(R.drawable.cn);
            countryFlags.add(R.drawable.by);
            countryFlags.add(R.drawable.ca);
            countryFlags.add(R.drawable.in);
            countryFlags.add(R.drawable.ch); // Швейцарский франк
            countryFlags.add(R.drawable.jp); // Японская иена
            countryFlags.add(R.drawable.tr); // Турецкая лира
            countryFlags.add(R.drawable.kr); // Южнокорейская вона
            countryFlags.add(R.drawable.vn); // Вьетнамский донг
            countryFlags.add(R.drawable.hk); // Гонконгский доллар
            countryFlags.add(R.drawable.se); // Шведская крона
            countryFlags.add(R.drawable.no); // Норвежская крона
            countryFlags.add(R.drawable.br); // Бразильский реал
            countryFlags.add(R.drawable.za); // Южноафриканский рэнд
            countryFlags.add(R.drawable.ar); // Аргентинский песо
            countryFlags.add(R.drawable.mx); // Мексиканское песо
            countryFlags.add(R.drawable.eg); // Египетский фунт
            countryFlags.add(R.drawable.id); // Индонезийская рупия
            countryFlags.add(R.drawable.kz); // Казахстанский тенге
            countryFlags.add(R.drawable.ph); // Филиппинское песо
            countryFlags.add(R.drawable.pl); // Польский злотый
            countryFlags.add(R.drawable.cl); // Чилийский песо
            countryFlags.add(R.drawable.rs); // Сербский динар
            countryFlags.add(R.drawable.my); // Малайзийский ринггит
            countryFlags.add(R.drawable.pk); // Пакистанская рупия
            countryFlags.add(R.drawable.sg); // Сингапурский доллар
            countryFlags.add(R.drawable.th); // Таиландский бат
            countryFlags.add(R.drawable.hu); // Венгерский форинт
            countryFlags.add(R.drawable.cz); // Чешская крона
            countryFlags.add(R.drawable.dk); // Датская крона
            countryFlags.add(R.drawable.hr); // Хорватская куна
            countryFlags.add(R.drawable.qa); // Катарский риал
            countryFlags.add(R.drawable.is); // Исландская крона
            countryFlags.add(R.drawable.ma); // Марокканский дирхам
            countryFlags.add(R.drawable.jo); // Иорданский динар
            countryFlags.add(R.drawable.lk); // Шри-ланкийская рупия
            countryFlags.add(R.drawable.tw); // Тайваньский доллар


            currencyTitles = new ArrayList<>();
            currencyTitles.add("1 EUR");
            currencyTitles.add("1 USD");
            currencyTitles.add("1 AZN");
            currencyTitles.add("1 AUD");
            currencyTitles.add("10 AED");
            currencyTitles.add("1 BGN");
            currencyTitles.add("10 CNY");
            currencyTitles.add("1 BYN");
            currencyTitles.add("1 CAD");
            currencyTitles.add("100 INR");
            currencyTitles.add("1 CHF"); // Швейцарский франк
            currencyTitles.add("100 JPY"); // Японская иена
            currencyTitles.add("1 TRY"); // Турецкая лира
            currencyTitles.add("1000 KRW"); // Южнокорейская вона
            currencyTitles.add("10000 VND"); // Вьетнамский донг
            currencyTitles.add("10 HKD"); // Гонконгский доллар
            currencyTitles.add("10 SEK"); // Шведская крона
            currencyTitles.add("10 NOK"); // Норвежская крона
            currencyTitles.add("1 BRL"); // Бразильский реал
            currencyTitles.add("10 ZAR"); // Южноафриканский рэнд
            currencyTitles.add("100 ARS"); // Аргентинский песо
            currencyTitles.add("10 MXN"); // Мексиканское песо
            currencyTitles.add("10 EGP"); // Египетский фунт
            currencyTitles.add("10000 IDR"); // Индонезийская рупия
            currencyTitles.add("100 KZT"); // Казахстанский тенге
            currencyTitles.add("10 PHP"); // Филиппинское песо
            currencyTitles.add("1 PLN"); // Польский злотый
            currencyTitles.add("1000 CLP"); // Чилийский песо
            currencyTitles.add("100 RSD"); // Сербский динар
            currencyTitles.add("1 MYR"); // Малайзийский ринггит
            currencyTitles.add("100 PKR"); // Пакистанская рупия
            currencyTitles.add("1 SGD"); // Сингапурский доллар
            currencyTitles.add("100 THB"); // Таиландский бат
            currencyTitles.add("100 HUF"); // Венгерский форинт
            currencyTitles.add("10 CZK"); // Чешская крона
            currencyTitles.add("10 DKK"); // Датская крона
            currencyTitles.add("1 HRK"); // Хорватская куна
            currencyTitles.add("10 QAR"); // Катарский риал
            currencyTitles.add("100 ISK"); // Исландская крона
            currencyTitles.add("10 MAD"); // Марокканский дирхам
            currencyTitles.add("1 JOD"); // Иорданский динар
            currencyTitles.add("100 LKR"); // Шри-ланкийская рупия
            currencyTitles.add("10 TWD"); // Тайваньский доллар

            currencyPricesInRubl = new ArrayList<>();
            currencyPricesInRubl.add("₽106.26");
            currencyPricesInRubl.add("₽96.6379");
            currencyPricesInRubl.add("₽56.8458");
            currencyPricesInRubl.add("₽64.5251");
            currencyPricesInRubl.add("₽263.1390");
            currencyPricesInRubl.add("₽53.4667");
            currencyPricesInRubl.add("₽135.1920");
            currencyPricesInRubl.add("₽29.3029");
            currencyPricesInRubl.add("₽69.9008");
            currencyPricesInRubl.add("₽114.9420");
            currencyPricesInRubl.add("₽111.5331"); // Швейцарский франк
            currencyPricesInRubl.add("₽63.5666"); // Японская иена
            currencyPricesInRubl.add("₽2.8248"); // Турецкая лира
            currencyPricesInRubl.add("₽70.0222"); // Южнокорейская вона
            currencyPricesInRubl.add("₽39.8539"); // Вьетнамский донг
            currencyPricesInRubl.add("₽124.6330"); // Гонконгский доллар
            currencyPricesInRubl.add("₽91.4341"); // Шведская крона
            currencyPricesInRubl.add("₽88.3655"); // Норвежская крона
            currencyPricesInRubl.add("₽16.9339"); // Бразильский реал
            currencyPricesInRubl.add("₽54.6953"); // Южноафриканский рэнд
            currencyPricesInRubl.add("₽9.8756"); // Аргентинский песо
            currencyPricesInRubl.add("₽48.7392"); // Мексиканское песо
            currencyPricesInRubl.add("₽19.8108"); // Египетский фунт
            currencyPricesInRubl.add("₽61.9930"); // Индонезийская рупия
            currencyPricesInRubl.add("₽19.9266"); // Казахстанский тенге
            currencyPricesInRubl.add("₽16.6040"); // Филиппинское песо
            currencyPricesInRubl.add("₽24.0348"); // Польский злотый
            currencyPricesInRubl.add("₽102.7032"); // Чилийский песо
            currencyPricesInRubl.add("₽89.3866"); // Сербский динар
            currencyPricesInRubl.add("₽22.4176"); // Малайзийский ринггит
            currencyPricesInRubl.add("₽35.0449"); // Пакистанская рупия
            currencyPricesInRubl.add("₽73.2371"); // Сингапурский доллар
            currencyPricesInRubl.add("₽286.1860"); // Таиландский бат
            currencyPricesInRubl.add("₽25.8859"); // Венгерский форинт
            currencyPricesInRubl.add("₽41.4323"); // Чешская крона
            currencyPricesInRubl.add("₽139.9610"); // Датская крона
            currencyPricesInRubl.add("₽13.8685"); // Хорватская куна
            currencyPricesInRubl.add("₽266.5650"); // Катарский риал
            currencyPricesInRubl.add("₽70.74"); // Исландская крона
            currencyPricesInRubl.add("₽98.3382"); // Марокканский дирхам
            currencyPricesInRubl.add("₽137.3234"); // Иорданский динар
            currencyPricesInRubl.add("₽33.1577"); // Шри-ланкийская рупия
            currencyPricesInRubl.add("₽30.3250"); // Тайваньский доллар



            currencyNames = new ArrayList<>();
            currencyNames.add("Евро"); // 1
            currencyNames.add("Доллар США"); // 2
            currencyNames.add("Азербайджанский манат"); // 3
            currencyNames.add("Афганский афгани"); // 4
            currencyNames.add("Дирхам"); // 5
            currencyNames.add("Болгарский лев"); // 6
            currencyNames.add("Китайских юаней"); // 7
            currencyNames.add("Белорусский рубль"); // 8
            currencyNames.add("Канадский доллар"); // 9
            currencyNames.add("Индийских рупий"); // 10
            currencyNames.add("Швейцарский франк"); // 11
            currencyNames.add("Японская иена"); // 12
            currencyNames.add("Турецкая лира"); // 13
            currencyNames.add("Южнокорейская вона"); // 14
            currencyNames.add("Вьетнамский донг"); // 15
            currencyNames.add("Гонконгский доллар"); // 16
            currencyNames.add("Шведская крона"); // 17
            currencyNames.add("Норвежская крона"); // 18
            currencyNames.add("Бразильский реал"); // 19
            currencyNames.add("Южноафриканский рэнд"); // 20
            currencyNames.add("Аргентинский песо"); // 21
            currencyNames.add("Мексиканское песо"); // 22
            currencyNames.add("Египетский фунт"); // 23
            currencyNames.add("Индонезийская рупия"); // 24
            currencyNames.add("Казахстанский тенге"); // 25
            currencyNames.add("Филиппинское песо"); // 26
            currencyNames.add("Польский злотый"); // 27
            currencyNames.add("Чилийский песо"); // 28
            currencyNames.add("Сербский динар"); // 29
            currencyNames.add("Малайзийский ринггит"); // 30
            currencyNames.add("Пакистанская рупия"); // 31
            currencyNames.add("Сингапурский доллар"); // 32
            currencyNames.add("Таиландский бат"); // 33
            currencyNames.add("Венгерский форинт"); // 34
            currencyNames.add("Чешская крона"); // 35
            currencyNames.add("Датская крона"); // 36
            currencyNames.add("Хорватская куна"); // 37
            currencyNames.add("Катарский риал"); // 38
            currencyNames.add("Исландская крона"); // 39
            currencyNames.add("Марокканский дирхам"); // 40
            currencyNames.add("Иорданский динар"); // 41
            currencyNames.add("Шри-ланкийская рупия"); // 42
            currencyNames.add("Тайваньский доллар"); // 43


            cryptoUrls = new ArrayList<>();
            cryptoUrls.add("https://finance.rambler.ru/currencies/EUR/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/USD/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/AZN/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/AUD/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/AED/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/BGN/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/CNY/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/BYN/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/CAD/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/INR/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/CHF/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/JPY/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/TRY/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/KRW/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/VND/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/HKD/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/SEK/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/NOK/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/BRL/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/ZAR/");
            cryptoUrls.add("https://beststocks.ru/currency/ars");
            cryptoUrls.add("https://beststocks.ru/currency/mxn");
            cryptoUrls.add("https://beststocks.ru/currency/egp");
            cryptoUrls.add("https://finance.rambler.ru/currencies/IDR/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/KZT/");
            cryptoUrls.add("https://beststocks.ru/currency/php");
            cryptoUrls.add("https://finance.rambler.ru/currencies/PLN/");
            cryptoUrls.add("https://beststocks.ru/currency/clp");
            cryptoUrls.add("https://finance.rambler.ru/currencies/RSD/");
            cryptoUrls.add("https://beststocks.ru/currency/myr");
            cryptoUrls.add("https://beststocks.ru/currency/pkr");
            cryptoUrls.add("https://finance.rambler.ru/currencies/SGD/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/THB/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/HUF/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/CZK/");
            cryptoUrls.add("https://finance.rambler.ru/currencies/DKK/");
            cryptoUrls.add("https://beststocks.ru/currency/hrk");
            cryptoUrls.add("https://finance.rambler.ru/currencies/QAR/");
            cryptoUrls.add("https://beststocks.ru/currency/isk");
            cryptoUrls.add("https://beststocks.ru/currency/mad");
            cryptoUrls.add("https://beststocks.ru/currency/jod");
            cryptoUrls.add("https://beststocks.ru/currency/lkr");
            cryptoUrls.add("https://beststocks.ru/currency/twd");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nation_currencies, container, false);

        Button buttonAll = view.findViewById(R.id.button);

        buttonAll.setOnClickListener(v -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.frame_layout, new AllNationCurrencies());
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);  // Пример корректного перехода
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        recyclerView = view.findViewById(R.id.nation_currencies_view);
        // Настройка RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        NationCurrenciesAdapter adapter = new NationCurrenciesAdapter(currencyNames, currencyPricesInRubl, countryFlags, currencyTitles, cryptoUrls);
        recyclerView.setAdapter(adapter);

        return view;
    }
}