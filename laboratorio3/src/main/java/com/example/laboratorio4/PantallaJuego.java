package com.example.laboratorio4;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PantallaJuego extends AppCompatActivity
{
    String nivelDificultad="???";
    int dificultad;
    int numeroIntentos;
    int numeroAdivinar;
    int[] aciertos;
    String fallos="";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            dificultad= extras.getInt("dificultad");
            if (dificultad==0){nivelDificultad="Facil";}
            else if (dificultad==1){nivelDificultad="Medio";}
            else if (dificultad==2){nivelDificultad="Difícil";}
        };
        numeroAdivinar= generarRandom();
        numeroIntentos=15-dificultad*3;
        TextView arribaIzquierda = (TextView) findViewById(R.id.TextViewDificultad);
        arribaIzquierda.setText("Nivel de dificultad: " + nivelDificultad + "\nTe quedan " + numeroIntentos + " intentos\n" + numeroAdivinar);
    }

    public int generarRandom()
    {
        Random generador =new Random();
        int numero=0;
        while (numero<1000 || numero>=10000 )
        {
            numero=generador.nextInt(10000);
        }
        return numero;
    }

    public void comprobarNumero(int numero)
    {
        if (numero==numeroAdivinar)
        {
            int tiempo= Toast.LENGTH_SHORT;
            Toast aviso = Toast.makeText(this, "Has ganado", tiempo);
            aviso.setGravity(Gravity.TOP| Gravity.LEFT, 0, 0);
            aviso.show();
        }
        else
        {
            fallos=fallos + Integer.toString(numero);
            TextView fallos = (TextView) findViewById(R.id.textView4);
            fallos.setText((CharSequence) fallos);
            numeroIntentos--;
        }
    }

    public void onClickAdivinar(View v)
    {
        EditText ETnumeroNuevo= (EditText) findViewById(R.id.EditTextNúmero);
        int numeroNuevo = Integer.parseInt(ETnumeroNuevo.getText().toString());
        comprobarNumero(numeroNuevo);
    }
}