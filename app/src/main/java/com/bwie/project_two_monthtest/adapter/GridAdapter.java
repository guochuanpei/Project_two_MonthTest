package com.bwie.project_two_monthtest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.project_two_monthtest.R;
import com.bwie.project_two_monthtest.bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 作者：郭传沛
 * 时间：2017/3/5:21:00
 * 邮箱：gcpzdl@mail.com
 * 说明：
 */


public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private List<Bean.RsBean.ChildrenBeanX.ChildrenBean> mChildrenBeanXes;
    private final ImageLoader mInstance;

    public GridAdapter(Context context, List<Bean.RsBean.ChildrenBeanX.ChildrenBean> childrenBeanXes) {
        mContext = context;
        mChildrenBeanXes = childrenBeanXes;
        mInstance = ImageLoader.getInstance();
    }

    @Override
    public int getCount() {
        return mChildrenBeanXes.size();
    }

    @Override
    public Object getItem(int position) {
        return mChildrenBeanXes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mChildrenBeanXes.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.grid_item, null);
            viewHolder = new ViewHolder();
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.grid_item_image);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.grid_item_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(mChildrenBeanXes.get(position).getDirName());
        mInstance.displayImage(mChildrenBeanXes.get(position).getImgApp(), viewHolder.mImageView);
        return convertView;
    }

    class ViewHolder {
        ImageView mImageView;
        TextView textView;
    }
}
