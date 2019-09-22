package com.example.rascal.lx03b;

import com.example.rascal.lx03b.beans.Bean_girl;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Rascal on 2019/9/22.
 */

public interface ApiService {
    //http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
    String BaseURL="http://gank.io/api/";

    @GET("data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<Bean_girl> getJson();
}
