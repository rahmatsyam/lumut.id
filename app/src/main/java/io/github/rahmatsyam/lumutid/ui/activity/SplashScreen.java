package io.github.rahmatsyam.lumutid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceStated) {
        super.onCreate(savedInstanceStated);

        startActivity(new Intent(this, MainActivity.class));

        finish();


    }
}
