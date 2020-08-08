package com.example.liangxq.shopping.mvp.model;

import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.httplibrary.utils.LogUtils;
import com.example.liangxq.shopping.httpdemo.wanandroid.Demo;
import com.example.liangxq.shopping.httpdemo.wanandroid.HttpCallBack;
import com.example.mvplibrary.model.BaseModel;
import com.example.mvplibrary.model.ModelBaseCallback;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import javax.security.auth.callback.Callback;

/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping.mvp.model
 * 文件名：MyModel
 * 创建者：liangxq
 * 创建时间：2020/8/5  16:12
 * 描述：TODO
 */
public class MyModel implements BaseModel {
    public void getData(final ModelBaseCallback<Demo> modelBaseCallback, LifecycleProvider lifecycleProvider){
        new HttpClient.Builder()
                .setApiUrl("wxarticle/list/408/1/json")
                .get()
                .setLifecycleProvider(lifecycleProvider)
                .build().request(new HttpCallBack<Demo>() {
            @Override
            public void onError(String message, int code) {
                LogUtils.e(message);
            }
            @Override
            public void cancle() {

            }
            @Override
            public void onSuccess(Demo demo) {
                LogUtils.e(demo.toString());
                modelBaseCallback.onSucess(demo);
            }

            @Override
            public Demo convert(JsonElement result) {
                return JsonUtils.jsonToClass(result,Demo.class);
            }
        });
    }
}
