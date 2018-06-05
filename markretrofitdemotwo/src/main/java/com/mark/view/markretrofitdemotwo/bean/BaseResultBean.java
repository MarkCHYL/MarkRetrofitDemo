package com.mark.view.markretrofitdemotwo.bean;

/**
 * 项目名称：MarkRetrofitDemo
 * 类描述：
 * Created by mark on 2018/6/5 10:38
 * 修改人：mark
 * 修改时间：2018/6/5 10:38
 * 修改备注：
 */
public class BaseResultBean<T> {
    /**
     * status : 0
     * msg : ok
     * result : {"ip":"122.224.18.103","area":"浙江 绍兴","type":"电信","country":"中国","province":"浙江","city":"绍兴","town":""}
     */

    private String status;
    private String msg;
    private T result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
