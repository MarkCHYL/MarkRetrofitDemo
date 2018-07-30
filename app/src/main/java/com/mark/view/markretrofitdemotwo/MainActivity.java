package com.mark.view.markretrofitdemotwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mark.view.markretrofitdemotwo.api.ApiService;
import com.mark.view.markretrofitdemotwo.api.UrlsControl;
import com.mark.view.markretrofitdemotwo.bean.BaseResultBean;
import com.mark.view.markretrofitdemotwo.bean.ResultBean;
import com.mark.view.markretrofitdemotwo.ui.CreateAppActivity;
import com.mark.view.markretrofitdemotwo.ui.FemaleActivity;
import com.mark.view.markretrofitdemotwo.ui.MVPActivity;
import com.mark.view.markretrofitdemotwo.ui.MeiNvActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_show = findViewById(R.id.tv_show);
    }

    public void doGet(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlsControl.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<BaseResultBean<ResultBean>> call = apiService.getIpAdress("122.224.18.103");

        call.enqueue(new Callback<BaseResultBean<ResultBean>>() {
            @Override
            public void onResponse(Call<BaseResultBean<ResultBean>> call,
                                   Response<BaseResultBean<ResultBean>> response) {
                ResultBean bean = response.body().getResult();

                tv_show.setText(bean.toString());
            }

            @Override
            public void onFailure(Call<BaseResultBean<ResultBean>> call, Throwable t) {
                tv_show.setText(t.toString());
            }
        });
    }

    public void doSeeMeiNv(View view){
        startActivity(new Intent(this, MeiNvActivity.class));
    }

    public void doSeeFemale(View view){
        startActivity(new Intent(this, FemaleActivity.class));
    }

    public void doCreateApp(View view){
        startActivity(new Intent(this, CreateAppActivity.class));
    }

    //别在意  MVP和retrofit的演示
    public void goMVP(View view){
        startActivity(new Intent(MainActivity.this, MVPActivity.class));
    }
}
