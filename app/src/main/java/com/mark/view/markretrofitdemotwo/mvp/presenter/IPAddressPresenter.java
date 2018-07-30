package com.mark.view.markretrofitdemotwo.mvp.presenter;

import com.mark.view.markretrofitdemotwo.api.ApiService;
import com.mark.view.markretrofitdemotwo.api.UrlsControl;
import com.mark.view.markretrofitdemotwo.mvp.model.IPAddressModel;
import com.mark.view.markretrofitdemotwo.mvp.model.bean.BaseResultBean;
import com.mark.view.markretrofitdemotwo.mvp.model.bean.IPAddressResultBean;
import com.mark.view.markretrofitdemotwo.mvp.view.IPAddressView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * $desc$
 *
 * @Author mark 2285581945@qq.com
 * @Date 2018/7/30
 */
public class IPAddressPresenter {

    private IPAddressModel addressModel;
    private IPAddressView addressView;

    public IPAddressPresenter(IPAddressView ipAddressView){
        this.addressView = ipAddressView;
        addressModel = new IPAddressModel();
    }

    public void loadIpAddress(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlsControl.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<BaseResultBean<IPAddressResultBean>> call = apiService.getIpAdress("122.224.18.103");

        call.enqueue(new Callback<BaseResultBean<IPAddressResultBean>>() {
            @Override
            public void onResponse(Call<BaseResultBean<IPAddressResultBean>> call,
                                   Response<BaseResultBean<IPAddressResultBean>> response) {
                IPAddressResultBean bean = response.body().getResult();
                addressView.setIp(bean);
            }

            @Override
            public void onFailure(Call<BaseResultBean<IPAddressResultBean>> call, Throwable t) {
                addressView.onFailure(call);
               loadFailure(t);
            }
        });
    }

    public void loadFailure(Throwable t){
        addressModel.loadDataFailure(t);
    }
}
