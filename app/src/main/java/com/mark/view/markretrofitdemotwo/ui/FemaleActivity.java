package com.mark.view.markretrofitdemotwo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mark.view.markretrofitdemotwo.R;
import com.mark.view.markretrofitdemotwo.api.BaseRequest;
import com.mark.view.markretrofitdemotwo.bean.BaseRequestBean;
import com.mark.view.markretrofitdemotwo.bean.FemaleBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名称：MarkRetrofitDemo
 * 类描述：个性网名
 * Created by mark on 2018/6/6 11:32
 * 修改人：mark
 * 修改时间：2018/6/6 11:32
 * 修改备注：
 */
public class FemaleActivity extends AppCompatActivity {

    @BindView(R.id.name_show)
    TextView nameShow;
    @BindView(R.id.tv_show)
    TextView tvShow;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female);
        ButterKnife.bind(this);
        mContext = this;
    }

    public void doShowName(View view) {
        Call<BaseRequestBean<List<FemaleBean>>> call = BaseRequest.getINSTANCE(this)
                .doRequest().getfemale(1);
        call.enqueue(new Callback<BaseRequestBean<List<FemaleBean>>>() {
            @Override
            public void onResponse(Call<BaseRequestBean<List<FemaleBean>>> call, Response<BaseRequestBean<List<FemaleBean>>> response) {
                List<FemaleBean> beans = response.body().getData();
                nameShow.setText(beans.get(0).getFemalename());
                tvShow.setText(beans.toString());
            }

            @Override
            public void onFailure(Call<BaseRequestBean<List<FemaleBean>>> call, Throwable t) {
                tvShow.setText(t.toString());
                Log.e("TAG", t.toString());
            }
        });
    }
}
