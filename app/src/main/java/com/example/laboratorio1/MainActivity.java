package com.example.laboratorio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        TextView etiqueta1 = new TextView(this);
        etiqueta1.setText(i);

        TextView etiqueta2 = new TextView(this);
        etiqueta2.setText("oeoeoeoe");


        Button boton= new Button(this);
        boton.setText("pulsame");
        boton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                i++;
                etiqueta1.setText(i);
            }
        });
        LinearLayout ellayout = new LinearLayout(this);
        ellayout.setOrientation(LinearLayout.HORIZONTAL);
        ellayout.addView(etiqueta1);
        //ellayout.removeView(etiqueta1);
        ellayout.addView(boton);
        ellayout.addView(etiqueta2);
        //ellayout.removeView(etiqueta2);
        setContentView(ellayout);
    }
}