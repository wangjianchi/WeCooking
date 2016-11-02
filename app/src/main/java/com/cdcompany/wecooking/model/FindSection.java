package com.cdcompany.wecooking.model;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by cd14 on 2016/10/31.
 */

public class FindSection extends SectionEntity<ObjectWxHot> {
    public FindSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public FindSection(ObjectWxHot objectWxHot) {
        super(objectWxHot);
    }
}
