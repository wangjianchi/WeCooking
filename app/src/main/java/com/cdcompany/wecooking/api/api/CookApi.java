package com.cdcompany.wecooking.api.api;

import com.cdcompany.common_lib.rx.ApiResponse;
import com.cdcompany.wecooking.model.ListObjectWxHot;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cd14 on 2016/10/25.
 */

public interface CookApi {

    @GET("/weixin/query")
    Observable<ApiResponse<ListObjectWxHot>> getWxHot(@Query("pno") int page,@Query("ps") int size,@Query("key") String key);

}
