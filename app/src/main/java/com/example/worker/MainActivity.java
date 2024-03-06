package com.example.worker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startMusicWorker();
    }

    private void startMusicWorker() {
        OneTimeWorkRequest musicWorker = new OneTimeWorkRequest.Builder(wokerClass.class).build();
        WorkManager.getInstance(MainActivity.this).enqueue(musicWorker);
    }
}