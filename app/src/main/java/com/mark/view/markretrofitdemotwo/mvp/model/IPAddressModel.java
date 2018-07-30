package com.mark.view.markretrofitdemotwo.mvp.model;


import android.util.Log;

import com.mark.view.markretrofitdemotwo.mvp.model.bean.IPAddressResultBean;

/**
 * $desc$
 * 业务具体处理，包括负责存储、检索、操纵数据等
 * @Author mark 2285581945@qq.com
 * @Date 2018/7/30
 */
public class IPAddressModel {
    private IPAddressResultBean ipAddressResultBean;


    public void loadDataSuccess(IPAddressResultBean ipAddressResultBean) {
        this.ipAddressResultBean = ipAddressResultBean;
    }

    public void loadDataFailure(Throwable t) {
        Log.e("exception",t.toString());
    }
}
