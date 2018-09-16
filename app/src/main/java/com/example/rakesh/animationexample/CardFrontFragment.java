package com.example.rakesh.animationexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CardFrontFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.frag_card_front,null);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RevealHideViewCardflipActivity)v.getContext()).startAnimation();
            }
        });
        return  v;
    }
}
