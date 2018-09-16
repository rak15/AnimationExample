package com.example.rakesh.animationexample;

import android.content.Context;
import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class FlingView extends AppCompatImageView {
    public FlingView(Context context) {
        super(context);
    }

    public FlingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                // Create an animation that rotates around the views X value.
                FlingAnimation fling = new FlingAnimation(
                        this, DynamicAnimation.ROTATION_X);
                // Set parameters and constraints for the animation.
                // This does almost a full rotation, but not quite.
                // Play with these values!
                fling.setStartVelocity(150) // In pixels per second.
                        .setFriction(0.11f) // Friction slows animation.
                        .start();
                break;
            default:
                // Do nothing.
        }
        return super.onTouchEvent(event);
    }
}
