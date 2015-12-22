package sunger.net.org.wechatwebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.net.URL;

import sunger.net.org.library.WeChatWebView;

public class MainActivity extends AppCompatActivity {
    private String urlString = "http://weixin.qq.com/";
    private WeChatWebView weChatWebView;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weChatWebView = (WeChatWebView) findViewById(R.id.wechat_webview);
        tv = (TextView) weChatWebView.findViewById(R.id.textView);
        try {
            URL url = new URL(urlString);
            tv.setText("网页由" + url.getAuthority() + "提供");
        } catch (Exception e) {
        }
        WebView webView = weChatWebView.getWebView();
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(urlString);
    }
}
