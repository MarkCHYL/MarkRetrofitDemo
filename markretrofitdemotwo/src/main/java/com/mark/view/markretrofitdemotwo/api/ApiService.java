package com.mark.view.markretrofitdemotwo.api;

import com.mark.view.markretrofitdemotwo.bean.BaseRequestBean;
import com.mark.view.markretrofitdemotwo.bean.BaseResultBean;
import com.mark.view.markretrofitdemotwo.bean.MeiNvBean;
import com.mark.view.markretrofitdemotwo.bean.ResultBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 * 项目名称：MarkRetrofitDemo
 * 类描述：定义服务接口
 * Created by mark on 2018/6/5 10:43
 * 修改人：mark
 * 修改时间：2018/6/5 10:43
 * 修改备注：
 *
 * @GET 表明这是get请求
 * @POST 表明这是post请求
 * @PUT 表明这是put请求
 * @DELETE 表明这是delete请求
 * @PATCH 表明这是一个patch请求，该请求是对put请求的补充，用于更新局部资源
 * @HEAD 表明这是一个head请求
 * @OPTIONS 表明这是一个option请求
 * @HTTP 通用注解, 可以替换以上所有的注解，其拥有三个属性：method，path，hasBody
 * @Headers 用于添加固定请求头，可以同时添加多个。通过该注解添加的请求头不会相互覆盖，而是共同存在
 * @Header 作为方法的参数传入，用于添加不固定值的Header，该注解会更新已有的请求头
 * @Body 多用于post请求发送非表单数据, 比如想要以post方式传递json格式数据
 * @Filed 多用于post请求中表单字段, Filed和FieldMap需要FormUrlEncoded结合使用
 * @FiledMap 和@Filed作用一致，用于不确定表单参数
 * @Part 用于表单字段, Part和PartMap与Multipart注解结合使用, 适合文件上传的情况
 * @PartMap 用于表单字段, 默认接受的类型是Map<String,REquestBody>，可用于实现多文件上传
 * <p>
 * Part标志上文的内容可以是富媒体形势，比如上传一张图片，上传一段音乐，即它多用于字节流传输。
 * 而Filed则相对简单些，通常是字符串键值对。
 * </p>
 * Part标志上文的内容可以是富媒体形势，比如上传一张图片，上传一段音乐，即它多用于字节流传输。
 * 而Filed则相对简单些，通常是字符串键值对。
 * @Path 用于url中的占位符,{占位符}和PATH只用在URL的path部分，url中的参数使用Query和QueryMap代替，保证接口定义的简洁
 * @Query 用于Get中指定参数
 * @QueryMap 和Query使用类似
 * @Url 指定请求路径
 */
public interface ApiService {

//    @Headers({
//            "username:mark"
//    })

    /**
     * 在网络请求接口的注解设置
     */
    @POST("ip/location?appkey=80985933997890df")
    Call<BaseResultBean<ResultBean>> getIpAdress(@Query("ip") String ip);

    @GET("meituApi")
    Call<BaseRequestBean<List<MeiNvBean>>> getMeiNv(@Query("page") int page);

    /*每个方法都必须有一个提供请求方法和相对URL的HTTP注释。有五个内置注释：GET，POST，
    PUT，DELETE，和HEAD。资源的相对URL在注释中指定。*/

}
