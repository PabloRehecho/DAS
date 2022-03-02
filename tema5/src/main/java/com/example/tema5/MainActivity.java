package com.example.tema5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogFragment dialogoAlerta= new ClaseDialogo();
        dialogoAlerta.show(getSupportFragmentManager(), "etiqueta");
    }


}