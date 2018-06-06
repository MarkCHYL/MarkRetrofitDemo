package com.mark.view.markretrofitdemotwo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mark.view.markretrofitdemotwo.R;
import com.mark.view.markretrofitdemotwo.api.BaseRequest;
import com.mark.view.markretrofitdemotwo.bean.BaseRequestBean;
import com.mark.view.markretrofitdemotwo.bean.CreateAppBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：MarkRetrofitDemo
 * 类描述：创建应用接口
 * Created by mark on 2018/6/6 14:06
 * 修改人：mark
 * 修改时间：2018/6/6 14:06
 * 修改备注：
 */
public class CreateAppActivity extends AppCompatActivity {

    @BindView(R.id.name_show)
    TextView nameShow;
    @BindView(R.id.tv_show)
    TextView tvShow;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createapp);
        ButterKnife.bind(this);
        mContext = this;
    }

    public void doShowCreate(View view){
        final Map<String,String> parmas = new HashMap<>();
        parmas.put("appId","com.chat.peakchao");
        parmas.put("passwd","123456");

        nameShow.setText(parmas.toString());
        Call<BaseRequestBean<CreateAppBean>> call = BaseRequest.getINSTANCE(mContext).doRequest().getCreateAPP(parmas);

        call.enqueue(new Callback<BaseRequestBean<CreateAppBean>>() {
            @Override
            public void onResponse(Call<BaseRequestBean<CreateAppBean>> call, Response<BaseRequestBean<CreateAppBean>> response) {
                if (response.body().getCode()== 200){
                    CreateAppBean bean = response.body().getData();
                    tvShow.setText(bean.toString());
                }
            }

            @Override
            public void onFailure(Call<BaseRequestBean<CreateAppBean>> call, Throwable t) {
                tvShow.setText(t.toString());
            }
        });
    }
}
