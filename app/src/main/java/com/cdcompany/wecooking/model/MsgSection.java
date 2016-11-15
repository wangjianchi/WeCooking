package com.cdcompany.wecooking.model;

import android.graphics.drawable.Drawable;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by wanglunkui on 08/11/2016.
 */

public class MsgSection extends SectionEntity<ObjectWxHot> {

    private User user;
    private String text;
    private Drawable[] photoSet;

    public MsgSection(User user,String text, Drawable[] photoSet, boolean isHeader, String header) {
        super(isHeader, header);
        this.user = user;
        this.text = text;
        this.photoSet = photoSet;
    }
}
