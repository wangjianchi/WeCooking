package com.cdcompany.wecooking.base;

/**
 * Created by wukewei on 16/6/1.
 */
public interface ILoadingView extends IView {
    void showLoading();
    void showContent();
    void showNotData();
    void showError(String msg);
}
