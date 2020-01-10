package com.example.imechatron;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class ScholarshipFragment extends Fragment {
    private WebView mWebView;
    private int count;
    private ProgressBar progressbar;
    private SwipeRefreshLayout mySwipeRlayout;
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scholarships, container, false);



        progressbar=(ProgressBar)view.findViewById(R.id.prb);
        mWebView = view.findViewById(R.id.web_view);
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
                mySwipeRlayout.setRefreshing(false);
            }

        });
        mWebView.canGoBack();
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_BACK
                && keyEvent.getAction() == MotionEvent.ACTION_UP
                && mWebView.canGoBack()){
                    mWebView.goBack();
                    return true;
                }

            return false;}
        });

        mWebView.loadUrl("https://worldscholarshipforum.com");


        mySwipeRlayout =(SwipeRefreshLayout)view.findViewById(R.id.swipeContainer);
            mySwipeRlayout.setOnRefreshListener(
                    new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            mWebView.reload();
                        }
                    }
            );
        return view;

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

