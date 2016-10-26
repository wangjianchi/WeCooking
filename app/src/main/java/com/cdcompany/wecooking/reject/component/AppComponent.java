package com.cdcompany.wecooking.reject.component;

import com.cdcompany.wecooking.App;
import com.cdcompany.wecooking.api.DataManager;
import com.cdcompany.wecooking.reject.ContextLife;
import com.cdcompany.wecooking.reject.module.AppModule;
import com.cdcompany.wecooking.reject.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cd14 on 2016/10/25.
 */
@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface AppComponent {
    @ContextLife("Application")
    App getContext();
    DataManager getDataManager();
}
