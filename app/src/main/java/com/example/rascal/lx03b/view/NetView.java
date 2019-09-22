package com.example.rascal.lx03b.view;

import com.example.rascal.lx03b.beans.Bean_girl;

import java.util.List;

/**
 * Created by Rascal on 2019/9/22.
 */

public interface NetView {
    void addDatas(List<Bean_girl.ResultsBean> resultsBeans );
    void showString(String str);
}
