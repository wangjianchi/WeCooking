package com.cdcompany.wecooking.reject.module;

import android.app.Activity;

import com.cdcompany.wecooking.reject.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wukewei on 16/7/19.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity() {
        return mActivity;
    }
}
