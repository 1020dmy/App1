package com.example.liangxq.shopping;

/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping
 * 文件名：Demo2
 * 创建者：liangxq
 * 创建时间：2020/8/5  14:49
 * 描述：TODO
 */
public class Demo2<D> {


    public <T> T print(T t){
        System.out.println(t);
        return t;
    }

    public void text(D d){


    }


    public <T extends Demo1> T print1(T t){
        System.out.println(t);
        return t;
    }


    public class Demo1{

    }

    public class Demo3 extends Demo1{

    }
}


