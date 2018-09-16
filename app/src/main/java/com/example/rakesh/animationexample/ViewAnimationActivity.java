package com.example.rakesh.animationexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAnimationActivity extends AppCompatActivity {
    TextView mTextview;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        getSupportActionBar().setTitle("ViewAnimationActivity");
        mTextview = findViewById(R.id.text_view);

        animation = AnimationUtils.loadAnimation(this,R.anim.text_animation);
        mTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextview.startAnimation(animation);
            }
        });
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(ViewAnimationActivity.this, "Animation is complete!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
