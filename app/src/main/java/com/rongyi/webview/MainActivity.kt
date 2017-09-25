package com.rongyi.webview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settings = webview.settings
        settings.setSupportZoom(true)
        settings.javaScriptEnabled = true;

        webview.webChromeClient = WebChromeClient()
        webview.webViewClient = WebViewClient()

        webview.loadUrl("file:///android_asset/index.html")

        webview.addJavascriptInterface(LoadJS(this), "myJs")

        btn_click.setOnClickListener {

            val msg = et_text.text.toString()

            webview.loadUrl("javascript:showInfoFromJava('$msg')");

        }

    }

}
