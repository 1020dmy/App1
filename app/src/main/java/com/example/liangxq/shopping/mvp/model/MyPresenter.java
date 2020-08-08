package com.example.liangxq.shopping.mvp.model;

import com.example.liangxq.shopping.httpdemo.wanandroid.Demo;
import com.example.mvplibrary.model.ModelBaseCallback;
import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;

/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping.mvp.model
 * 文件名：MyPresenter
 * 创建者：liangxq
 * 创建时间：2020/8/5  16:16
 * 描述：TODO
 */
public class MyPresenter extends BasePresenter<MyView> implements ModelBaseCallback<Demo> {

    public void getData(){
        ModleFractory.creatModle(MyModel.class).getData(this,getLifeCycle());
    }

    @Override
    public void onSucess(Demo demo) {

    }

    @Override
    public void Onerror(String msg, int code) {

    }

    @Override
    public void onCancle() {

    }
}
