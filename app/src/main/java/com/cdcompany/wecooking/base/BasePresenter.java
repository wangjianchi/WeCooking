package com.cdcompany.wecooking.base;

import android.app.Activity;

import com.cdcompany.wecooking.api.DataManager;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by wukewei on 16/5/26.
 */
public abstract class BasePresenter<T extends IView> implements IPresenter<T> {

    protected Activity mActivity;
    protected T mView;
    protected CompositeSubscription mCompositeSubscription;
    protected DataManager dataManager;

    public BasePresenter(DataManager dataManager, Activity activity) {
        this.dataManager = dataManager;
        this.mActivity = activity;
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }



    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
