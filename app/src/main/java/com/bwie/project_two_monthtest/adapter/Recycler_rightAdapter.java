package com.bwie.project_two_monthtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.bwie.project_two_monthtest.R;
import com.bwie.project_two_monthtest.bean.Bean;

import java.util.List;

/**
 * 作者：郭传沛
 * 时间：2017/3/5:19:42
 * 邮箱：gcpzdl@mail.com
 * 说明：
 */


public class Recycler_rightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    List<Bean.RsBean.ChildrenBeanX> mChildrenBeanXes;

    public Recycler_rightAdapter(Context context, List<Bean.RsBean.ChildrenBeanX> childrenBeanXes) {
        mContext = context;
        mChildrenBeanXes = childrenBeanXes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.right_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.mTextView.setText(mChildrenBeanXes.get(position).getDirName());
        GridAdapter gridAdapter = new GridAdapter(mContext, mChildrenBeanXes.get(position).getChildren());
        myViewHolder.mGridview.setAdapter(gridAdapter);
    }

    @Override
    public int getItemCount() {
        Log.i("TAGG", "getItemCount: " + mChildrenBeanXes.size());
        return mChildrenBeanXes.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {


        private final TextView mTextView;
        private final FullGridView mGridview;

        public MyViewHolder(View itemView) {
            super(itemView);
            mGridview = (FullGridView) itemView.findViewById(R.id.right_item_grid);
            mTextView = (TextView) itemView.findViewById(R.id.right_item_text);
        }
    }

}
