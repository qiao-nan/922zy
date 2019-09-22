package com.example.rascal.lx03b;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rascal.lx03b.adapter.Adapter_FragmentPager;
import com.example.rascal.lx03b.adapter.Adapter_Recycler;
import com.example.rascal.lx03b.beans.Bean_girl;
import com.example.rascal.lx03b.persenter.NetPersenter;
import com.example.rascal.lx03b.view.NetView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetView {

    private RecyclerView mRecycler;
    private ArrayList<Bean_girl.ResultsBean> mList;
    private Adapter_Recycler mAdapter_recycler;
    private NetPersenter mNetPersenter;
    private ViewPager mViewPager;
    /**
     * 1/20
     */
    private TextView mTvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNetPersenter = new NetPersenter(this);
        mNetPersenter.setDatas();
        initView();

    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTvCount = (TextView) findViewById(R.id.tv_count);
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mList = new ArrayList<>();
        mAdapter_recycler = new Adapter_Recycler(mList, this);
        mRecycler.setAdapter(mAdapter_recycler);

        mAdapter_recycler.setMypost(new Adapter_Recycler.mypost() {
            @Override
            public void myonClick(int position) {
                mRecycler.setVisibility(View.GONE); //隐藏
                mViewPager.setVisibility(View.VISIBLE); //显示
                mTvCount.setVisibility(View.VISIBLE); //显示

                initViewPager(position);
            }
        });

    }

    private void initViewPager(int position) {
        Bean_girl.ResultsBean resultsBean = mList.get(position);

        ArrayList<ImageView> imageViews = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            ImageView inflate = (ImageView) LayoutInflater.from(this).inflate(R.layout.layout_pager, null);
            Glide.with(this).load(mList.get(i).getUrl()).into(inflate);
            imageViews.add(inflate);
        }

        Adapter_FragmentPager adapter_fragmentPager = new Adapter_FragmentPager(imageViews);
        mViewPager.setAdapter(adapter_fragmentPager);

        mViewPager.setCurrentItem(position);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int currentItem = mViewPager.getCurrentItem();
                mTvCount.setText(currentItem+1+"/"+mAdapter_recycler.getItemCount());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void addDatas(List<Bean_girl.ResultsBean> resultsBeans) {
        mList.clear();
        mList.addAll(resultsBeans);
        mAdapter_recycler.notifyDataSetChanged();
    }

    @Override
    public void showString(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if(mRecycler.getVisibility()==View.GONE){
            mRecycler.setVisibility(View.VISIBLE);
            mViewPager.setVisibility(View.GONE);
            mTvCount.setVisibility(View.GONE);
        }else {
            super.onBackPressed();
        }

    }
}
