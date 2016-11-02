package com.cdcompany.wecooking.model;

import java.util.List;

/**
 * Created by cd14 on 2016/11/2.
 */

public class ListObjectNews {

    /**
     * stat : 1
     */

    private String stat;
    private List<ObjectNews> data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<ObjectNews> getData() {
        return data;
    }

    public void setData(List<ObjectNews> data) {
        this.data = data;
    }
}
