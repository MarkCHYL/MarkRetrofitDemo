package com.mark.view.markretrofitdemotwo.mvp.model.bean;

/**
 * 项目名称：MarkRetrofitDemo
 * 类描述：
 * Created by mark on 2018/6/5 16:49
 * 修改人：mark
 * 修改时间：2018/6/5 16:49
 * 修改备注：
 */
public class IPAddressResultBean {


    /**
     * ip : 122.224.18.103
     * area : 浙江 绍兴
     * type : 电信
     * country : 中国
     * province : 浙江
     * city : 绍兴
     * town :
     */

    private String ip;
    private String area;
    private String type;
    private String country;
    private String province;
    private String city;
    private String town;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "ip='" + ip + '\'' +
                ", area='" + area + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}
