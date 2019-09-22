package com.example.rascal.lx03c;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.rascal.lx03c.adapter.Adapter_Recycler;
import com.example.rascal.lx03c.bean.Bean_list;
import com.example.rascal.lx03c.persenter.NetPersenter;
import com.example.rascal.lx03c.view.NetView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetView{

    private Toolbar mToolbar;
    private RecyclerView mRecycler;
    private ArrayList<Bean_list.BodyBean.ResultBean> mList;
    private Adapter_Recycler mAdapter_recycler;
    private NetPersenter mNetPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNetPersenter = new NetPersenter(this);
        mNetPersenter.setDatas();
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecycler = (RecyclerView) findViewById(R.id.recycler);

        mToolbar.setTitleMarginStart(305);
        mToolbar.setTitle("名师推荐");
        setSupportActionBar(mToolbar);

        initRecycler();
    }

    private void initRecycler() {
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mList = new ArrayList<>();
        mAdapter_recycler = new Adapter_Recycler(mList, this);
        mRecycler.setAdapter(mAdapter_recycler);

        mAdapter_recycler.setMypost(new Adapter_Recycler.mypost() {
            @Override
            public void myOnClick(int position) {
                //跳转页面
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("id",mList.get(position).getID());
                intent.putExtra("position",position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list",mList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void addDatas(List<Bean_list.BodyBean.ResultBean> resultBeans) {
        mList.clear();
        mList.addAll(resultBeans);
        mAdapter_recycler.notifyDataSetChanged();
    }

    @Override
    public void showString(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
