package com.mark.view.markretrofitdemotwo.bean;

/**
 * 项目名称：MarkRetrofitDemo
 * 类描述：
 * Created by mark on 2018/6/5 17:09
 * 修改人：mark
 * 修改时间：2018/6/5 17:09
 * 修改备注：
 */
public class MeiNvBean {

    /**
     * createdAt : 2017-11-23T08:32:29.546Z
     * publishedAt : 2017-11-24T11:08:03.624Z
     * type : 美图
     * url : http://7xi8d6.com1.z0.glb.clouddn.com/20171123083218_5mhRLg_sakura.gun_23_11_2017_8_32_9_312.jpeg
     */

    private String createdAt;
    private String publishedAt;
    private String type;
    private String url;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MeiNvBean{" +
                "createdAt='" + createdAt + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
