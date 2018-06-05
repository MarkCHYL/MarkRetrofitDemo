package com.mark.view.markretrofitdemotwo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称：MarkRetrofitDemo
 * 类描述：
 * Created by mark on 2018/6/5 14:33
 * 修改人：mark
 * 修改时间：2018/6/5 14:33
 * 修改备注：
 */
public class BaseRequest {

    // 第2部分：在创建Retrofit实例时通过.baseUrl()设置
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(UrlsControl.BASEURL)//设置网络请求的Url地址
            .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
            .build();
}
