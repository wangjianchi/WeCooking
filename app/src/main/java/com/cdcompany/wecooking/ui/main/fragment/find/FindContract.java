package com.cdcompany.wecooking.ui.main.fragment.find;

import com.cdcompany.wecooking.base.ILoadingView;
import com.cdcompany.wecooking.base.IPresenter;
import com.cdcompany.wecooking.model.FindSection;
import com.cdcompany.wecooking.model.ObjectNews;

import java.util.List;

/**
 * Created by cd14 on 2016/10/28.
 */

public interface FindContract {
    interface View extends ILoadingView{
        void addLoadMoreData( List<FindSection> list);
        void addRefreshData( List<FindSection> list);
        void addNewsData(List<ObjectNews> list);
    }
    interface Presenter extends IPresenter<View>{
        void getListData();
        void getNewData();
    }
}
