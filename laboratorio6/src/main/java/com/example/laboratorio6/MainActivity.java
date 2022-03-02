package com.example.laboratorio6;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

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
                texto.setText("aaa"+ id);
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
}