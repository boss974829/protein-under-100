package com.boss974829.proteinunder100;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String SITE_URL = "https://boss974829.github.io/protein-under-100/";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(238, 243, 222));
        getWindow().setNavigationBarColor(Color.rgb(238, 243, 222));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);

        FrameLayout root = new FrameLayout(this);
        webView = new WebView(this);
        webView.setBackgroundColor(Color.rgb(238, 243, 222));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri uri = request.getUrl();
                if ("boss974829.github.io".equalsIgnoreCase(uri.getHost())) {
                    return false;
                }
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                } catch (Exception ignored) {
                    // Keep the app open if this device has no browser for the link.
                }
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request,
                                       android.webkit.WebResourceError error) {
                if (request.isForMainFrame()) {
                    view.loadDataWithBaseURL(null,
                            "<meta name='viewport' content='width=device-width, initial-scale=1'>"
                                    + "<body style='font:16px sans-serif;background:#eef3de;color:#1c3025;"
                                    + "padding:32px'><h2>You're offline</h2><p>Connect to the internet "
                                    + "to open Protein Under 100.</p><button onclick=\"location.href='"
                                    + SITE_URL + "'\" "
                                    + "style='padding:12px 18px;border:0;border-radius:12px;background:#285f43;"
                                    + "color:white'>Try again</button></body>",
                            "text/html", "UTF-8", null);
                }
            }
        });
        root.addView(webView);

        TextView progress = new TextView(this);
        progress.setText("Loading Protein Under 100…");
        progress.setTextColor(Color.rgb(40, 95, 67));
        progress.setTextSize(14);
        progress.setPadding(24, 14, 24, 14);
        progress.setBackgroundColor(Color.rgb(255, 255, 250));
        FrameLayout.LayoutParams progressParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        progressParams.gravity = android.view.Gravity.CENTER;
        root.addView(progress, progressParams);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progress.setVisibility(newProgress >= 100 ? View.GONE : View.VISIBLE);
            }
        });

        setContentView(root);
        if (savedInstanceState == null) {
            webView.loadUrl(SITE_URL);
        } else {
            webView.restoreState(savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (webView != null) webView.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }
}
