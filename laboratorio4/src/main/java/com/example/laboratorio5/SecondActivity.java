package com.example.laboratorio5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements AlumnInfoFragment.listenerDelFragment
{
    String[] nombres= {"A","B","C","D","E"};
    String[] apellidos= {"f","g","h","i","j"};
    int[] telefonos= {1,2,3,4,5};
    String[] datos = new String[3];

    @Override
    public String[] seleccionarElemento(int elemento)
    {
        datos[0]=nombres[elemento];
        datos[1]=apellidos[elemento];
        datos[2]= String.valueOf(telefonos[elemento]);
        return datos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        int elemento=savedInstanceState.getInt("contenido");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        AlumnInfoFragment elotro = (AlumnInfoFragment) getSupportFragmentManager().findFragmentById(R.id.infoFragment);
        String informacion=getIntent().getStringExtra("contenido");
        elotro.mostrarAlumno(elemento);
    }
}