package com.example.laboratorio7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private Reproductor elservicio;
    private boolean connected=false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickPlay(View v)
    {
        connected=true;
        Intent intent = new Intent(this, Reproductor.class);
        bindService(intent, laconexion, Context.BIND_AUTO_CREATE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            startForegroundService(intent);
        }
        else
        {
            startService(intent);
        }
    }

    public void onClickStop(View v)
    {
        if (connected)
        {
            connected=false;
            unbindService(laconexion);
        }
    }

    private ServiceConnection laconexion= new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            elservicio=((Reproductor.miBinder)service).obtenServicio();
        }
        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            elservicio=null;
        }
    };
}