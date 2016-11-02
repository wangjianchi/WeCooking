package com.cdcompany.wecooking.ui.main;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.cdcompany.wecooking.R;
import com.cdcompany.wecooking.base.BaseActivity;
import com.cdcompany.wecooking.model.ListObjectWxHot;
import com.cdcompany.wecooking.reject.component.AppComponent;
import com.cdcompany.wecooking.reject.component.DaggerActivityComponent;
import com.cdcompany.wecooking.reject.module.ActivityModule;
import com.cdcompany.wecooking.ui.main.fragment.find.FindFragment;
import com.cdcompany.wecooking.ui.main.fragment.mine.MineFragment;
import com.cdcompany.wecooking.ui.main.fragment.message.MsgFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{
    @Bind(R.id.tab_home) PagerBottomTabLayout bottomTabLayout;
    List<Fragment> mFragments;
    Controller mController;

    @Override
    protected void setupActivityComponent(AppComponent appComponent, ActivityModule activityModule) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(activityModule)
                .build()
                .inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
//        mPresenter.getListData();
        int[] testColors = {0xFF5B4947,0xFF5B4947,0xFF5B4947,0xFFF57C00,0xFFF57C00};
        mController = bottomTabLayout.builder()
                .addTabItem(android.R.drawable.ic_menu_add,"发现",testColors[0])
                .addTabItem(android.R.drawable.ic_menu_send,"消息",testColors[1])
                .addTabItem(android.R.drawable.ic_menu_info_details,"我的",testColors[2])
                .build();

        initFragments();

        mController.addTabItemClickListener(listener);

    }



    @Override
    public void addLoadMoreData(ListObjectWxHot data) {

    }

    @Override
    public void addRefreshData(ListObjectWxHot data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showNotData() {

    }

    @Override
    public void showError(String msg) {

    }

    /**
     * 初始化fragment列表
     */
    public void initFragments(){
        mFragments = new ArrayList<>();
        mFragments.add(new FindFragment());
        mFragments.add(new MsgFragment());
        mFragments.add(new MineFragment());
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout,mFragments.get(0));
        transaction.commit();
    }

    OnTabItemSelectListener listener = new OnTabItemSelectListener() {
        @Override
        public void onSelected(int index, Object tag) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout,mFragments.get(index));
//            transaction.show(mFragments.get(index));
            transaction.commit();
        }

        @Override
        public void onRepeatClick(int index, Object tag) {

        }
    };
}
