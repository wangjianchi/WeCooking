package com.cdcompany.wecooking;

import android.app.Application;

import com.cdcompany.wecooking.reject.component.AppComponent;
import com.cdcompany.wecooking.reject.component.DaggerAppComponent;
import com.cdcompany.wecooking.reject.module.AppModule;
import com.cdcompany.wecooking.reject.module.NetModule;
import com.orhanobut.logger.Logger;

/**
 * Created by wukewei on 16/5/26.
 */
public class App extends Application {

    private static App appContext;
    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();
        Logger.init();

    }
    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static App getAppContext() {
        return appContext;
    }

}
