package com.apaza.moises.practicegreendao.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.apaza.moises.practicegreendao.MainActivity;
import com.apaza.moises.practicegreendao.R;

public class SplashActivity extends AppCompatActivity {

    private TextView counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        counter = (TextView)findViewById(R.id.counter);

        startSplash();
    }

    private void startSplash(){
        new CountDownTimer(7000, 1000) {
            public void onTick(long millisUntilFinished) {
                counter.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                counter.setText("Go!");
                goToMainActivity();
                //goToSignUpActivity();
            }
        }.start();
    }

    private void goToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToSignUpActivity(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
