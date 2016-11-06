package com.cdcompany.wecooking.ui.main.fragment.message;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.cdcompany.common_lib.widgets.DividerItemDecoration;
import com.cdcompany.wecooking.R;
import com.cdcompany.wecooking.adapter.FindSectionAdapter;
import com.cdcompany.wecooking.adapter.MsgSectionAdapter;
import com.cdcompany.wecooking.base.BaseFragment;
import com.cdcompany.wecooking.model.FindSection;
import com.cdcompany.wecooking.model.ObjectNews;
import com.cdcompany.wecooking.reject.component.AppComponent;
import com.cdcompany.wecooking.reject.component.DaggerFragmentComponent;
import com.cdcompany.wecooking.reject.module.FragmentModule;
import com.cdcompany.wecooking.utils.GlideUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static com.cdcompany.wecooking.R.id.imageSwitcher_like01;

/**
 * A simple {@link Fragment} subclass.
 */
public class MsgFragment extends BaseFragment<MsgPresenter> implements MsgContract.View {

    @Bind(R.id.rv_msg_news_list)
    RecyclerView rv_msg_news_list;
    @Bind(R.id.swipe_layout_msg)
    SwipeRefreshLayout swipe_layout_msg;
    ImageSwitcher imageSwitcher[] = new ImageSwitcher[3];
    private MsgSectionAdapter msgSectionAdapter;
    private List<FindSection> data = new ArrayList<FindSection>();
    private List<ObjectNews> listNews = new ArrayList<ObjectNews>();
    private int list_num = 0;

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
        return R.layout.fragment_msg;
    }

    @Override
    protected void initEventAndData() {
        initToolBar("","消息盒子","",NULL_RESOURCE,NULL_RESOURCE,R.drawable.ic_search_black_24dp);
        msgSectionAdapter = new MsgSectionAdapter(R.layout.list_item_section_find,R.layout.list_item_section_header_find,data);

        msgSectionAdapter.addHeaderView(getHeaderView());
        rv_msg_news_list.setAdapter(msgSectionAdapter);
        rv_msg_news_list.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv_msg_news_list.setLayoutManager(linearLayoutManager);
        msgSectionAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.addPn();
                mPresenter.getListData();
            }
        });
        swipe_layout_msg.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.replacePn();
                mPresenter.getListData();
            }
        });
        mPresenter.getListData();
        mPresenter.getNewData();
    }

    private View getHeaderView(){
        View view = getActivity().getLayoutInflater().inflate(R.layout.layout_recently_topic, null);
        view.setLayoutParams(new DrawerLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        return view;
    }


    @Override
    public void addLoadMoreData(List<FindSection> list) {
        msgSectionAdapter.addData(list);
    }

    @Override
    public void addRefreshData(List<FindSection> list) {
        msgSectionAdapter.setNewData(list);
        swipe_layout_msg.setRefreshing(false);
    }

    @Override
    public void addNewsData(List<ObjectNews> list) {
        listNews = list;
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
}
