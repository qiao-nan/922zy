package com.example.rascal.lx03c.callback;

import com.example.rascal.lx03c.bean.Bean2;
import com.example.rascal.lx03c.bean.Bean_list;

import java.util.List;

/**
 * Created by Rascal on 2019/9/22.
 */

public interface Netcallback2 {
    void onSuccess(List<Bean2.BodyBean.ResultBean> resultBeans);
    void onFail(String str);
}
