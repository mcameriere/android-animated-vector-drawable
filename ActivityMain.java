package com.hfad.animatedvectordrawablesample;

import android.app.Activity;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAnimate(View view) {
        ImageView iv = (ImageView)findViewById(R.id.animatableImageView);
        AnimatedVectorDrawable avd = (AnimatedVectorDrawable)iv.getDrawable();
        avd.start();
    }
}
