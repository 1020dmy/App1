package com.example.liangxq.shopping;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.liangxq.shopping.fragment.FiveFragment;
import com.example.liangxq.shopping.fragment.FrouFragment;
import com.example.liangxq.shopping.fragment.OneFragment;
import com.example.liangxq.shopping.fragment.ThreeFragment;
import com.example.liangxq.shopping.fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fl;
    private BottomNavigationBar bnb;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
        bnb = (BottomNavigationBar) findViewById(R.id.bnb);

        initData();

    }

    private void initData() {
        bnb.setMode(BottomNavigationBar.MODE_FIXED)
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_home_press,"主页").setInactiveIconResource(R.drawable.btn_nav_home_normal))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_category_press,"分类").setInactiveIconResource(R.drawable.btn_nav_category_normal))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_cart_press,"购物车").setInactiveIconResource(R.drawable.btn_nav_cart_normal))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_msg_press,"消息").setInactiveIconResource(R.drawable.btn_nav_msg_normal))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_user_press,"我的").setInactiveIconResource(R.drawable.btn_nav_user_normal))
                .initialise();


        supportFragmentManager = getSupportFragmentManager();
        final OneFragment fragment = new OneFragment();
        supportFragmentManager.beginTransaction().replace(R.id.fl, fragment).commit();
        bnb.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                    FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                if (position==0){
                    fragmentTransaction.replace(R.id.fl,fragment);
                }
                if (position==1){
                    fragmentTransaction.replace(R.id.fl,new TwoFragment());
                }
                if (position==2){
                    fragmentTransaction.replace(R.id.fl,new ThreeFragment());
                }
                if (position==3){
                    fragmentTransaction.replace(R.id.fl, new FrouFragment());
                }
                if (position==4){
                    fragmentTransaction.replace(R.id.fl,new FiveFragment());
                }
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
}
//        new HttpClient.Builder()
//                .setApiUrl("wxarticle/list/408/1/json")
//                .get()
//                .build().request(new HttpCallBack<Demo>() {
//            @Override
//            public void onError(String message, int code) {
//                LogUtils.e(message);
//            }
//            @Override
//            public void cancle() {
//
//            }
//
//            @Override
//            public void onSuccess(Demo demo) {
//              LogUtils.e(demo.toString());
//            }
//
//            @Override
//            public Demo convert(JsonElement result) {
////                return new Gson().fromJson(result,Demo.class);
//                return JsonUtils.jsonToClass(result,Demo.class);
//            }
//        });
//        new HttpClient.Builder()
//                .setApiUrl("category/getCategory")
//                .post()
//                .setActivityEvent(ActivityEvent.DESTROY)
//                .setLifecycleProvider(this)
//                //怎么转换成json
//                .setJsonBody("{\"parentId\":\"0\"}",true)
//                //数据的回调要注意要理解
//                .build().request(new HttpCallBack<List<ShopDemo>>() {
//            @Override
//            public void onError(String message, int code) {
//
//            }
//
//            @Override
//            public void cancle() {
//
//            }
//
//            @Override
//            public void onSuccess(List<ShopDemo> shopDemos) {
//                LogUtils.e(shopDemos.toString());
//            }
//
//            @Override
//            public List<ShopDemo> convert(JsonElement result) {
//                return JsonUtils.jsonToClassList(result,ShopDemo.class);
//            }
//        });
//    }

//    @Override
//    protected void initData() {
//        mPresenter.getData();
//    }
//
//    @Override
//    protected int initLayoutId() {
//        return R.layout.activity_main;
//    }
//
//    @Override
//    protected MyPresenter initPresenter() {
//        return new MyPresenter();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//
//
//    public void get(){
//        ApiServer apiServer = HttpManager.getInstance().getRetrofit("", 5, TimeUnit.DAYS).create(ApiServer.class);
//        Observable<JsonElement> post = apiServer.post("", new HashMap<String, Object>(), new HashMap<String, Object>());
//
//
//        post.map(new Function<JsonElement, Object>() {
//            @Override
//            public Object apply(JsonElement jsonElement) throws Exception {
//                return new Gson().toJson(jsonElement);
//            }
//        }).compose(this.bindUntilEvent(ActivityEvent.DESTROY))
//                .subscribe(new Observer<Object>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Object o) {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
//    }
//
//    @Override
//    public void showDemo(Demo demo) {
//
//    }
//}
