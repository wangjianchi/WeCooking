package com.cdcompany.wecooking.ui.main.fragment.message;

import android.app.Activity;

import com.cdcompany.common_lib.rx.RxSubscriber;
import com.cdcompany.wecooking.base.BasePresenter;
import com.cdcompany.wecooking.model.FindSection;
import com.cdcompany.wecooking.model.ListObjectNews;
import com.cdcompany.wecooking.model.ListObjectWxHot;
import com.cdcompany.wecooking.model.ObjectWxHot;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by wanglunkui on 06/11/2016.
 */

public class MsgPresenter extends BasePresenter<MsgContract.View> implements MsgContract.Presenter{
    @Inject
    public MsgPresenter(Activity activity) {
        super(activity);
    }

    protected  int pno = 1;

    protected void replacePn() {
        pno = 1;
    }

    protected void addPn(){
        pno ++;
    }

    private boolean isRefresh() {
        return pno == 1;
    }

    /**
     * 获取列表
     * rxjava:创建订阅关系subscription，
     */

    @Override
    public void getListData() {
        mView.showLoading();
        Subscription subscription = dataManager.getWxHot(pno)
                .subscribe(new RxSubscriber<ListObjectWxHot>() {
                    @Override
                    public void _noNext(ListObjectWxHot listObjectWxHot) {
                        mView.showContent();
//                        if (isRefresh()){
                            if (listObjectWxHot.getList().size() == 0) mView.showNotData();
                            mView.addRefreshData(getSectionData(listObjectWxHot.getList()));
//                        }else {
//                            mView.addLoadMoreData(getSectionData(listObjectWxHot.getList()));
//                        }
                    }

                    @Override
                    public void _onError(String msg) {
//                        if (isRefresh()){
                            mView.showError(msg);
//                        }
                    }
                });

        addSubscribe(subscription);
    }

    @Override
    public void getNewData() {
        Subscription subscription1 = dataManager.getNews()
                .subscribe(new RxSubscriber<ListObjectNews>() {
                    @Override
                    public void _noNext(ListObjectNews listObjectNews) {
                        mView.addNewsData(listObjectNews.getData());
                    }

                    @Override
                    public void _onError(String msg) {
                        mView.showError(msg);
                    }
                });
        addSubscribe(subscription1);
    }

    public List<FindSection> getSectionData(List<ObjectWxHot> wxlist){
        List<FindSection> sections = new ArrayList<FindSection>();
        for (int i = 0; i < wxlist.size() ; i++) {
            if (i%5 == 0){
                sections.add(new FindSection(true,"最新主题"));
            }
            sections.add(new FindSection(wxlist.get(i)));
        }
        return sections;
    }
}


