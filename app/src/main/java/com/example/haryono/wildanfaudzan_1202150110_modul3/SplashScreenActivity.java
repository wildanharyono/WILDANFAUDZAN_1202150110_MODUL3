package com.example.haryono.wildanfaudzan_1202150110_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {

    public static int SPLASH_TIME_OUT=4000; //Inisiasi splash

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Toast.makeText(this, "Wildan Faudzan Maulana Haryono_1202150110", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() { //inisiasi handler
            @Override
            public void run() { //inisiasi method run
                Intent homeIntent = new Intent(SplashScreenActivity.this, LogInActivity.class); //inisiasi intent
                startActivity(homeIntent);  //memanggil method start
                finish(); //memanggil method finish
            }
        },SPLASH_TIME_OUT); //tag penutup splash
    }
}