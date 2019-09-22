package com.example.rascal.lx03c.persenter;

import com.example.rascal.lx03c.bean.Bean_list;
import com.example.rascal.lx03c.callback.Netcallback;
import com.example.rascal.lx03c.medol.NetMedol;
import com.example.rascal.lx03c.view.NetView;

import java.util.List;

/**
 * Created by Rascal on 2019/9/22.
 */

public class NetPersenter implements Netcallback{
    private NetView mNetView;
    private NetMedol mNetMedol;

    public NetPersenter(NetView netView) {
        mNetView = netView;
        mNetMedol=new NetMedol();
    }

    public void setDatas(){
        mNetMedol.getDatas(this);
    }

    @Override
    public void onSuccess(List<Bean_list.BodyBean.ResultBean> resultBeans) {
        mNetView.addDatas(resultBeans);
    }

    @Override
    public void onFail(String str) {
        mNetView.showString(str);
    }
}
