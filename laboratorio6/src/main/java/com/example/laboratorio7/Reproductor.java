package com.example.laboratorio7;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

public class Reproductor extends Service {

    private final IBinder elBinder= new miBinder();
    private MediaPlayer media;

    public Reproductor()
    {
    }


    @Override
    public void onCreate()
    {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        lanzarNotificacion();
        media = MediaPlayer.create(this, R.raw.Rick);
        media.start();
        return super.onStartCommand(intent, flags, startId);
    }

    private void lanzarNotificacion()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager elmanager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel canalservicio = new NotificationChannel("IdCanal",
                    "NombreCanal",NotificationManager.IMPORTANCE_DEFAULT);
            elmanager.createNotificationChannel(canalservicio);
            Notification.Builder builder = new Notification.Builder(this, "IdCanal")
                    .setContentTitle(getString(R.string.app_name))
                    .setAutoCancel(false);
            Notification notification = builder.build();
            startForeground(1, notification);
        }
    }

    @Override
    public void onDestroy()
    {
        media.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return elBinder;
    }

    @Override
    public boolean onUnbind(Intent intent)
    {
        media.stop();
        stopSelf();
        return super.onUnbind(intent);
    }

    public class miBinder extends Binder
    {
        Reproductor obtenServicio()
        {
            return Reproductor.this;
        }
    }

}