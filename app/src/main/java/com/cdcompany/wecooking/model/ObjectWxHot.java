package com.cdcompany.wecooking.model;

/**
 * Created by cd14 on 2016/10/25.
 */

public class ObjectWxHot {

    /**
     * firstImg : http://zxpic.gtimg.com/infonew/0/wechat_pics_-8774101.jpg/640
     * id : wechat_20151202064749
     * source : 果果帮
     * title : 笑死了,哈哈小伙子你很有前途
     * url : http://v.juhe.cn/weixin/redirect?wid=wechat_20151202064749
     * mark :
     */

    private String firstImg;
    private String id;
    private String source;
    private String title;
    private String url;
    private String mark;

    public String getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
