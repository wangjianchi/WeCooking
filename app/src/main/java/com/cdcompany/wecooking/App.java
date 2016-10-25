package com.cdcompany.wecooking;

import android.app.Application;

import com.cdcompany.common_lib.Ext;
import com.cdcompany.common_lib.network.Network;
import com.cdcompany.common_lib.utils.ViewUtils;

/**
 * Created by wukewei on 16/5/26.
 */
public class App extends Application {

    private static App appContext;


    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        initExtension();
    }

    private void initExtension() {
        Ext.init(this, new ExtImpl());
    }


    public static final class ExtImpl extends Ext {

        @Override
        public String getCurOpenId() {
            return null;
        }

        @Override
        public String getDeviceInfo() {
            return null;
        }

        @Override
        public String getPackageNameForResource() {
            return "com.wkw.hot";
        }

        @Override
        public int getScreenHeight() {
            return ViewUtils.getScreenHeight();
        }

        @Override
        public int getScreenWidth() {
            return ViewUtils.getScreenWidth();
        }

        @Override
        public boolean isAvailable() {
            return Network.isAvailable();
        }

        @Override
        public boolean isWap() {
            return Network.isWap();
        }

        @Override
        public boolean isMobile() {
            return Network.isMobile();
        }

        @Override
        public boolean is2G() {
            return Network.is2G();
        }

        @Override
        public boolean is3G() {
            return Network.is3G();
        }

        @Override
        public boolean isWifi() {
            return Network.isWifi();
        }

        @Override
        public boolean isEthernet() {
            return Network.isEthernet();
        }
    }

    public static App getAppContext() {
        return appContext;
    }

}
