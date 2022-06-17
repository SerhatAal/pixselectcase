package com.example.pixselectcase.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.pixselectcase.MainActivity;
import com.example.pixselectcase.databinding.ActivitySplashBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;
    private int progressStatus = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        new Thread(() -> {
            while (progressStatus < 100) {
                progressStatus += 20;
                handler.post(() -> {
                    binding.progressBar.setProgress(progressStatus);
                    binding.textViewProgressBar.setText(progressStatus + "/" + binding.progressBar.getMax());
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            finish();
            
        }).start();
    }
}

