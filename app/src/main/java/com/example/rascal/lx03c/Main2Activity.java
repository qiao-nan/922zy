package com.example.rascal.lx03c;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rascal.lx03c.adapter.Adapter_ViewPager;
import com.example.rascal.lx03c.bean.Bean2;
import com.example.rascal.lx03c.bean.Bean_list;
import com.example.rascal.lx03c.persenter.NetPersenter2;
import com.example.rascal.lx03c.view.NetView2;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements NetView2 {

    private Toolbar mToolbar;
    private ImageView mIvItem;
    /**
     * gybukkkkkkkkkk
     */
    private TextView mTv1;
    /**
     * shaisaiufhaui
     */
    private TextView mTv2;
    /**
     * 关注
     */
    private TabLayout mTab;
    private NetPersenter2 mNetPersenter2;
    private int mPosition;
    private ArrayList<Bean_list.BodyBean.ResultBean> mList;
    private ViewPager mViewPager;
    private Adapter_ViewPager mAdapter_viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        mPosition = intent.getIntExtra("position", 0);
        mList = (ArrayList<Bean_list.BodyBean.ResultBean>) intent.getSerializableExtra("list");
        mNetPersenter2 = new NetPersenter2(this);
        mNetPersenter2.getDatas(id);

        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mIvItem = (ImageView) findViewById(R.id.iv_item);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mTab = (TabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mToolbar.setTitle("名师");
        mToolbar.setTitleMarginStart(305);
        setSupportActionBar(mToolbar);


        mTv1.setText(mList.get(mPosition).getTeacherName());
        mTv2.setText(mList.get(mPosition).getTitle());
        Glide.with(this).load(mList.get(mPosition).getTeacherPic()).apply(new RequestOptions().circleCrop()).into(mIvItem);

    }


    @Override
    public void addDatas(List<Bean2.BodyBean.ResultBean> resultBeans) {
        ArrayList<View> views = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        mTab.setupWithViewPager(mViewPager);
        for (int i = 0; i < resultBeans.size(); i++) {
            titles.add(resultBeans.get(i).getDescription());
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_vp, null);
            TextView tv_vp = inflate.findViewById(R.id.tv_vp);
            tv_vp.setText("GitHub是一个用于版本控制和协作的代码托管平台。它可以让你和其他人在任何地方一起完成项目。本教程将向您介绍GitHub的基本要素，如存储库、分支、提交和拉请求。您将创建自己的Hello World存储库，并学习GitHub的Pull Request工作流，这是一种创建和检查代码的流行方法。"+i);
            views.add(inflate);
        }
        mAdapter_viewPager = new Adapter_ViewPager(views,titles);
        mViewPager.setAdapter(mAdapter_viewPager);

    }

    @Override
    public void showString(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
