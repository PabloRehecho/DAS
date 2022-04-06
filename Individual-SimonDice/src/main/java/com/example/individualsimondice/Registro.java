package com.example.individualsimondice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void onClickTerminarRegistro(View v)
    {
        if(true)
        {
            Intent intentTerminarRegistro= new Intent(Registro.this, MainActivity.class);
            startActivity(intentTerminarRegistro);
        }

    }
}