package com.example.rakesh.animationexample;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeScroll;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationWithActivity1 extends AppCompatActivity {
    Button button, button1, buttonMulti;
    View imageView, imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activity Transition is only available from lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Apply activity transition (Should be called before setting contentView)
            getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);  //this is necessary for startActivity(intent,bundle)
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);  //this will disable the default android animation

        }
        setContentView(R.layout.activity_animation_with1);
        getSupportActionBar().setTitle("AnimationWithActivity1");
        button = findViewById(R.id.button_activity_1);
        button1 = findViewById(R.id.button_share_one);
        buttonMulti = findViewById(R.id.button_share_multi);
        imageView = findViewById(R.id.image_activity_1);
        imageView2 = findViewById(R.id.image_activity_1_2);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimationWithActivity1.this,AnimationWithActivity2.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setExitTransition(new Explode());
                    ActivityOptions options = ActivityOptions
                            .makeSceneTransitionAnimation(AnimationWithActivity1.this);

                    startActivity(intent,options.toBundle());
                }else {
                    startActivity(intent);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimationWithActivity1.this,AnimationWithActivity2.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setSharedElementExitTransition(new ChangeImageTransform());
                    ActivityOptions options = ActivityOptions
                            .makeSceneTransitionAnimation(AnimationWithActivity1.this,
                                    imageView,"shared1");

                    startActivity(intent,options.toBundle());
                }else {
                    startActivity(intent);
                }
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnimationWithActivity1.this,AnimationWithActivity2.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setSharedElementExitTransition(new ChangeImageTransform());
                    ActivityOptions options = ActivityOptions
                            .makeSceneTransitionAnimation(AnimationWithActivity1.this,
                                    Pair.create(imageView,"shared1"),
                                    Pair.create(imageView2,"shared2"));
                    startActivity(intent,options.toBundle());
                }else {
                    startActivity(intent);
                }
            }
        });
    }
}
