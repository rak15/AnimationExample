package com.example.rakesh.animationexample;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class PropertyAnimationXmlView extends View {
    private float mX;
    private float mY;
    private float mRadius;
    private int mColor;
    private Paint mPaint = new Paint();
    private AnimatorSet mPulseAnimatorSet;
    Context mContext;

    public PropertyAnimationXmlView(Context context) {
        super(context);
    }

    public PropertyAnimationXmlView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void setRadius(float radius){
        mRadius = radius;
        //setRadius() and setColor() will be called together because of animator set. So calling invalidate() only at 1 place.
        invalidate();
    }

    public void setColor(int color){
        mColor = color;
        mPaint.setColor(color);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN){

            // Where the center of the circle will be.
            mX = event.getX();
            mY = event.getY();

            // If there is an animation running, cancel it.
            // This resets the AnimatorSet and its animations to the starting values.
            if(mPulseAnimatorSet != null && mPulseAnimatorSet.isRunning()) {
                mPulseAnimatorSet.cancel();
            }
            // Start the animation sequence.
            mPulseAnimatorSet.start();
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mPulseAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,R.animator.animator_set);
        mPulseAnimatorSet.setTarget(this);
        //get particular animator to add listener
        ArrayList<Animator> animators= mPulseAnimatorSet.getChildAnimations();
        Animator animator3 = animators.get(1);
        animator3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(mContext.getApplicationContext(), "Animation Ended!", Toast.LENGTH_SHORT).show();
            }
        });
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mX,mY,mRadius,mPaint);
    }
}
