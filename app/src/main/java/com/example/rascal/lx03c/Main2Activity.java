package com.example.rascal.lx03c;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rascal.lx03c.bean.Bean2;
import com.example.rascal.lx03c.bean.Bean_list;
import com.example.rascal.lx03c.persenter.NetPersenter2;
import com.example.rascal.lx03c.view.NetView2;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements NetView2{

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
    private Button mBt;
    private TabLayout mTab;
    private TextView mTvContent;
    private NetPersenter2 mNetPersenter2;
    private int mPosition;
    private ArrayList<Bean_list.BodyBean.ResultBean> mList;

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
        mBt = (Button) findViewById(R.id.bt);
        mTab = (TabLayout) findViewById(R.id.tab);
        mTvContent = (TextView) findViewById(R.id.tv_content);

        mToolbar.setTitle("名师");
        mToolbar.setTitleMarginStart(305);
        setSupportActionBar(mToolbar);


        mTv1.setText(mList.get(mPosition).getTeacherName());
        mTv2.setText(mList.get(mPosition).getTitle());
        Glide.with(this).load(mList.get(mPosition).getTeacherPic()).apply(new RequestOptions().circleCrop()).into(mIvItem);

    }


    @Override
    public void addDatas(List<Bean2.BodyBean.ResultBean> resultBeans) {
        for (int i = 0; i < resultBeans.size(); i++) {
            mTab.addTab(mTab.newTab().setText(resultBeans.get(i).getDescription()));
        }

    }

    @Override
    public void showString(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
