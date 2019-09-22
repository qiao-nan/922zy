package com.example.rascal.lx03c;

import com.example.rascal.lx03c.bean.Bean2;
import com.example.rascal.lx03c.bean.Bean_list;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Rascal on 2019/9/22.
 */

public interface ApiService {
    //https://api.yunxuekeji.cn/yunxue_app_api/content/getData/30/66597/1/10
    String BaseURL="https://api.yunxuekeji.cn/";

    @GET("yunxue_app_api/content/getData/30/66597/1/10")
    Observable<Bean_list> getList();


    //https://api.yunxuekeji.cn/yunxue_app_api/teacher/getTeacherPower/191

    @GET("yunxue_app_api/teacher/getTeacherPower/{id}")
    Observable<Bean2> getList2(@Path("id") int id);
}
