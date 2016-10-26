package com.cdcompany.wecooking.reject.module;

import com.cdcompany.wecooking.App;
import com.cdcompany.wecooking.reject.ContextLife;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cd14 on 2016/10/26.
 */
@Module
public class AppModule {
    private App application;

    public AppModule(App application){
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    public App provideApp(){return application;}



}
