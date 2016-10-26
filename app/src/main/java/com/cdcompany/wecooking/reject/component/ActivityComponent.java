package com.cdcompany.wecooking.reject.component;

import android.app.Activity;

import com.cdcompany.wecooking.api.DataManager;
import com.cdcompany.wecooking.reject.PerActivity;
import com.cdcompany.wecooking.reject.module.ActivityModule;
import com.cdcompany.wecooking.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by wukewei on 16/7/19.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    DataManager getDataManager();

    Activity getActivity();

    void inject(MainActivity mainActivity);

}
