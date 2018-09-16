package com.example.rakesh.animationexample;

import android.content.Context;
import android.support.animation.DynamicAnimation;
import android.support.animation.FloatPropertyCompat;
import android.support.animation.SpringAnimation;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static android.support.animation.SpringForce.STIFFNESS_LOW;

public class SpringView extends AppCompatImageView {
    public SpringView(Context context) {
        super(context);
    }

    public SpringView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpringView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                // Create a spring animation along the view's Y position.
                // Let resting position be at the view's current Y position.
                final SpringAnimation anim = new SpringAnimation(this,
                        (FloatPropertyCompat) DynamicAnimation.Y, this.getY())
                        .setStartVelocity(10000); // In pixels per second.
                // Low stiffness makes the spring bouncy.
                anim.getSpring().setStiffness(STIFFNESS_LOW);
                anim.start();
                break;
            default:
                // Do nothing.
        }
        return super.onTouchEvent(event);
    }
}
