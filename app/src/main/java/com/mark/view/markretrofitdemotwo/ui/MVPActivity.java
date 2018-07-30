package com.mark.view.markretrofitdemotwo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mark.view.markretrofitdemotwo.R;
import com.mark.view.markretrofitdemotwo.mvp.model.bean.BaseResultBean;
import com.mark.view.markretrofitdemotwo.mvp.model.bean.IPAddressResultBean;
import com.mark.view.markretrofitdemotwo.mvp.presenter.IPAddressPresenter;
import com.mark.view.markretrofitdemotwo.mvp.view.IPAddressView;

import retrofit2.Call;


/**
 * $desc$ MVP模式的显示
 *
 * @Author mark 2285581945@qq.com
 * @Date 2018/7/30
 */
public class MVPActivity extends AppCompatActivity implements IPAddressView {

    private IPAddressPresenter presenter;

    private TextView tv_show;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_layout);
        presenter = new IPAddressPresenter(this);

        initView();
    }

    private void initView() {
        tv_show = findViewById(R.id.tv_show);
    }

    public void doget(View view) {
        presenter.loadIpAddress();
    }

    @Override
    public void setIp(IPAddressResultBean resultBean) {
        if (resultBean!=null){
            tv_show.setText(resultBean.toString());
        }
    }

    @Override
    public void onFailure(Call<BaseResultBean<IPAddressResultBean>> call) {
        Toast.makeText(this,call.toString(),Toast.LENGTH_SHORT).show();
    }
}
