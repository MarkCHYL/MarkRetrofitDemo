package com.mark.view.markretrofitdemotwo.mvp.view;

import com.mark.view.markretrofitdemotwo.mvp.model.bean.BaseResultBean;
import com.mark.view.markretrofitdemotwo.mvp.model.bean.IPAddressResultBean;

import retrofit2.Call;

/**
 * $desc$ 处理业务需要哪些方法
 *
 * @Author mark 2285581945@qq.com
 * @Date 2018/7/30
 */
public interface IPAddressView {
    void setIp(IPAddressResultBean resultBean);

    void onFailure(Call<BaseResultBean<IPAddressResultBean>> call);
}
