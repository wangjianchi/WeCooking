package com.cdcompany.wecooking.adapter;

import android.widget.ImageView;

import com.cdcompany.wecooking.R;
import com.cdcompany.wecooking.model.FindSection;
import com.cdcompany.wecooking.model.ObjectWxHot;
import com.cdcompany.wecooking.utils.GlideUtils;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by wanglunkui on 06/11/2016.
 */

public class MsgSectionAdapter extends BaseSectionQuickAdapter<FindSection,BaseViewHolder> {

    public MsgSectionAdapter(int layoutResId, int sectionHeadResId, List<FindSection> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder baseViewHolder, FindSection findSection) {
        baseViewHolder.setText(R.id.tv_section_header_find,findSection.header);

    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, FindSection findSection) {
        ObjectWxHot wxHot = (ObjectWxHot) findSection.t;
        baseViewHolder.setText(R.id.tv_section_find_name,wxHot.getSource())
                .setText(R.id.tv_find_content,wxHot.getTitle());
        GlideUtils.showImage(wxHot.getFirstImg(),(ImageView) baseViewHolder.getView(R.id.iv_image_find));

    }
}