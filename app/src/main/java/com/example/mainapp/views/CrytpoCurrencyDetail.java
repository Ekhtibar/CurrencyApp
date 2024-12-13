package com.example.mainapp.views;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.mainapp.R;


public class CrytpoCurrencyDetail extends Fragment {
    private WebView webView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;


    public CrytpoCurrencyDetail() {
        // Required empty public constructor
    }

    public static CrytpoCurrencyDetail newInstance(String param1, String param2) {
        CrytpoCurrencyDetail fragment = new CrytpoCurrencyDetail();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crytpo_currency_detail, container, false);

        webView = view.findViewById(R.id.cryptoWebView);
        progressBar = view.findViewById(R.id.progressBar);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh);

        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        webView.getSettings().setJavaScriptEnabled(true);

        Toolbar toolbar = view.findViewById(R.id.toolbar2);
        toolbar.setNavigationOnClickListener(v -> {
            getActivity().getSupportFragmentManager().popBackStack();
        });

        if (getArguments() != null) {
            String url = getArguments().getString("url");
            if (url != null) {
                // Настраиваем WebViewClient для отслеживания загрузки
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        // Показываем ProgressBar при начале загрузки
                        progressBar.setVisibility(View.VISIBLE);
                        webView.setVisibility(View.GONE); // Скрываем WebView, пока идет загрузка
                    }

                    @Override
                    public void onPageFinished(WebView view, String url) {
                        // Скрываем ProgressBar, когда загрузка завершена
                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE); // Показываем WebView, когда загрузка завершена
                        swipeRefreshLayout.setRefreshing(false);
                    }

                });

                // Загружаем URL
                webView.loadUrl(url);
            }
        }

        swipeRefreshLayout.setOnRefreshListener(() -> webView.reload());

        return view;

    }
}