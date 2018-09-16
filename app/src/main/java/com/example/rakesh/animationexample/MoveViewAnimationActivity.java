package com.example.rakesh.animationexample;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;

public class MoveViewAnimationActivity extends AppCompatActivity {
    private ObjectAnimator objectAnimator;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_view_animation);
        imageView = findViewById(R.id.image_view_ball);

        /*objectAnimator = ObjectAnimator.ofFloat(imageView,"translationX",100f);
        objectAnimator.setDuration(3000);
*/
        // ViewPropertyAnimator (alternate way to simple animate multiple property of view in simple way)
        //imageView.animate().translationXBy(200f).setDuration(2000).start();


        // arcTo() and PathInterpolator only available on API 21+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Path path = new Path();
            float x = imageView.getX();
            float y = imageView.getY();
            path.moveTo(x + 0, y + 0);
            path.lineTo(x + 100, y + 150);
            path.lineTo(x + 400, y + 150);
            path.lineTo(x + 0, y + 0);
            //path.arcTo(0f, 0f, 500f, 500f, 0f, 180f, true);
           // PathInterpolator pathInterpolator = new PathInterpolator(path);
           // objectAnimator.setInterpolator(pathInterpolator);
            objectAnimator = ObjectAnimator.ofFloat(imageView, View.X,View.Y,path);
            objectAnimator.setDuration(3000);
            objectAnimator.start();
        }

    }
}
