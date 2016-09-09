package com.example.administrator.housekeeper;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/9/9.
 */
public class AnimatorActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_animator);
        ImageView imageView = (ImageView) findViewById(R.id.iv_a1);
       AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                R.animator.property_animator);
        set.setTarget(imageView);
        set.start();

    }
}
