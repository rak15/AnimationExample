package com.example.rakesh.animationexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b10 = findViewById(R.id.button10);
        b11 = findViewById(R.id.button11);
        b12 = findViewById(R.id.button12);
        b13 = findViewById(R.id.button13);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity",String.valueOf(R.id.button1));
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        Log.d("MainActivity",String.valueOf(v.getId()));
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, ViewAnimationActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, PropertyAnimationXmlActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, PhysicsAnimationActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this, AnimationDrawableActivity.class));
                break;
            case R.id.button6:
                startActivity(new Intent(this, RevealHideViewCrossfadeActivity.class));
                break;
            case R.id.button7:
                startActivity(new Intent(this, RevealHideViewCardflipActivity.class));
                break;
            case R.id.button8:
                startActivity(new Intent(this, MoveViewAnimationActivity.class));
                break;
            case R.id.button9:
                startActivity(new Intent(this, ZoomAnimationActivity.class));
                break;
            case R.id.button10:
                startActivity(new Intent(this, AutoAnimateLayoutActivity.class));
                break;
            case R.id.button11:
                startActivity(new Intent(this, LayoutChangeWithTransitionActivity.class));
                break;
            case R.id.button12:
                startActivity(new Intent(this, AnimationWithActivity1.class));
                break;
            case R.id.button13:
                startActivity(new Intent(this, AnimatedVectorDrawableActivity.class));
                break;
            default: //do nothing
        }
    }
}
