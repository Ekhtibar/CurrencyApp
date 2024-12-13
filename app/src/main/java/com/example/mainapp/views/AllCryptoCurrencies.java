package com.example.mainapp.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainapp.R;
import com.example.mainapp.adapters.OpenAllAdapaters.AllCryptoCurrenciesAdapter;

import java.util.ArrayList;


public class AllCryptoCurrencies extends Fragment {

    private RecyclerView recyclerView;
    private AllCryptoCurrenciesAdapter adapter;

    // Делаем данные полями класса
    private ArrayList<String> cryptoTitles;
    private ArrayList<String> cryptoNames;
    private ArrayList<String> cryptoPrices;
    private ArrayList<Integer> cryptoLogos;
    private ArrayList<String> cryptoUrls;


    public AllCryptoCurrencies() {
        // Required empty public constructor
    }


    public static AllCryptoCurrencies newInstance(String param1, String param2) {
        AllCryptoCurrencies fragment = new AllCryptoCurrencies();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

            cryptoUrls = new ArrayList<>();
            cryptoUrls.add("https://coinmarketcap.com/currencies/mantle/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/shiba-inu/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/pepe/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/dogecoin/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/bitcoin/");
            cryptoUrls.add("https://coinmarketcap.com/ru/currencies/ethereum/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/solana/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/bnb/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/tron/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/cardano/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/xrp/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/polkadot-new/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/litecoin/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/chainlink/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/avalanche/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/polygon/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/uniswap/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/stellar/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/filecoin/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/hedera/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/algorand/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/the-sandbox/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/fantom/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/helium/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/zilliqa/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/kusama/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/the-graph/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/decentraland/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/lido-dao/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/cosmos/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/enjin-coin/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/maker/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/aave/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/compound/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/synthetix/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/loopring/");
            cryptoUrls.add("https://coinmarketcap.com/currencies/storj/");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_crypto_currencies, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar2);
        toolbar.setNavigationOnClickListener(v -> {
            getActivity().getSupportFragmentManager().popBackStack();
        });

        recyclerView = view.findViewById(R.id.all_crypto_currencies_view);

        // Настройка RecyclerView
        if (adapter == null) {
            adapter = new AllCryptoCurrenciesAdapter(cryptoNames, cryptoPrices, cryptoLogos, cryptoTitles, cryptoUrls);
        }

        // Настройка RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }
}