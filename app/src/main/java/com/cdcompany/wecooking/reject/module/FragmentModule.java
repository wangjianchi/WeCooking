package com.cdcompany.wecooking.reject.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.cdcompany.wecooking.reject.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wukewei on 16/7/19.
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
