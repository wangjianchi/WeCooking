package com.cdcompany.wecooking.ui.main.fragment.find;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cdcompany.wecooking.R;
import com.cdcompany.wecooking.adapter.FindSectionAdapter;
import com.cdcompany.wecooking.base.BaseFragment;
import com.cdcompany.wecooking.model.FindSection;
import com.cdcompany.wecooking.reject.component.AppComponent;
import com.cdcompany.wecooking.reject.component.DaggerFragmentComponent;
import com.cdcompany.wecooking.reject.module.FragmentModule;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment<FindPresenter> implements FindContract.View {
    @Bind(R.id.rv_find_news_list)
    RecyclerView rv_find_news_list;
    private FindSectionAdapter findSectionAdapter;
    private  List<FindSection> data = new ArrayList<FindSection>();

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
        findSectionAdapter = new FindSectionAdapter(R.layout.list_item_section_find,R.layout.list_item_section_header_find,data);
        rv_find_news_list.setAdapter(findSectionAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv_find_news_list.setLayoutManager(linearLayoutManager);
        mPresenter.getListData();
    }

    @Override
    public void addLoadMoreData(List<FindSection> list) {
        findSectionAdapter.addData(list);
    }

    @Override
    public void addRefreshData(List<FindSection> list) {
        findSectionAdapter.addData(list);
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
