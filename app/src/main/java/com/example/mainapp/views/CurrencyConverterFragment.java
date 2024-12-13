package com.example.mainapp.views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mainapp.R;

public class CurrencyConverterFragment extends Fragment {

    private WebView webView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency_converter, container, false);

        // Получаем WebView, ProgressBar и SwipeRefreshLayout по ID
        webView = view.findViewById(R.id.webViewCurrency);
        progressBar = view.findViewById(R.id.progressBar);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

        // Настраиваем WebView
        setupWebView();

        // Настраиваем SwipeRefreshLayout
        setupSwipeRefresh();

        return view;
    }

    private void setupWebView() {
        if (webView != null) {
            // Устанавливаем WebViewClient и WebChromeClient для управления загрузкой
            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    if (newProgress == 100) {
                        progressBar.setVisibility(View.GONE);  // Скрываем ProgressBar после загрузки
                        swipeRefreshLayout.setRefreshing(false);  // Завершаем анимацию SwipeRefreshLayout
                    } else {
                        progressBar.setVisibility(View.VISIBLE);  // Показываем ProgressBar во время загрузки
                    }
                }
            });

            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("https://finance.rambler.ru/calculators/converter/");  // Замените на нужный URL
        } else {
            Log.e("CurrencyConverterFragment", "WebView is null");
        }
    }

    private void setupSwipeRefresh() {
        swipeRefreshLayout.setEnabled(false);  // Отключаем обновление по умолчанию

        // Добавляем слушатель скролла для контроля SwipeRefreshLayout
        webView.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if (scrollY == 0) {
                swipeRefreshLayout.setEnabled(true);  // Включаем обновление только на верхней границе
            } else {
                swipeRefreshLayout.setEnabled(false);
            }
        });

        // Настройка жеста для обновления страницы
        swipeRefreshLayout.setOnRefreshListener(() -> {
            if (webView != null) {
                webView.reload();  // Перезагружаем страницу при обновлении свайпом
            } else {
                swipeRefreshLayout.setRefreshing(false);  // Останавливаем анимацию, если WebView не найден
            }
        });
    }
}