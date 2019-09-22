package com.example.rascal.lx03b.persenter;

import com.example.rascal.lx03b.beans.Bean_girl;
import com.example.rascal.lx03b.callbacks.Netcallback;
import com.example.rascal.lx03b.medol.NetModel;
import com.example.rascal.lx03b.view.NetView;

import java.util.List;

/**
 * Created by Rascal on 2019/9/22.
 */

public class NetPersenter implements Netcallback{
    private NetView mNetView;
    private NetModel mNetModel;

    public NetPersenter(NetView netView) {
        mNetView = netView;
        mNetModel = new NetModel();
    }

    public void setDatas(){
        mNetModel.getDatas(this);
    }

    @Override
    public void onSuccess(List<Bean_girl.ResultsBean> resultsBeans) {
        mNetView.addDatas(resultsBeans);
    }

    @Override
    public void onFail(String str) {
        mNetView.showString(str);
    }
}
