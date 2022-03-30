package com.example.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SegundaActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onClick2(View v)
    {
        EditText tareaNueva= findViewById(R.id.nombreTarea);
        String nombreTarea= tareaNueva.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("nombreTarea", nombreTarea);
        setResult(RESULT_OK, intent);
        finish();

    }
}