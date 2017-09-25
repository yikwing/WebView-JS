# webview和js互相调用

标签（空格分隔）： android kotlin webview

---

## js调用webview
* MainActivity.kt
```kotlin
val settings = webview.settings
//开启缩放
settings.setSupportZoom(true)
//使用js
settings.javaScriptEnabled = true;

webview.webChromeClient = WebChromeClient()
webview.webViewClient = WebViewClient()

//加载本地网页
webview.loadUrl("file:///android_asset/index.html")

//传参js
webview.addJavascriptInterface(LoadJS(this), "myJs")
```
* LoadJs.kt
```kotlin
class LoadJS(private val context: Context) {

    @JavascriptInterface
    fun MyToast(cc: String) {
        Toast.makeText(context, "我来自网页调用: " + cc,                Toast.LENGTH_SHORT).show()
    }
}
```
* index.html
```html
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>测试</title>
    <script>
    
    <!--js调用webview-->
    function clickq(){
    <!--获取输入框的值-->
        var cc = document.getElementById("content").value;
            <!--调用公开的方法-->
            myJs.MyToast(cc);
    }

    <!--webview调用js-->
    function showInfoFromJava(msg){
        alert("来自客户端的信息："+msg);
    }

    </script>
</head>
<body>
<input value="点击输入" id="content"/>
<input type="button" value="按钮" onclick="clickq()" id="button"/>

</body>
</html>
```

## webview调用js
* MainAvtivity.kt
```kotlin
btn_click.setOnClickListener {

    val msg = et_text.text.toString()

    webview.loadUrl("javascript:showInfoFromJava('$msg')");

}
```

* index.html
```html
<!--webview调用js-->
function showInfoFromJava(msg){
    alert("来自客户端的信息："+msg);
}
```


<img src="https://raw.githubusercontent.com/yikwing/ljkplayer_demo/master/image/qrcode.gif" width="600" height="500">