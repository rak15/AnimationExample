package com.example.rakesh.animationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class LayoutChangeWithTransitionActivity extends AppCompatActivity {
    private Scene mAScene;
    private Scene mAnotherScene;
    private ViewGroup mSceneRoot; //frame layout whose child views will change
    private Transition mChangeBoundTransition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_change_with_transition);
        getSupportActionBar().setTitle("LayoutChangeWithTransitionActivity");

        // Create the scene root for the scenes in this app
        mSceneRoot = findViewById(R.id.scene_root);

        // Create the scenes
        mAScene = Scene.getSceneForLayout(mSceneRoot, R.layout.a_scene, this);
        mAnotherScene = Scene.getSceneForLayout(mSceneRoot, R.layout.another_scene, this);

        // Inflate a Transition instance inside your activity from a resource file
        mChangeBoundTransition = TransitionInflater.from(this).inflateTransition(R.transition.change_bound_transition);

        mSceneRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //changing the layout within activity with animation
                TransitionManager.go(mAnotherScene,mChangeBoundTransition);
            }
        });
    }
}
