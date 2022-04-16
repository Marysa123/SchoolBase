package com.example.schoolbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

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

        splash_images.animate().translationX(1400).setDuration(2000).setStartDelay(4000);
        logo.animate().translationX(1400).setDuration(2000).setStartDelay(4000);
        text_bot.animate().translationX(1400).setDuration(2000).setStartDelay(4000);
        background.animate().translationX(1400).setDuration(2000).setStartDelay(4000);

        lottieAnimationView.animate().setDuration(4000).setStartDelay(0);
        lottieAnimationView.animate().translationX(1400).setDuration(2000).setStartDelay(4000);


    }
}