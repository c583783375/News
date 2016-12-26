package sprint.www.news.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import butterknife.BindView;
import sprint.www.news.R;
import sprint.www.news.base.BaseActivity;

public class WebActivity extends BaseActivity {

    @BindView(R.id.web_view)
    WebView mWebView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.pb)
    ProgressBar pb;
    public final static String URL = "url";
    public final static String TITLE = "title";
    private String url;
    private String title;
    
    public static void runActivity(Context context,String title,String url)
    {
        Intent intent = new Intent(context,WebActivity.class);
        intent.putExtra(TITLE,title);
        intent.putExtra(URL,url);
        context.startActivity(intent);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        //初始化toolbar
        initToolbar(mToolbar,title,true);

        initWebView();


    }

    private void initWebView() {
        pb.setMax(100);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                pb.setProgress(newProgress);
                if (newProgress >= 100) {
                    pb.setVisibility(View.GONE);
                }
            }
        });
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.loadUrl(url);
    }

    @Override
    protected void initData() {
        url = getIntent().getStringExtra(URL);
        title = getIntent().getStringExtra(TITLE);
    }
}
