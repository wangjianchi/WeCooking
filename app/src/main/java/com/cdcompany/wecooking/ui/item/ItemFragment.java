package com.cdcompany.wecooking.ui.item;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdcompany.wecooking.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment {
//    @Bind(R.id.webview)
//    WebView webView;

    View view;

    public ItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this,view);
//        webView.loadUrl("http://sports.sina.com.cn/");
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return false;
//            }
//        });
        return view;
    }

}
