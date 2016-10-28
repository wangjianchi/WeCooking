package com.cdcompany.wecooking.ui.main.fragment.find;

import android.app.Activity;

import com.cdcompany.wecooking.api.DataManager;
import com.cdcompany.wecooking.base.BasePresenter;

/**
 * Created by cd14 on 2016/10/28.
 */

public class FindPresenter extends BasePresenter<FindContract.View> implements FindContract.Presenter {

    public FindPresenter(DataManager dataManager, Activity activity) {
        super(dataManager, activity);
    }
}
