package com.example.rascal.lx03c.view;

import com.example.rascal.lx03c.bean.Bean_list;

import java.util.List;

/**
 * Created by Rascal on 2019/9/22.
 */

public interface NetView {
    void addDatas(List<Bean_list.BodyBean.ResultBean> resultBeans);
    void showString(String str);
}
