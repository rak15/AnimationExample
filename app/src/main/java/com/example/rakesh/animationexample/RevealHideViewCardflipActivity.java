package com.example.rakesh.animationexample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;

public class RevealHideViewCardflipActivity extends AppCompatActivity {

    private boolean mShowingBack;
    private View circularRevealView;
    private Button revealButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal_hide_view_cardflip);
        //-----------------------CardFlip Animation-----------------------
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new CardFrontFragment())
                    .commit();
        }

        //------------------CircularReveal Animation---------------------------------
        circularRevealView = findViewById(R.id.text_view_circular);
        revealButton = findViewById(R.id.button100);
        revealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateCircularReveal();
            }
        });
    }

    private void flipCard() {
        if (mShowingBack) {
            getFragmentManager().popBackStack();
            return;
        }

        // Flip to the back.

        mShowingBack = true;

        // Create and commit a new fragment transaction that adds the fragment for
        // the back of the card, uses custom animations, and is part of the fragment
        // manager's back stack.

        getFragmentManager()
                .beginTransaction()

                // Replace the default fragment animations with animator resources
                // representing rotations when switching to the back of the card, as
                // well as animator resources representing rotations when flipping
                // back to the front (e.g. when the system Back button is pressed).
                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)

                // Replace any fragments currently in the container view with a
                // fragment representing the next page (indicated by the
                // just-incremented currentPage variable).
                .replace(R.id.container, new CardBackFragment())

                // Add this transaction to the back stack, allowing users to press
                // Back to get to the front of the card.
                .addToBackStack(null)

                // Commit the transaction.
                .commit();
    }

    public void startAnimation(){
        flipCard();
    }

    /**
     * method for circularly reveal and hiding any view (here: textView)
     */
    private void animateCircularReveal(){

        // Check if the runtime version is at least Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            // get the center for the clipping circle
            int cx = circularRevealView.getWidth() / 2;
            int cy = circularRevealView.getHeight() / 2;

            // get the radius for the clipping circle
            float radius = (float) Math.hypot(cx, cy);
            Animator animator = null;
            //revealing the view
            if (circularRevealView.getVisibility() == View.INVISIBLE) {
                // create the animator for this view (the start radius is zero)
                animator = ViewAnimationUtils.createCircularReveal(circularRevealView, cx, cy, 0, radius);
                animator.setDuration(3000);
                // make the view visible and start the animation
                circularRevealView.setVisibility(View.VISIBLE);
            }else {
                // create the animator for this view (the end radius is zero)
                animator = ViewAnimationUtils.createCircularReveal(circularRevealView, cx, cy, radius,0);
                animator.setDuration(3000);
                // make the view invisible at the end of animation
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        circularRevealView.setVisibility(View.INVISIBLE);
                    }
                });

            }
            animator.start();
        }else{
            //for devices lower than lollipop we simply make the view visible/invisible
            // as circularReveal doesn't support below lollipop
            if (circularRevealView.getVisibility() == View.INVISIBLE) {
                circularRevealView.setVisibility(View.VISIBLE);
            }else {
                circularRevealView.setVisibility(View.INVISIBLE);
            }
        }
    }
}
