package com.example.laboratorio5;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AlumnListFragment.listenerDelFragment
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seleccionarElemento(int elemento){
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            //EL OTRO FRAGMENT EXISTE
            AlumnInfoFragment elotro=(AlumnInfoFragment) getSupportFragmentManager().
            findFragmentById(R.id.infoFragment);
            elotro.mostrarAlumno(elemento);
        }
        else
        {
            //EL OTRO FRAGMENT NO EXISTE, HAY QUE LANZAR LA ACTIVIDAD QUE LO CONTIENE
            Intent i= new Intent(this,SecondActivity.class);
            i.putExtra("contenido",elemento);
            startActivity(i);
        }
    }

    @Override
    public void seleccionarElemento(String elemento)
    {

    }
}