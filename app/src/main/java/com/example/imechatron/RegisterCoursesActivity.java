package com.example.imechatron;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class RegisterCoursesActivity extends AppCompatActivity {
    private WebView mWebView;

    private int count;
    private ProgressBar progressbar;
    private SwipeRefreshLayout mySwipeRlayout;
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_courses);


        progressbar=(ProgressBar)findViewById(R.id.prb2);
        progressbar.getProgressDrawable().setColorFilter(
                Color.BLUE, PorterDuff.Mode.SRC_IN
        );
        getSupportActionBar().setTitle("Course Registration");

        mWebView = findViewById(R.id.web_view2);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://portal.futo.edu.ng");
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressbar.setVisibility(View.VISIBLE);



            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                progressbar.setVisibility(View.GONE);

                mySwipeRlayout.setRefreshing(false);



            }

        });
        mWebView.canGoBack();
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == android.view.KeyEvent.KEYCODE_BACK
                        && keyEvent.getAction() == MotionEvent.ACTION_UP
                        && mWebView.canGoBack()){
                    mWebView.goBack();
                    return true;
                }

                return false;}
        });

        mySwipeRlayout =(SwipeRefreshLayout)findViewById(R.id.swipeContainer2);
        mySwipeRlayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        mWebView.reload();
                     }


                }


                );


    }


    @Override
    public void onStop() {
        super.onStop();
        mySwipeRlayout.getViewTreeObserver().removeOnScrollChangedListener(mOnScrollChangedListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        mySwipeRlayout.getViewTreeObserver().addOnScrollChangedListener(mOnScrollChangedListener =
                new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        if (mWebView.getScrollY() == 0){
                            mySwipeRlayout.setEnabled(true);
                            }
                        else
                            mySwipeRlayout.setEnabled(false);

                    }
                });


    }



}



/*    @Override
    public void onPause() {

        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("webViewUrl", mWebView.getUrl());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String webViewUrl = savedInstanceState.getString("webViewUrl");
        Toast.makeText(this, webViewUrl, Toast.LENGTH_SHORT).show();
        mWebView.loadUrl(webViewUrl);
    }



    public class myWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();


        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressbar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressbar.setVisibility(View.GONE);

        }
    }
          mWebView = findViewById(R.id.web_view2);
        mWebView.getSettings().setLoadsImagesAutomatically(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressbar.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressbar.setVisibility(View.GONE);
            }

        });
        mWebView.canGoBack();
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == android.view.KeyEvent.KEYCODE_BACK
                        && keyEvent.getAction() == MotionEvent.ACTION_UP
                        && mWebView.canGoBack()){
                    mWebView.goBack();
                    return true;
                }

                return false;}
        });

        mWebView.loadUrl("https://portal.futo.edu.ng/");


        mySwipeRlayout =(SwipeRefreshLayout)findViewById(R.id.swipeContainer2);
        mySwipeRlayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        mWebView.reload();
                    }
                }
        );


    }


    @Override
    public void onStop() {
        super.onStop();
        mySwipeRlayout.getViewTreeObserver().removeOnScrollChangedListener(mOnScrollChangedListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        mySwipeRlayout.getViewTreeObserver().addOnScrollChangedListener(mOnScrollChangedListener =
                new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        if (mWebView.getScrollY() == 0){
                            mySwipeRlayout.setEnabled(true);
                            mWebView.reload();}
                        else
                            mySwipeRlayout.setEnabled(false);
                    }
                });
    }

    public class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();


        }
    }*/






