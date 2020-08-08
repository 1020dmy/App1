package com.example.liangxq.shopping.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.liangxq.shopping.MainActivity;
import com.example.liangxq.shopping.adapter.MyViewPagerAdapter;
import com.example.liangxq.shopping.adapter.RecyclerAdapter;
import com.example.liangxq.shopping.R;
import com.example.liangxq.shopping.hualang.GallyPageTransformer;
import com.example.liangxq.shopping.hualang.ImageUtil;
import com.example.liangxq.shopping.mvp.model.MyView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

    //折扣图
    String HOME_DISCOUNT_ONE = "https://www.wanandroid.com/blogimgs/8e95ad05-a6f5-4c65-8a89-f8d4b819aa80.jpeg";
    String HOME_DISCOUNT_TWO = "https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png";
    String HOME_DISCOUNT_THREE = "https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png";
    String HOME_DISCOUNT_FOUR = "https://img11.360buyimg.com/n7/jfs/t4447/301/1238553109/193354/13c7e995/58db19a7N25101fe4.jpg";
    String HOME_DISCOUNT_FIVE = "https://img14.360buyimg.com/n1/s190x190_jfs/t7525/189/155179632/395056/e200017f/598fb8a4N7800dee6.jpg";    private View inflate;
    //Banner
    String HOME_BANNER_ONE = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502876108368&di=cd9725c81901f6d7499edd76cf2e68e5&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F17%2F37%2F20%2F80Q58PICe3W_1024.jpg";
    String HOME_BANNER_TWO = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502882008108&di=d0cf4a8536aefa5df791716c1053ca66&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01e9495812c7f9a84a0d304fbc135b.jpg";
    String HOME_BANNER_THREE = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502876281925&di=f33e7ef8be268e90ffbffd315f5fb0a3&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F013e1b57d2731c0000018c1beeca11.jpg%40900w_1l_2o_100sh.jpg";
    String HOME_BANNER_FOUR = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503471047&di=679d7a6c499f59d1b0dcd56b62a9aa6c&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.90sheji.com%2Fdianpu_cover%2F11%2F14%2F64%2F55%2F94ibannercsn_1200.jpg";
    private Banner banner;
    private ArrayList<String> banner_tiltle;
    private RecyclerView rv;
    private ArrayList<String> list;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<String> gonggaolist;
    private ViewFlipper fliper;
    private ViewPager mViewPager;
    private int pagerWidth;
    private LinearLayout ll_main;
    private ArrayList<ImageView> imageViews;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        inflate = inflater.inflate(R.layout.fragment_one, container, false);
        initView();


        return inflate;
    }

    private void initView() {
        banner = inflate.findViewById(R.id.banner);
        rv = inflate.findViewById(R.id.rv);
        fliper = inflate.findViewById(R.id.filpper);
        mViewPager = inflate.findViewById(R.id.mViewPager);


        //轮播图
        oneFragmentBanner();
        //设置公告
        initgongGao();

        //垂直布局列表展示
        initRecyler();

        //画廊效果
        initViewPager();
    }

    private void initViewPager() {
        ll_main = (LinearLayout) inflate.findViewById(R.id.lin);
        initViewPagerData();
        mViewPager.setOffscreenPageLimit(3);
        pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0f / 5.0f);
        ViewGroup.LayoutParams lp = mViewPager.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            lp.width = pagerWidth;
        }
        mViewPager.setLayoutParams(lp);
        mViewPager.setPageMargin(-50);
        ll_main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mViewPager.dispatchTouchEvent(motionEvent);
            }
        });
        mViewPager.setPageTransformer(true, new GallyPageTransformer());
        mViewPager.setAdapter(new MyViewPagerAdapter(imageViews));

    }

    private void initViewPagerData() {
        imageViews = new ArrayList<>();
        ImageView first = new ImageView(getActivity());
        first.setImageBitmap(ImageUtil.getReverseBitmapById(R.drawable.hualang1, getActivity()));
//        first.setImageResource(R.mipmap.first);
        ImageView second = new ImageView(getActivity());
        second.setImageBitmap(ImageUtil.getReverseBitmapById(R.drawable.hualang2, getActivity()));
//        second.setImageResource(R.mipmap.second);
        ImageView third = new ImageView(getActivity());
        third.setImageBitmap(ImageUtil.getReverseBitmapById(R.drawable.hualang1, getActivity()));
//        third.setImageResource(R.mipmap.third);
        ImageView fourth = new ImageView(getActivity());
//        fourth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.fourth,MainActivity.this));
        fourth.setImageResource(R.drawable.hualang2);
        ImageView fifth = new ImageView(getActivity());
        fifth.setImageBitmap(ImageUtil.getReverseBitmapById(R.drawable.hualang1, getActivity()));
//        fifth.setImageResource(R.mipmap.fifth);
        imageViews.add(first);
        imageViews.add(second);
        imageViews.add(third);
        imageViews.add(fourth);
        imageViews.add(fifth);
    }

    private void initgongGao() {

        gonggaolist = new ArrayList<>();
        gonggaolist.add("新用户立领1000元优惠券");
        gonggaolist.add("夏日炎炎，第一波福利还有30秒到达战场");

        setViews();
    }


        private void setViews() {
            for (int i = 0; i < gonggaolist.size(); i++) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.title_view, null);
                TextView tvTitle = view.findViewById(R.id.tvItem);
                //赋值
                tvTitle.setText(gonggaolist.get(i));
                //动态添加视图
                fliper.addView(view);
            }

            //设置的时间间隔来开始切换所有的View,切换会循环进行
            fliper.startFlipping();
            //视图进入动画
            fliper.setInAnimation(getContext(), R.anim.news_in);
            //视图退出动画
            fliper.setOutAnimation(getContext(), R.anim.news_out);
            //自动开始滚动
            fliper.setAutoStart(true);
            //视图的切换间隔
            fliper.setFlipInterval(3000);
        }


    private void initRecyler() {
        rv.setLayoutManager(new GridLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<String> rv_list = new ArrayList<>();
        rv_list.add(HOME_DISCOUNT_ONE);
        rv_list.add(HOME_DISCOUNT_THREE);
        rv_list.add(HOME_DISCOUNT_FIVE);
        rv_list.add(HOME_DISCOUNT_TWO);
        rv_list.add(HOME_DISCOUNT_FOUR);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("￥ 123");
        strings.add("￥ 456");
        strings.add("￥ 789");
        strings.add("￥ 147");
        strings.add("￥ 258");
        list = new ArrayList<>();
        list.add("💲1000");
        list.add("💲1000");
        list.add("💲1000");
        list.add("💲1000");
        list.add("💲1000");
        recyclerAdapter = new RecyclerAdapter(rv_list, strings, list, getActivity());
        rv.setAdapter(recyclerAdapter);
    }

    private void oneFragmentBanner() {
        ArrayList<String> banner_image = new ArrayList<>();
        banner_image.add(HOME_BANNER_FOUR);
        banner_image.add(HOME_DISCOUNT_TWO);
        banner_image.add(HOME_BANNER_FOUR);
        banner_image.add(HOME_DISCOUNT_ONE);
        banner_tiltle = new ArrayList<>();
        banner_tiltle.add(" 摩登新秋 ");
        banner_tiltle.add(" 三星魅力 ");
        banner_tiltle.add(" 摩登新秋 ");
        banner_tiltle.add(" JD.COM京东 ");
        //Banner加载图片
        banner.setImages(banner_image)
//                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
//                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
//                .setBannerStyle(BannerConfig.DURATION)
                .setBannerStyle(BannerConfig.LEFT)
//                .setIndicatorGravity(BannerConfig.RIGHT)
//                .setBannerStyle(BannerConfig.NUM_INDICATOR)
//                .setBannerStyle(BannerConfig.TITLE_BACKGROUND)
//                .setBannerStyle(BannerConfig.TITLE_TEXT_COLOR)
                .setBannerAnimation(Transformer.Accordion)
                .setBannerTitles(banner_tiltle)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                })
                .setDelayTime(4000)
                .start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getActivity(), banner_tiltle.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
