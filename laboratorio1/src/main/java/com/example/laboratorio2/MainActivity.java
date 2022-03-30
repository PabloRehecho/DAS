package com.example.laboratorio2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int numeroGiros = 0;
    private String state_values= "Estados ";


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!= null)
        {
            numeroGiros = savedInstanceState.getInt("nGiros");
            state_values = savedInstanceState.getString("estados");

            TextView cont = (TextView)findViewById(R.id.Contador);
            cont.setText("numero de giros = " + numeroGiros);
            Log.i("labo2",numeroGiros + "--" + state_values);
            TextView estados = (TextView) findViewById(R.id.Orientacion);
            estados.setText(state_values);
        }
        else
        {
            Log.i("labo2","fallos");
        }



    }

    @Override
    protected void onStart() {
        super.onStart();
        state_values = state_values + "Start-";
        Log.i("labo2","onStart --" + state_values);
    }

    @Override
    protected void onStop() {
        super.onStop();
        state_values = state_values + "Stop-";
        Log.i("labo2","onStop --" + state_values);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        numeroGiros++;
        outState.putInt("nGiros", numeroGiros);
        outState.putString("estados",state_values);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        state_values = state_values + "Destroy-";
        Log.i("labo2","onDestroy --" + state_values);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        state_values = state_values + "Pause-";
        Log.i("labo2","onPause --" + state_values);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        state_values = state_values + "Resume-";
        Log.i("labo2","onResume --" + state_values);
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        state_values = state_values + "Restart-";
        Log.i("labo2","onRestart --" + state_values);
    }


}