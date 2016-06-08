package com.example.xavier.fireprotect.MainActivityScreens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.xavier.fireprotect.R;


/**
 * Created by xavier i dídac
 */


public class Intro extends Activity {

    private final int TIME_SPLASH = 3000; // 3 segundos

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(Intro.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, TIME_SPLASH);
    }
}