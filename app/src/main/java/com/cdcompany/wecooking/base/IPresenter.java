package com.cdcompany.wecooking.base;

/**
 * Created by wukewei on 16/5/26.
 */
public interface IPresenter<T extends IView> {
    void attachView(T view);
    void detachView();
}
