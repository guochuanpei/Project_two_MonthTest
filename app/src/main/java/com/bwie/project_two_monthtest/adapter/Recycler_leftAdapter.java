package com.bwie.project_two_monthtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bwie.project_two_monthtest.R;
import com.bwie.project_two_monthtest.bean.Bean;

import java.util.List;

/**
 * 作者：郭传沛
 * 时间：2017/3/5:19:02
 * 邮箱：gcpzdl@mail.com
 * 说明：
 */


public class Recycler_leftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Bean.RsBean> mList;
    private PositionListener mPositionListener;

    public void Recycler_leftAdapter(PositionListener positionListener) {
        mPositionListener = positionListener;
    }

    public Recycler_leftAdapter(Context context, List<Bean.RsBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.left_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mButton.setText(mList.get(position).getDirName());
        final List<Bean.RsBean.ChildrenBeanX> children = mList.get(position).getChildren();
        viewHolder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPositionListener.getPositionList(children);
                Toast.makeText(mContext, mList.get(position).getDirName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final Button mButton;

        public ViewHolder(View itemView) {
            super(itemView);
            mButton = (Button) itemView.findViewById(R.id.left_item_btn);
        }
    }

    public interface PositionListener {
        void getPositionList(List<Bean.RsBean.ChildrenBeanX> childrenBeanXes);
    }
}
