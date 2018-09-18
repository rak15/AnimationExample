package com.example.rakesh.animationexample;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;

public class AnimationWithActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            // Apply activity transition (Should be called before setting contentView)
            getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.END);
            //getWindow().setEnterTransition(new Explode());
            getWindow().setSharedElementEnterTransition(new ChangeImageTransform());
        }

        setContentView(R.layout.activity_animation_with2);
        getSupportActionBar().setTitle("AnimationWithActivity2");

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }
    }
}
