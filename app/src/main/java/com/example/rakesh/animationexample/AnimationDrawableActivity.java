package com.example.rakesh.animationexample;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AnimationDrawableActivity extends AppCompatActivity {
    private ImageView imageViewDrawable;
    private ImageView imageViewAnimatedVector;
    private AnimationDrawable playPauseAnimation;
    private Drawable animatedVectorDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable);
        //---------------------------AnimationDrawable------------------------------------
        imageViewDrawable = findViewById(R.id.imageView_animation_drawable);
        imageViewDrawable.setBackgroundResource(R.drawable.play_pause);
        //getting drawable from imageView's background and converting into AnimationDrawable
        playPauseAnimation = (AnimationDrawable)imageViewDrawable.getBackground();

        imageViewDrawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animationDrawable will be running forever after first animation and animation will not start 2nd time.
                //to start animation 2nd time stop previous animation and start again
                if (playPauseAnimation.isRunning()){
                    playPauseAnimation.stop();
                    playPauseAnimation.start();
                }else {
                    //starting animation 1st time
                    playPauseAnimation.start();
                }
            }
        });

        //----------------------------AnimatedVectorDrawable------------------------------
        imageViewAnimatedVector = findViewById(R.id.imageView_animation_vector);
        animatedVectorDrawable = imageViewAnimatedVector.getBackground();
        imageViewAnimatedVector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (animatedVectorDrawable instanceof Animatable){
                        ((Animatable) animatedVectorDrawable).start();
                    }
                }
        });

    }
}
