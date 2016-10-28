package com.cdcompany.wecooking.ui.main.fragment.find;


import android.support.v4.app.Fragment;

import com.cdcompany.wecooking.R;
import com.cdcompany.wecooking.base.BaseFragment;
import com.cdcompany.wecooking.reject.component.AppComponent;
import com.cdcompany.wecooking.reject.component.DaggerFragmentComponent;
import com.cdcompany.wecooking.reject.module.FragmentModule;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment<FindPresenter> {

    @Override
    protected void setupActivityComponent(AppComponent appComponent, FragmentModule fragmentModule) {
        DaggerFragmentComponent.builder()
                .appComponent(appComponent)
                .fragmentModule(fragmentModule)
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initEventAndData() {
        initToolBar("小报","即刻","");

    }

}
