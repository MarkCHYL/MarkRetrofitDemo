package com.mark.view.markretrofitdemotwo.api;

import android.content.Context;

import android.util.Log;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 项目名称：MarkRetrofitDemo
 * 类描述：
 * Created by mark on 2018/6/5 14:33
 * 修改人：mark
 * 修改时间：2018/6/5 14:33
 * 修改备注：
 */
public class BaseRequest {
    private static BaseRequest mInstance;
    private Retrofit mRetrofit;
    private ApiService apiService;
    private OkHttpClient client;

    private BaseRequest() {
        /**
         * 我要逆天打log日志
         * 参考的博客：https://blog.csdn.net/Picasso_L/article/details/53200926
         * 个人建议看：https://blog.csdn.net/u011511368/article/details/51753315
         */
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        //打印retrofit日志
                        Log.i("RetrofitLog","retrofitBack = "+message);
                    }
                });

//        File logPath = new File("/Users/mark/Desktop/Document/GitHub/MarkRetrofitDemo/app/src/logs.txt");
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
//                .cache(new Cache(logPath,100))
                .addInterceptor(loggingInterceptor)
//                .connectTimeout(3000, TimeUnit.SECONDS)
//                .readTimeout(3000, TimeUnit.SECONDS)
//                .writeTimeout(3000, TimeUnit.SECONDS)
                .build();

        // 第2部分：在创建Retrofit实例时通过.baseUrl()设置
        mRetrofit = new Retrofit.Builder()
                .baseUrl(UrlsControl.BASEURL_MEINV)//设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .client(client)
                .build();

    }

    public static BaseRequest getINSTANCE(Context context) {
        if (mInstance == null) {
            synchronized (context) {
                if (mInstance == null) {
                    mInstance = new BaseRequest();
                }
            }
        }
        return mInstance;
    }

    /**
     * GET请求
     */
    public ApiService doRequest() {
        //第3部分 创建 网络请求接口 的实例
        apiService = mRetrofit.create(ApiService.class);
        return apiService;
    }


}
