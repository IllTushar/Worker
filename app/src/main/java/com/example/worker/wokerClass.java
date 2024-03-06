package com.example.worker;

import android.content.Context;
import android.media.MediaPlayer;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class wokerClass extends Worker {
    private MediaPlayer mediaPlayer;

    public wokerClass(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        mediaPlayer = MediaPlayer.create(context, R.raw.tone);
        mediaPlayer.setLooping(true);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            //Start after 1 min
            Thread.sleep(60 * 1000);
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
            //Stop after 2 min
            Thread.sleep(60 * 1000);
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Result.failure();
        }
        return Result.success();
    }

}
