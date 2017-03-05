package com.bwie.project_two_monthtest.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者：郭传沛
 * 时间：2017/3/4:11:43
 * 邮箱：gcpzdl@mail.com
 * 说明：
 */


public class OkHttpUtil {

    private static OkHttpClient sOkHttpClient;
    private static RequestDataListener sRequestDataListener;
    private static Handler mHandler;

    public OkHttpUtil(RequestDataListener sRequestDataListener) {
        this.sRequestDataListener = sRequestDataListener;
        mHandler = new Handler(Looper.getMainLooper());
    }

    //GET请求
    public static void getRequestData(String path) {
        sOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(path).build();
        Call call = sOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        sRequestDataListener.getResponseData(string);
                        Log.i("TAG", "我是工具类请求的数据" + string);
                    }
                });
            }
        });
    }

    public interface RequestDataListener {
        void getResponseData(String s);
    }
}
