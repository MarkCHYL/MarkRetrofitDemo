package com.mark.view.markretrofitdemotwo.bean;

/**
 * 项目名称：MarkRetrofitDemo
 * 类描述：创建应用
 * Created by mark on 2018/6/6 14:22
 * 修改人：mark
 * 修改时间：2018/6/6 14:22
 * 修改备注：
 */
public class CreateAppBean {
    /**
     * appId : com.chat.peakchao
     * appkey : 00d91e8e0cca2b76f515926a36db68f5
     */

    private String appId;
    private String appkey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    @Override
    public String toString() {
        return "CreateAppBean{" +
                "appId='" + appId + '\'' +
                ", appkey='" + appkey + '\'' +
                '}';
    }
}
