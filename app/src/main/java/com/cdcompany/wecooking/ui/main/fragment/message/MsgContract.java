package com.cdcompany.wecooking.ui.main.fragment.message;

import com.cdcompany.wecooking.base.ILoadingView;
import com.cdcompany.wecooking.base.IPresenter;
import com.cdcompany.wecooking.model.FindSection;
import com.cdcompany.wecooking.model.ObjectNews;
import com.cdcompany.wecooking.ui.main.fragment.find.FindContract;

import java.util.List;

/**
 * Created by wanglunkui on 06/11/2016.
 */

public interface MsgContract {
    interface View extends ILoadingView {
        void addLoadMoreData( List<FindSection> list);
        void addRefreshData( List<FindSection> list);
        void addNewsData(List<ObjectNews> list);
    }
    interface Presenter extends IPresenter<MsgContract.View> {
        void getListData();
        void getNewData();
    }
}
