package com.cdcompany.wecooking.ui.main;

import com.cdcompany.wecooking.R;
import com.cdcompany.wecooking.base.BaseActivity;
import com.cdcompany.wecooking.model.ListObjectWxHot;
import com.cdcompany.wecooking.reject.component.AppComponent;
import com.cdcompany.wecooking.reject.component.DaggerActivityComponent;
import com.cdcompany.wecooking.reject.module.ActivityModule;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{

    @Override
    protected void setupActivityComponent(AppComponent appComponent, ActivityModule activityModule) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(activityModule)
                .build()
                .inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getListData();

    }

    @Override
    public void addLoadMoreData(ListObjectWxHot data) {

    }

    @Override
    public void addRefreshData(ListObjectWxHot data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showNotData() {

    }

    @Override
    public void showError(String msg) {

    }
}
