package com.example.laboratorio6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.barra, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        TextView texto=findViewById(R.id.textView);
        int id=item.getItemId();
        switch (id)
        {
            case R.id.Opcion1:
            {
                texto.setText("Enviando mail"+ id);
                sendMail();


                break;
            }
            case R.id.OpcionOculta:
            {
                texto.setText("bbbbbbb" + id);
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    public void sendMail() {
        Log.i("Send email", "");
        String[] TO = {"abc@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

        emailIntent.setData(Uri.parse("mailto:"));
        //emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "DAS");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hola, hello, kaixo");

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar correo..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}