package com.example.mainapp.views.components;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mainapp.R;
import com.example.mainapp.adapters.CryptoCurrenciesAdapter;
import com.example.mainapp.adapters.TopCryptoCurrencyAdapter;
import com.example.mainapp.views.AllCryptoCurrencies;

import java.util.ArrayList;
import java.util.Arrays;


public class CryptoCurrencies extends Fragment {

    private RecyclerView recyclerView;
    private CryptoCurrenciesAdapter adapter;

    // Делаем данные полями класса
    private ArrayList<String> cryptoTitles;
    private ArrayList<String> cryptoNames;
    private ArrayList<String> cryptoPrices;
    private ArrayList<Integer> cryptoLogos;
    private ArrayList<String> cryptoUrls;

    public CryptoCurrencies() {

    }

    public static CryptoCurrencies newInstance(String param1, String param2) {
        CryptoCurrencies fragment = new CryptoCurrencies();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);


        // Инициализируем данные только один раз
        if (cryptoNames == null) {
            cryptoNames = new ArrayList<>();
            cryptoNames.add("MNT/USDT"); // 1
            cryptoNames.add("SHIB/USDT"); // 2
            cryptoNames.add("PEPE/USDT"); // 3
            cryptoNames.add("DOGE/USDT"); // 4
            cryptoNames.add("BTC/USDT"); // 5
            cryptoNames.add("ETH/USDT"); // 6
            cryptoNames.add("SOL/USDT"); // 7
            cryptoNames.add("BNB/USDT"); // 8
            cryptoNames.add("TRX/USDT"); // 9
            cryptoNames.add("ADA/USDT"); // 10
            cryptoNames.add("XRP/USDT"); // 11
            cryptoNames.add("DOT/USDT"); // 12
            cryptoNames.add("LTC/USDT"); // 13
            cryptoNames.add("LINK/USDT"); // 14
            cryptoNames.add("AVAX/USDT"); // 15
            cryptoNames.add("MATIC/USDT"); // 16
            cryptoNames.add("UNI/USDT"); // 17
            cryptoNames.add("XLM/USDT"); // 18
            cryptoNames.add("FIL/USDT"); // 19
            cryptoNames.add("HBAR/USDT"); // 20
            cryptoNames.add("ALGO/USDT"); // 21
            cryptoNames.add("SAND/USDT"); // 22
            cryptoNames.add("FTM/USDT"); // 23
            cryptoNames.add("HNT/USDT"); // 24
            cryptoNames.add("ZIL/USDT"); // 25
            cryptoNames.add("KSM/USDT"); // 26
            cryptoNames.add("GRT/USDT"); // 27
            cryptoNames.add("MANA/USDT"); // 28
            cryptoNames.add("LDO/USDT"); // 29
            cryptoNames.add("ATOM/USDT"); // 30
            cryptoNames.add("ENJ/USDT");   // 31
            cryptoNames.add("MKR/USDT");   // 32
            cryptoNames.add("AAVE/USDT");  // 33
            cryptoNames.add("COMP/USDT");  // 34
            cryptoNames.add("SNX/USDT");   // 35
            cryptoNames.add("LRC/USDT");    // 36
            cryptoNames.add("STORJ/USDT");   // 37
            cryptoNames.add("THETA/USDT");   // 38

            cryptoPrices = new ArrayList<>();
            cryptoPrices.add("$0.6036");
            cryptoPrices.add("$0.00001769");
            cryptoPrices.add("$0.000009694");
            cryptoPrices.add("$0.13818");
            cryptoPrices.add("$63,541.45");
            cryptoPrices.add("$2,541.45");
            cryptoPrices.add("$138.17");
            cryptoPrices.add("$594.21");
            cryptoPrices.add("$0.16643");
            cryptoPrices.add("$0.3460");
            cryptoPrices.add("$0.4867"); // XRP
            cryptoPrices.add("$6.32");   // DOT
            cryptoPrices.add("$90.45");  // LTC
            cryptoPrices.add("$27.56");  // LINK
            cryptoPrices.add("$14.67");  // AVAX
            cryptoPrices.add("$0.94");   // MATIC
            cryptoPrices.add("$6.89");   // UNI
            cryptoPrices.add("$0.12");   // XLM
            cryptoPrices.add("$4.56");   // FIL
            cryptoPrices.add("$0.057");  // HBAR
            cryptoPrices.add("$0.29");    // ALGO
            cryptoPrices.add("$0.75");    // SAND
            cryptoPrices.add("$0.22");    // FTM
            cryptoPrices.add("$0.45");    // HNT
            cryptoPrices.add("$0.03");    // ZIL
            cryptoPrices.add("$50.12");   // KSM
            cryptoPrices.add("$0.09");    // GRT
            cryptoPrices.add("$0.61");    // MANA
            cryptoPrices.add("$1.20");     // LDO
            cryptoPrices.add("$10.45");    // ATOM
            cryptoPrices.add("$0.67");      // ENJ
            cryptoPrices.add("$1,200.00");  // MKR
            cryptoPrices.add("$85.00");     // AAVE
            cryptoPrices.add("$150.00");    // COMP
            cryptoPrices.add("$3.50");      // SNX
            cryptoPrices.add("$0.50");      // LRC
            cryptoPrices.add("$0.02");      // STMX
            cryptoPrices.add("$2.66");      // THETA

            cryptoLogos = new ArrayList<>();
            cryptoLogos.add(R.drawable.mantle_mnt_logo);
            cryptoLogos.add(R.drawable.shiba_inu_shib_logo);
            cryptoLogos.add(R.drawable.pepe_pepe_logo);
            cryptoLogos.add(R.drawable.dogecoin_doge_logo);
            cryptoLogos.add(R.drawable.bitcoin_btc_logo);
            cryptoLogos.add(R.drawable.ethereum_eth_logo);
            cryptoLogos.add(R.drawable.solana_sol_logo);
            cryptoLogos.add(R.drawable.bnb_bnb_logo);
            cryptoLogos.add(R.drawable.tron_trx_logo);
            cryptoLogos.add(R.drawable.cardano_ada_logo);
            cryptoLogos.add(R.drawable.xrp_xrp_logo);   // XRP
            cryptoLogos.add(R.drawable.polkadot_new_dot_logo);    // DOT
            cryptoLogos.add(R.drawable.litecoin_coin);    // LTC
            cryptoLogos.add(R.drawable.chainlink_link_logo);   // LINK
            cryptoLogos.add(R.drawable.avalanche_avax_logo);   // AVAX
            cryptoLogos.add(R.drawable.polygon_coin);  // MATIC
            cryptoLogos.add(R.drawable.uniswap_coin);     // UNI
            cryptoLogos.add(R.drawable.stellar_coin);     // XLM
            cryptoLogos.add(R.drawable.filecoin);     // FIL
            cryptoLogos.add(R.drawable.hedera);    // HBAR
            cryptoLogos.add(R.drawable.algorand_coin);    // ALGO
            cryptoLogos.add(R.drawable.sandbox_coin);     // SAND
            cryptoLogos.add(R.drawable.stacks);      // FTM
            cryptoLogos.add(R.drawable.helium_hnt_logo);      // HNT
            cryptoLogos.add(R.drawable.zilliqa_zil_logo);      // ZIL
            cryptoLogos.add(R.drawable.kusama_ksm_logo);      // KSM
            cryptoLogos.add(R.drawable.the_graph);      // GRT
            cryptoLogos.add(R.drawable.decentraland);     // MANA
            cryptoLogos.add(R.drawable.lido_dao);      // LDO
            cryptoLogos.add(R.drawable.cosmos_atom_logo);   // ATOM
            cryptoLogos.add(R.drawable.enjin_coin_enj_logo);     // ENJ
            cryptoLogos.add(R.drawable.maker_mkr_logo);     // MKR
            cryptoLogos.add(R.drawable.aave_aave_logo);    // AAVE
            cryptoLogos.add(R.drawable.compound_comp_logo);     // COMP
            cryptoLogos.add(R.drawable.sandbox_coin);      // SNX
            cryptoLogos.add(R.drawable.loopring_lrc_logo);      // LRC
            cryptoLogos.add(R.drawable.storj_storj_logo);     // STMX
            cryptoLogos.add(R.drawable.thete);     // STMX

            cryptoTitles = new ArrayList<>();
            cryptoTitles.add("Mantle");
            cryptoTitles.add("Shiba Inu");
            cryptoTitles.add("Pepe");
            cryptoTitles.add("Dogecoin");
            cryptoTitles.add("Bitcoin");
            cryptoTitles.add("Ethereum");
            cryptoTitles.add("Solana");
            cryptoTitles.add("BNB");
            cryptoTitles.add("TRON");
            cryptoTitles.add("Cardano");
            cryptoTitles.add("XRP");
            cryptoTitles.add("Polkadot");
            cryptoTitles.add("Litecoin");
            cryptoTitles.add("Chainlink");
            cryptoTitles.add("Avalanche");
            cryptoTitles.add("Polygon");
            cryptoTitles.add("Uniswap");
            cryptoTitles.add("Stellar");
            cryptoTitles.add("Filecoin");
            cryptoTitles.add("Hedera Hashgraph");
            cryptoTitles.add("Algorand");    // ALGO
            cryptoTitles.add("The Sandbox");  // SAND
            cryptoTitles.add("Fantom");       // FTM
            cryptoTitles.add("Helium");       // HNT
            cryptoTitles.add("Zilliqa");      // ZIL
            cryptoTitles.add("Kusama");       // KSM
            cryptoTitles.add("The Graph");    // GRT
            cryptoTitles.add("Decentraland"); // MANA
            cryptoTitles.add("Lido DAO");     // LDO
            cryptoTitles.add("Cosmos");       // ATOM
            cryptoTitles.add("Enjin Coin");    // ENJ
            cryptoTitles.add("Maker");        // MKR
            cryptoTitles.add("Aave");         // AAVE
            cryptoTitles.add("Compound");     // COMP
            cryptoTitles.add("Synthetix");    // SNX
            cryptoTitles.add("Loopring");     // LRC
            cryptoTitles.add("Storj");       // STMX
            cryptoTitles.add("Theta Network");       // THETA

            cryptoUrls = new ArrayList<>();
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/mantle/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/shiba-inu/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/pepe/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/dogecoin/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/bitcoin/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/ethereum/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/solana/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/bnb/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/tron/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/cardano/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/xrp/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/polkadot-new/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/litecoin/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/chainlink/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/avalanche/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/polygon/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/uniswap/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/stellar/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/filecoin/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/hedera/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/algorand/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/the-sandbox/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/fantom/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/helium/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/zilliqa/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/kusama/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/the-graph/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/decentraland/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/lido-dao/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/cosmos/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/enjin-coin/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/maker/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/aave/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/compound/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/synthetix/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/loopring/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/storj/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/theta-network/");



            // Добавление фрагмента CryptoCurrencies
            FragmentManager fragmentManager = getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            NationCurrencies nationCurrencies = new NationCurrencies();
            fragmentTransaction.add(R.id.nation_currencies_component, nationCurrencies);
            fragmentTransaction.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crypto_currencies, container, false);


        Button buttonAll = view.findViewById(R.id.allButton);

        buttonAll.setOnClickListener(v -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.frame_layout, new AllCryptoCurrencies());
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        recyclerView = view.findViewById(R.id.crypto_currencies_view);



        if (adapter == null) {
            adapter = new CryptoCurrenciesAdapter(cryptoNames, cryptoPrices, cryptoLogos, cryptoTitles, cryptoUrls);
        }

        // Настройка RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }
}