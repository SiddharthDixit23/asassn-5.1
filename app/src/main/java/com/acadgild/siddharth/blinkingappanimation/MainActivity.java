package com.acadgild.siddharth.blinkingappanimation;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{

    private TextView mtv;
    private Button mbtn;
    Animation animFadeIn,animFadeOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtv = (TextView) findViewById(R.id.tvx);
        mbtn = (Button) findViewById(R.id.button);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);

        animFadeIn.setAnimationListener(this);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mtv.startAnimation(animFadeIn);

            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(getApplicationContext(),"Animation Started",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(animation==animFadeIn)
        {
            Toast.makeText(getApplicationContext(), "Animation Stopped", Toast.LENGTH_SHORT).show();
            animFadeOut.start();
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}
