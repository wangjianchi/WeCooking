package com.cdcompany.wecooking.ui.main.fragment.find;


import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.cdcompany.wecooking.base.BaseFragment;
import com.cdcompany.wecooking.model.FindSection;
import com.cdcompany.wecooking.model.ObjectNews;
import com.cdcompany.wecooking.reject.component.AppComponent;
import com.cdcompany.wecooking.reject.component.DaggerFragmentComponent;
import com.cdcompany.wecooking.reject.module.FragmentModule;
import com.cdcompany.wecooking.ui.item.TabActivity;
import com.cdcompany.wecooking.utils.GlideUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static com.cdcompany.wecooking.R.id.imageSwitcher_like01;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment<FindPresenter> implements FindContract.View {
    @Bind(R.id.rv_find_news_list)
    RecyclerView rv_find_news_list;
    @Bind(R.id.swipe_layout_find)
    SwipeRefreshLayout swipe_layout_find;
    ImageSwitcher imageSwitcher[] = new ImageSwitcher[3];
    private FindSectionAdapter findSectionAdapter;
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
        return R.layout.fragment_find;
    }

    @Override
    protected void initEventAndData() {
        initToolBar("小报","","",NULL_RESOURCE,R.drawable.home_title,R.drawable.ic_search_black_24dp);
        findSectionAdapter = new FindSectionAdapter(R.layout.list_item_section_find,R.layout.list_item_section_header_find,data);

        findSectionAdapter.addHeaderView(getHeaderView());
        rv_find_news_list.setAdapter(findSectionAdapter);
        rv_find_news_list.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv_find_news_list.setLayoutManager(linearLayoutManager);
        findSectionAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.addPn();
                mPresenter.getListData();
            }
        });
        swipe_layout_find.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.replacePn();
                mPresenter.getListData();
            }
        });
        mPresenter.getListData();
        mPresenter.getNewData();
        rv_find_news_list.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                startActivity(new Intent(getActivity(), TabActivity.class));
            }
        });
    }

    /**
     * 列表头部
     * @return
     */
    private View getHeaderView(){
        View view = getActivity().getLayoutInflater().inflate(R.layout.layout_you_like, null);
        view.setLayoutParams(new DrawerLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imageSwitcher[0] = (ImageSwitcher)view.findViewById(imageSwitcher_like01);
        imageSwitcher[1]  = (ImageSwitcher)view.findViewById(R.id.imageSwitcher_like02);
        imageSwitcher[2]  = (ImageSwitcher)view.findViewById(R.id.imageSwitcher_like03);
        for (ImageSwitcher imageSwitcher_like:imageSwitcher) {
            imageSwitcher_like.setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT));//设置宽高
                    return imageView;
                }
            });
            imageSwitcher_like.setImageResource(R.drawable.ic_user_unselected);
        }
        Button btn_like_change = (Button)view.findViewById(R.id.btn_like_change);
        btn_like_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String urls[] = {listNews.get(list_num).getThumbnail_pic_s(),listNews.get(list_num).getThumbnail_pic_s02(),listNews.get(list_num).getThumbnail_pic_s03()};
                for (int i = 0; i < imageSwitcher.length; i++) {
                    Handler handler = new Handler();
                    final int finalI = i;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imageSwitcher[finalI].setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_top));
                            imageSwitcher[finalI].setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_bottom));
//                            imageSwitcher[finalI].setImageResource(R.drawable.placeholder);
                            GlideUtils.showImageSwitcher(urls[finalI],imageSwitcher[finalI]);
                        }
                    },100*i);
                }
               if (list_num < listNews.size()-1){
                   list_num ++;
               }else {
                   list_num = 0;
               }
            }
        });
        return view;
    }


    @Override
    public void addLoadMoreData(List<FindSection> list) {
        findSectionAdapter.addData(list);
    }

    @Override
    public void addRefreshData(List<FindSection> list) {
        findSectionAdapter.setNewData(list);
        swipe_layout_find.setRefreshing(false);
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
