package com.example.rascal.lx03c.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rascal.lx03c.R;
import com.example.rascal.lx03c.bean.Bean_list;

import java.util.ArrayList;

/**
 * Created by Rascal on 2019/9/22.
 */

public class Adapter_Recycler extends RecyclerView.Adapter {
    mypost mMypost;
    private ArrayList<Bean_list.BodyBean.ResultBean> mList;
    private Context mContext;

    public Adapter_Recycler(ArrayList<Bean_list.BodyBean.ResultBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.mTv1.setText(mList.get(position).getTeacherName());
        holder1.mTv2.setText(mList.get(position).getTitle());
        Glide.with(mContext).load(mList.get(position).getTeacherPic()).apply(new RequestOptions().circleCrop()).into(holder1.mIvItem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMypost.myOnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setMypost(mypost mypost) {
        mMypost = mypost;
    }

    //接口回调
    public interface mypost {
        void myOnClick(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView mIvItem;
        TextView mTv1;
        TextView mTv2;
        Button mBt;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            this.mIvItem = (ImageView) view.findViewById(R.id.iv_item);
            this.mTv1 = (TextView) view.findViewById(R.id.tv1);
            this.mTv2 = (TextView) view.findViewById(R.id.tv2);
            this.mBt = (Button) view.findViewById(R.id.bt);
        }
    }
}
