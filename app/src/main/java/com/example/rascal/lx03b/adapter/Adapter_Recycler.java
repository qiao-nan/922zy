package com.example.rascal.lx03b.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rascal.lx03b.R;
import com.example.rascal.lx03b.beans.Bean_girl;

import java.util.ArrayList;

/**
 * Created by Rascal on 2019/9/22.
 */

public class Adapter_Recycler extends RecyclerView.Adapter {
    private ArrayList<Bean_girl.ResultsBean> mList;
    private Context mContext;

    public Adapter_Recycler(ArrayList<Bean_girl.ResultsBean> list, Context context) {
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
        Glide.with(mContext).load(mList.get(position).getUrl()).into(holder1.mIvItem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击切换到ViewPager
                mMypost.myonClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        ImageView mIvItem;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            this.mIvItem = (ImageView) view.findViewById(R.id.iv_item);
        }
    }

    //接口回调
    public interface mypost{
        void myonClick(int position);
    }

    mypost mMypost;

    public void setMypost(mypost mypost) {
        mMypost = mypost;
    }
}
