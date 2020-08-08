package com.example.liangxq.shopping.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.liangxq.shopping.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter {
    private ArrayList<String> mlist;
    private ArrayList<String> mzhong;
    private ArrayList<String> mmei;
    private Context mcontxt;

    public RecyclerAdapter(ArrayList<String> mlist, ArrayList<String> mzhong, ArrayList<String> mmei, Context mcontxt) {
        this.mlist = mlist;
        this.mzhong = mzhong;
        this.mmei = mmei;
        this.mcontxt = mcontxt;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View inflate = View.inflate(mcontxt, R.layout.item_onefragment_recyeler, null);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
//        String s1 = mlist.get(i);
//        String s2 = mzhong.get(i);
//        String s3 = mmei.get(i);
        Glide.with(mcontxt).load(mlist.get(i)).into(holder.image_onefragmnent);
        holder.tv_mei_onefragmnent.setText(mmei.get(i));
        holder.tv_zhong_onefragmnent.setText(mzhong.get(i));
        holder.tv_mei_onefragmnent.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image_onefragmnent;
        public TextView tv_zhong_onefragmnent;
        public TextView tv_mei_onefragmnent;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image_onefragmnent = (ImageView) rootView.findViewById(R.id.image_onefragmnent);
            this.tv_zhong_onefragmnent = (TextView) rootView.findViewById(R.id.tv_zhong_onefragmnent);
            this.tv_mei_onefragmnent = (TextView) rootView.findViewById(R.id.tv_mei_onefragmnent);
        }

    }
}
