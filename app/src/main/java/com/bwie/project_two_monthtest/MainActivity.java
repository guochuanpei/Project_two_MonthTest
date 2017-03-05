package com.bwie.project_two_monthtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bwie.project_two_monthtest.adapter.Recycler_leftAdapter;
import com.bwie.project_two_monthtest.adapter.Recycler_rightAdapter;
import com.bwie.project_two_monthtest.bean.Bean;
import com.bwie.project_two_monthtest.util.GsonUtil;
import com.bwie.project_two_monthtest.util.OkHttpUtil;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OkHttpUtil.RequestDataListener {

    private RecyclerView mLeft_recycler;
    private RecyclerView mRight_recycler;
    private String mString = "http://mock.eoapi.cn/success/4q69ckcRaBdxhdHySqp2Mnxdju5Z8Yr4";
    private Recycler_leftAdapter mRecycler_leftAdapter;
    private List<Bean.RsBean> mRs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    //初始化控件
    private void initViews() {
        mLeft_recycler = (RecyclerView) findViewById(R.id.left_recycler);
        mLeft_recycler.setLayoutManager(new LinearLayoutManager(this));
        mRight_recycler = (RecyclerView) findViewById(R.id.right_recycler);
        mRight_recycler.setLayoutManager(new LinearLayoutManager(this));
        new OkHttpUtil(this);
        OkHttpUtil.getRequestData(mString);

    }

    @Override
    public void getResponseData(String s) {
        Bean bean = GsonUtil.parseJsonToObj(s, new TypeToken<Bean>() {
        });
        mRs = bean.getRs();
        Log.i("TAG", "我是接收到的数据" + mRs.toString());
        mRecycler_leftAdapter = new Recycler_leftAdapter(this, mRs);
        mLeft_recycler.setAdapter(mRecycler_leftAdapter);
        mRecycler_leftAdapter.Recycler_leftAdapter(new Recycler_leftAdapter.PositionListener() {
            @Override
            public void getPositionList(List<Bean.RsBean.ChildrenBeanX> childrenBeanXes) {
                Log.i("TAG", "我是接口回调的集合数据" + childrenBeanXes.toString());
                Recycler_rightAdapter recycler_rightAdapter = new Recycler_rightAdapter(MainActivity.this, childrenBeanXes);
                mRight_recycler.setAdapter(recycler_rightAdapter);
            }
        });
    }
}
