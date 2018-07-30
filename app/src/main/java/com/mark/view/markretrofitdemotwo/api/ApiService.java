package com.mark.view.markretrofitdemotwo.api;


import com.mark.view.markretrofitdemotwo.bean.BaseRequestBean;
import com.mark.view.markretrofitdemotwo.bean.CreateAppBean;
import com.mark.view.markretrofitdemotwo.bean.FemaleBean;
import com.mark.view.markretrofitdemotwo.bean.MeiNvBean;
import com.mark.view.markretrofitdemotwo.mvp.model.bean.BaseResultBean;
import com.mark.view.markretrofitdemotwo.mvp.model.bean.IPAddressResultBean;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.*;

/*
 * 项目名称：MarkRetrofitDemo
 * 类描述：定义服务接口
 * Created by mark on 2018/6/5 10:43
 * 修改人：mark
 * 修改时间：2018/6/5 10:43
 * 修改备注：
 *
 *方法注解，包含@GET、@POST、@PUT、@DELETE、@PATH、@HEAD、@OPTIONS、@HTTP。
标记注解，包含@FormUrlEncoded、@Multipart、@Streaming。
参数注解，包含@Query,@QueryMap、@Body、@Field，@FieldMap、@Part，@PartMap。

其他注解，@Path、@Header,@Headers、@Url
* 可以参考大神的文章：https://blog.csdn.net/wbwjx/article/details/51379506
* https://blog.csdn.net/huyongl1989/article/details/52619193
 */
public interface ApiService<T> {

//    @Headers({
//            "username:mark"
//    })

    /**
     * 在网络请求接口的注解设置
     */
    @GET("ip/location?appkey=80985933997890df")
    Call<BaseResultBean<IPAddressResultBean>> getIpAdress(@Query("ip") String ip);

    @GET("meituApi")
    Call<BaseRequestBean<List<MeiNvBean>>> getMeiNv(@Query("page") int page);

    /*每个方法都必须有一个提供请求方法和相对URL的HTTP注释。有五个内置注释：GET，POST，
    PUT，DELETE，和HEAD。资源的相对URL在注释中指定。*/
    //个性网名获取接口
    @GET("femaleNameApi")
    Call<BaseRequestBean<List<FemaleBean>>> getfemale(@Query("page") int page);

    //创建应用接口 @QueryMap的使用
//    @Headers({})
    @GET("createUserKey")
    Call<BaseRequestBean<CreateAppBean>> getCreateAPP(@QueryMap Map<String,String> parmas);



}
