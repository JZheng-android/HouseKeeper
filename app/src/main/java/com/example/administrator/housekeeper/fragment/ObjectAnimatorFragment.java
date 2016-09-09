package com.example.administrator.housekeeper.fragment;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.TargetApi;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.housekeeper.R;

/**
 * Created by Administrator on 2016/9/9.
 */
public class ObjectAnimatorFragment extends Fragment//导v4包
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_picture,null);//渲染器，返回view
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_a1);//找到指定图片
        //动画设置，动画渲染来自动画（上下文，动画设置）
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(),R.animator.property_animator);
        animatorSet.setTarget(imageView);//动画加载图片
        animatorSet.start();//开始
        return  view;
    }
}
