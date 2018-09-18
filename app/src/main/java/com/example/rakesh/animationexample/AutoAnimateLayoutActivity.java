package com.example.rakesh.animationexample;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AutoAnimateLayoutActivity extends AppCompatActivity implements View.OnClickListener{
    ViewGroup viewGroup;
    int c;
    Button b1,b2,b3,b4;
    private TextView newView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_animate_layout);
        getSupportActionBar().setTitle("AutoAnimateLayoutActivity");

        b1 = findViewById(R.id.button101);
        b2 = findViewById(R.id.button102);
        b3 = findViewById(R.id.button103);
        b4 = findViewById(R.id.button104);
        viewGroup = findViewById(R.id.layout);

        viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button101:
                addItem();
                break;
            case R.id.button102:
                removeItem();
                break;
            case R.id.button103:
                setViewGone();
                break;
            case R.id.button104:
                setViewVisible();
                break;
                default: //do nothing
        }
    }

    private void addItem(){
        newView = new TextView(this);
        newView.setPadding(10,20,10,20);
        newView.setText(String.valueOf(c++));
        newView.setTextColor(ContextCompat.getColor(this,R.color.colorAccent));
        newView.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));

        viewGroup.addView(newView,0);  //index 0 means this new view will be added to the top of all previous views

    }

    private void removeItem(){
        if (newView != null){
            viewGroup.removeView(newView);
        }
    }

    private void setViewGone(){
        if (newView != null){
            if (newView.getVisibility() == View.VISIBLE){
                newView.setVisibility(View.GONE);
            }
        }
    }

    private void setViewVisible(){
        if (newView != null){
            if (newView.getVisibility() == View.GONE){
                newView.setVisibility(View.VISIBLE);
            }
        }
    }
}
