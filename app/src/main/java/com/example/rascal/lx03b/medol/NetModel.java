package com.example.rascal.lx03b.medol;

import android.util.Log;

import com.example.rascal.lx03b.ApiService;
import com.example.rascal.lx03b.beans.Bean_girl;
import com.example.rascal.lx03b.callbacks.Netcallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rascal on 2019/9/22.
 */

public class NetModel {
    //网络请求
    public void getDatas(final Netcallback netcallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.BaseURL)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<Bean_girl> json = apiService.getJson();
        json.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean_girl>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean_girl bean_girl) {
                        netcallback.onSuccess(bean_girl.getResults());
                        Log.i("111", "onNext: 请求成功" + bean_girl.getResults().toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        netcallback.onFail("请求失败" + e.getMessage());
                        Log.e("111", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
