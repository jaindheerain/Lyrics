package com.apps.nishtha.lyrics;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.IBinder;

public class MyService extends Service {

    MusicReceiver musicReceiver;
    AudioManager audioManager;
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        musicReceiver = new MusicReceiver();

//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
                Intent i=new Intent();
                IntentFilter iF=new IntentFilter();

                // Read action when music player changed current song
                // stock music player
                iF.addAction("com.android.music.metachanged");

                // MIUI music player
                iF.addAction("com.miui.player.metachanged");

                // HTC music player
                iF.addAction("com.htc.music.metachanged");

                // WinAmp
                iF.addAction("com.nullsoft.winamp.metachanged");

                // MyTouch4G
                iF.addAction("com.real.IMP.metachanged");

                registerReceiver(musicReceiver, iF);
//            }
//        });

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
