package com.cdcompany.wecooking.ui.main;

import com.cdcompany.wecooking.base.ILoadingView;
import com.cdcompany.wecooking.base.IPresenter;
import com.cdcompany.wecooking.model.ListObjectWxHot;

/**
 * Created by cd14 on 2016/10/26.
 */

public interface MainContract {
    interface View extends ILoadingView{
        void addLoadMoreData(ListObjectWxHot data);
        void addRefreshData(ListObjectWxHot data);
    }
    interface Presenter extends IPresenter<View>{
        void getListData();
    }
}
