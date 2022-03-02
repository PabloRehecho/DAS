package com.example.laboratorio4;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity implements ClaseDialogo.ListenerdelDialogo
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //lanzarNotificacion();
    }


    public void lanzarNotificacion()
    {
        NotificationManager elManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder elBuilder = new NotificationCompat.Builder(this, "IdCanal");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel elCanal = new NotificationChannel("IdCanal", "NombreCanal",
                    NotificationManager.IMPORTANCE_DEFAULT);
            elCanal.setDescription("Canal01");
            elCanal.enableLights(true);
            elCanal.setLightColor(Color.RED);
            elCanal.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            elCanal.enableVibration(true);
            elManager.createNotificationChannel(elCanal);
        }
        elBuilder.setSmallIcon(android.R.drawable.star_big_on)
                .setContentTitle("Notificacion")
                .setContentText("Ejemplo de notificación en labo 4.")
                .setSubText("Ejercicio1")
                .setVibrate(new long[]{0, 1000, 500, 1000})
                .setAutoCancel(true)
                ;
        elManager.notify(1, elBuilder.build());
    }

    public void onClickJugar(View v)
    {
        DialogFragment dialogoAlerta= new ClaseDialogo();
        dialogoAlerta.show(getSupportFragmentManager(), "etiqueta");
    }
    public void onClickInstrucciones(View v)
    {
        DialogFragment dialogoAlerta= new ClaseDialogo2();
        dialogoAlerta.show(getSupportFragmentManager(), "etiqueta");
    }
    @Override
    public void alpulsarOK(int seleccionado)
    {
        Intent i = new Intent (this, PantallaJuego.class);
        i.putExtra("dificultad",seleccionado);
        startActivity(i);

    }
}