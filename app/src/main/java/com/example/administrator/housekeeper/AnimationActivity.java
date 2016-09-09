package com.example.administrator.housekeeper;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.administrator.housekeeper.fragment.ObjectAnimatorFragment;

/**
 * Created by Administrator on 2016/9/9.
 */
public class AnimationActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.frament);
      /*  ImageView imageView = (ImageView) findViewById(R.id.iv_a1);
       AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                R.animator.property_animator);
        set.setTarget(imageView);
        set.start();*/
       // ObjectAnimatorFragment oafragment = new ObjectAnimatorFragment();
       getSupportFragmentManager().beginTransaction().add(R.id.fm , new ObjectAnimatorFragment()).commit();
    }
}
