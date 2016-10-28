package com.cdcompany.wecooking.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cdcompany.wecooking.App;
import com.cdcompany.wecooking.R;
import com.cdcompany.wecooking.reject.component.AppComponent;
import com.cdcompany.wecooking.reject.module.FragmentModule;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cd14 on 2016/10/28.
 */

public abstract class BaseFragment <T extends IPresenter> extends Fragment implements IView {
    @Inject
    protected T mPresenter;
    protected View mView;
    protected Activity mContext;

    @Override
    public void onAttach(Activity activity) {
        if (activity instanceof BaseActivity){
            mContext = activity;
        }
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(),null);
        setupActivityComponent(App.getAppComponent(),new FragmentModule(this));
        if (mPresenter != null) mPresenter.attachView(this);
        ButterKnife.bind(this, mView);
        initEventAndData();
        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }

    /**
     * 依赖注入的入口
     * @param appComponent appComponent
     */
    protected abstract void setupActivityComponent(AppComponent appComponent, FragmentModule fragmentModule);

    protected abstract int getLayoutId();
    protected abstract void initEventAndData();
    @Bind(R.id.tv_bar_left) TextView tv_bar_left;
    @Bind(R.id.tv_bar_right) TextView tv_bar_right;
    @Bind(R.id.tv_bar_title) TextView tv_bar_title;
    public void initToolBar(String rightText,String Title,String leftText){
        Toolbar toolbar = (Toolbar) mView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (!TextUtils.isEmpty(rightText)){
            tv_bar_left.setText(rightText);
            tv_bar_left.setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(Title)){
            tv_bar_title.setText(Title);
            tv_bar_title.setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(leftText)){
            tv_bar_right.setText(leftText);
            tv_bar_right.setVisibility(View.VISIBLE);
        }
    }
}
