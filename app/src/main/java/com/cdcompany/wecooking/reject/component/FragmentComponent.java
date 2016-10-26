package com.cdcompany.wecooking.reject.component;

import android.app.Activity;
import com.cdcompany.wecooking.api.DataManager;
import com.cdcompany.wecooking.reject.PerFragment;
import com.cdcompany.wecooking.reject.module.FragmentModule;

import dagger.Component;

/**
 * Created by wukewei on 16/7/19.
 */
@PerFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    DataManager getDataManager();

    Activity getActivity();

}
