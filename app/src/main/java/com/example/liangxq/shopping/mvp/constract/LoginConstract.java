package com.example.liangxq.shopping.mvp.constract;

import com.example.mvplibrary.model.BaseModel;
import com.example.mvplibrary.view.BaseView;

/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping.mvp.constract
 * 文件名：LoginConstract
 * 创建者：liangxq
 * 创建时间：2020/8/6  10:55
 * 描述：TODO
 *
 * 契约类
 */
public interface LoginConstract {

    interface LoginPresenter {
        void login(String name,String password);
    }

    interface LoginModle extends BaseModel{

        void login(String name,String password);
    }

    interface LoginView extends BaseView{

        void show(String sucess);
    }
}
