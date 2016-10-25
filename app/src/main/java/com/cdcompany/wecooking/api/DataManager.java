package com.cdcompany.wecooking.api;

import com.cdcompany.common_lib.rx.RxResultHelper;
import com.cdcompany.wecooking.model.ListObjectWxHot;

import rx.Observable;

/**
 * Created by cd14 on 2016/10/25.
 */

public class DataManager {
    private CookApi mCookApi;
    public static final String WX_HOT_KEY = "";
    public Observable<ListObjectWxHot> getWxHot(final int pno, int ps){
        return mCookApi.getWxHot(pno,ps,WX_HOT_KEY)
                .compose(RxResultHelper.<ListObjectWxHot>handleResult());
    }
}
