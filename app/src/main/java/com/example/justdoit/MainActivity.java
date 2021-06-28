package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progress_bar);
        VideoView videoview = (VideoView) findViewById(R.id.videoview);

        videoview.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.justdoitcell);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoview);
        videoview.setMediaController(mediaController);
        videoview.start();

        progressBar.setMax(100);
        progressBar.setScaleY(5f);
        progressAnimation();

    }
    public void progressAnimation(){
        ProgressBarAnimation animation = new ProgressBarAnimation(this, progressBar,0f,100f);
        animation.setDuration(8000);
        progressBar.setAnimation(animation);
    }
}