package com.example.rascal.lx03c.medol;

import android.util.Log;

import com.example.rascal.lx03c.ApiService;
import com.example.rascal.lx03c.bean.Bean2;
import com.example.rascal.lx03c.callback.Netcallback2;

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

public class NetMedol2 {
    public void getDatas2(final Netcallback2 netcallback2, int id){
        //网络请求
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.BaseURL)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<Bean2> list = apiService.getList2(id);
        list.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean2>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean2 bean2) {
                        netcallback2.onSuccess(bean2.getBody().getResult());
                        Log.i("111", "onNext: 请求成功"+bean2.getBody().getResult().toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("111", "onError: 请求失败"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
