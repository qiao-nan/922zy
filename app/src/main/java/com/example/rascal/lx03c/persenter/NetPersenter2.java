package com.example.rascal.lx03c.persenter;

import com.example.rascal.lx03c.bean.Bean2;
import com.example.rascal.lx03c.callback.Netcallback2;
import com.example.rascal.lx03c.medol.NetMedol2;
import com.example.rascal.lx03c.view.NetView2;

import java.util.List;

/**
 * Created by Rascal on 2019/9/22.
 */

public class NetPersenter2 implements Netcallback2{
    private NetView2 mNetView2;
    private NetMedol2 mNetMedol2;

    public NetPersenter2(NetView2 netView2) {
        mNetView2 = netView2;
        mNetMedol2=new NetMedol2();
    }

    public void getDatas(int id){
        mNetMedol2.getDatas2(this,id);
    }

    @Override
    public void onSuccess(List<Bean2.BodyBean.ResultBean> resultBeans) {
        mNetView2.addDatas(resultBeans);
    }

    @Override
    public void onFail(String str) {
        mNetView2.showString(str);
    }
}
