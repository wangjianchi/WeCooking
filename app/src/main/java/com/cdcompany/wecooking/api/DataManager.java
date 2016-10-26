package com.cdcompany.wecooking.api;

import com.cdcompany.common_lib.rx.RxResultHelper;
import com.cdcompany.common_lib.rx.SchedulersCompat;
import com.cdcompany.wecooking.api.api.CookApi;
import com.cdcompany.wecooking.model.ListObjectWxHot;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by cd14 on 2016/10/25.
 */

public class DataManager {
    private Retrofit mRetrofit;
    public static final String WX_HOT_KEY = "af5bbfacad8585e0287adadab7d0120b";
    public static final int PAGE_SIZE = 20;

    @Inject
    public DataManager(Retrofit retrofit){
        this.mRetrofit = retrofit;
    }
    public Observable<ListObjectWxHot> getWxHot(int pno){
        CookApi mCookApi = mRetrofit.create(CookApi.class);
        return mCookApi.getWxHot(pno,PAGE_SIZE,WX_HOT_KEY)
                .compose(RxResultHelper.<ListObjectWxHot>handleResult())
                .compose(SchedulersCompat.<ListObjectWxHot>applyIoSchedulers())
                .doOnNext(new Action1<ListObjectWxHot>() {
                    @Override
                    public void call(ListObjectWxHot listObjectWxHot) {

                    }
                });
    }
}
