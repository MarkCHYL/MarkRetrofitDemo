package com.mark.view.markretrofitdemotwo.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mark.view.markretrofitdemotwo.R;
import com.mark.view.markretrofitdemotwo.api.ApiService;
import com.mark.view.markretrofitdemotwo.api.BaseRequest;
import com.mark.view.markretrofitdemotwo.api.UrlsControl;
import com.mark.view.markretrofitdemotwo.bean.BaseRequestBean;
import com.mark.view.markretrofitdemotwo.bean.MeiNvBean;

import org.w3c.dom.Text;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称：MarkRetrofitDemo
 * 类描述：
 * Created by mark on 2018/6/5 17:11
 * 修改人：mark
 * 修改时间：2018/6/5 17:11
 * 修改备注：
 */
public class MeiNvActivity extends AppCompatActivity {

    private TextView tv_show;
    private ImageView iv_show;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meinv);
        mContext = this;
        tv_show = findViewById(R.id.tv_show);
        iv_show = findViewById(R.id.iv_show);
    }

    public void doShowMeiNv(View view) {

        //第4部分 访问api服务
        Call<BaseRequestBean<List<MeiNvBean>>> call = BaseRequest.getINSTANCE(this)
                .doRequest().getMeiNv(1);
        //第5部分 执行网络请求
        call.enqueue(new Callback<BaseRequestBean<List<MeiNvBean>>>() {
            @Override
            public void onResponse(Call<BaseRequestBean<List<MeiNvBean>>> call, Response<BaseRequestBean<List<MeiNvBean>>> response) {
                List<MeiNvBean> meiNvBeans = response.body().getData();
                tv_show.setText(meiNvBeans.toString());
                Glide.with(mContext).load(meiNvBeans.get(2).getUrl()).into(iv_show);
            }

            @Override
            public void onFailure(Call<BaseRequestBean<List<MeiNvBean>>> call, Throwable t) {
                tv_show.setText(t.toString());
                Log.e("TAG", t.toString());
            }
        });

    }
}
