package com.example.schoolbase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.concurrent.TimeUnit;

public class IntroductoryActivity extends AppCompatActivity {

    ImageView logo,background,text_bot,splash_images;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);


        logo = findViewById(R.id.text_top);
        background = findViewById(R.id.backgroundlogo);
        text_bot = findViewById(R.id.text_bot);
        splash_images = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroductoryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);//Ставите сколько сек, 1000 = 1с.




    }
}