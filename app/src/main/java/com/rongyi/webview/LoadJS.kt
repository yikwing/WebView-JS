package com.rongyi.webview

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class LoadJS(private val context: Context) {

    @JavascriptInterface
    fun MyToast(cc: String) {
        Toast.makeText(context, "我来自网页调用: " + cc, Toast.LENGTH_SHORT).show()
    }
}