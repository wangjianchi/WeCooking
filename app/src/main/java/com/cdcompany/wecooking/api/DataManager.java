package com.cdcompany.wecooking.api;

import android.util.Log;

import com.cdcompany.common_lib.rx.RxResultHelper;
import com.cdcompany.common_lib.rx.SchedulersCompat;
import com.cdcompany.wecooking.api.api.CookApi;
import com.cdcompany.wecooking.model.ListObjectNews;
import com.cdcompany.wecooking.model.ListObjectWxHot;
import com.cdcompany.wecooking.utils.GsonUtils;
import com.orhanobut.logger.Logger;

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
    public static final String NEWS_KEY = "0e9c177c26873f1dfcf8bb0af9513ba8";
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
                        Logger.i( GsonUtils.toJsonString(listObjectWxHot));
                    }
                });
    }
    public Observable<ListObjectNews> getNews(){
        CookApi mCookApi = mRetrofit.create(CookApi.class);
        return mCookApi.getNews(NEWS_KEY)
                .compose(RxResultHelper.<ListObjectNews>handleResult())
                .compose(SchedulersCompat.<ListObjectNews>applyIoSchedulers())
                .doOnNext(new Action1<ListObjectNews>() {
                    @Override
                    public void call(ListObjectNews listObjectNews) {
                        Log.i("DataManager", "call: news "+ GsonUtils.toJsonString(listObjectNews));
                    }
                });
    }


}
