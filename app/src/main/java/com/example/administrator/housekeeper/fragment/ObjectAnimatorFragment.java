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
public class ObjectAnimatorFragment extends Fragment
{
    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_picture,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_a1);
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(),R.animator.property_animator);
        animatorSet.setTarget(imageView);
        animatorSet.start();
        return  view;
    }
}
