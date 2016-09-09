package com.example.administrator.housekeeper;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.housekeeper.fragment.ObjectAnimatorFragment;
import com.example.administrator.housekeeper.fragment.ViewAnimFragment;

/**
 * Created by Administrator on 2016/9/9.
 */
public class AnimationActivity extends AppCompatActivity {
    private Fragment fragment;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.frament);
    }
      /*  ImageView imageView = (ImageView) findViewById(R.id.iv_a1);
       AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                R.animator.property_animator);
        set.setTarget(imageView);
        set.start();*/
    // ObjectAnimatorFragment oafragment = new ObjectAnimatorFragment();
      /* getSupportFragmentManager().beginTransaction().
               add(R.id.fm,new ObjectAnimatorFragment());*/
    public void view(View view) {
        //简写方式
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
            transaction.remove(fragment);
        }
        fragment = new ViewAnimFragment();
        transaction.replace(R.id.fm, fragment).commit();
    }

    public void object(View view) {
        //简写方式
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
            transaction.remove(fragment);
        }
        fragment = new ObjectAnimatorFragment();
        transaction.replace(R.id.fm, fragment).commit();
    }

}
