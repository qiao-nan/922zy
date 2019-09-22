package com.example.rascal.lx03b.callbacks;

import com.example.rascal.lx03b.beans.Bean_girl;

import java.util.List;

/**
 * Created by Rascal on 2019/9/22.
 */

public interface Netcallback {
    void onSuccess(List<Bean_girl.ResultsBean> resultsBeans);
    void onFail(String str);
}
