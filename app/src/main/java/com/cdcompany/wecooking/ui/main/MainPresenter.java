package com.cdcompany.wecooking.ui.main;

import android.app.Activity;

import com.cdcompany.common_lib.rx.RxSubscriber;
import com.cdcompany.wecooking.api.DataManager;
import com.cdcompany.wecooking.base.BasePresenter;
import com.cdcompany.wecooking.model.ListObjectWxHot;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by cd14 on 2016/10/26.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    protected  int pno = 1;

    protected void replacePn() {
        pno = 1;
    }

    private boolean isRefresh() {
        return pno == 1;
    }

    @Inject
    public MainPresenter(DataManager dataManager, Activity activity) {
        super(dataManager, activity);
    }

    @Override
    public void getListData() {
        mView.showLoading();
        Subscription subscription = dataManager.getWxHot(pno)
                .subscribe(new RxSubscriber<ListObjectWxHot>() {
                    @Override
                    public void _noNext(ListObjectWxHot listObjectWxHot) {
                        mView.showContent();
                        if (isRefresh()){
                            if (listObjectWxHot.getList().size() == 0) mView.showNotData();
                            mView.addRefreshData(listObjectWxHot);
                        }else {
                            mView.addLoadMoreData(listObjectWxHot);
                        }
                    }

                    @Override
                    public void _onError(String msg) {
                        if (isRefresh()){
                            mView.showError(msg);
                        }
                    }
                });

        addSubscribe(subscription);
    }
}
