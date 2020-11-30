package com.official.g2s.epresence;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView logo,tagline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Animation animationLogo= AnimationUtils.loadAnimation(this, R.anim.up_to_down);
        Animation animationTag= AnimationUtils.loadAnimation(this, R.anim.fadein);

        logo=(ImageView) findViewById(R.id.logo);
        tagline=(ImageView) findViewById(R.id.tagline);

        logo.setAnimation(animationLogo);
        tagline.setAnimation(animationTag);

        Handler handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent switchActivity=new Intent(SplashScreen.this,WelcomeScreen.class);
                startActivity(switchActivity);
                finish();
            }
        },5000);
    }
}
