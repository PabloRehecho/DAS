package com.example.laboratorio3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ArrayList<String> arrayDeTareas = new ArrayList<>();
    private ArrayAdapter eladaptador;
    private ListView listaTareas;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eladaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayDeTareas);
        listaTareas = findViewById(R.id.listaTareas);
        listaTareas.setAdapter(eladaptador);
        listaTareas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                arrayDeTareas.remove(i);
                eladaptador.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void onClick(View v)
    {
        Intent intent= new Intent(MainActivity.this, SegundaActividad.class);
        startActivityForResult(intent, 666);
    }

    public void onClickToast(View v)
    {
        int tiempo= Toast.LENGTH_SHORT;
        Toast aviso = Toast.makeText(this, "Eoeoeoeeoeoeoeoeoeoeoeoeoeo", tiempo);
        aviso.setGravity(Gravity.CENTER| Gravity.CENTER, 0, 0);
        aviso.show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 666 && resultCode == RESULT_OK)
        {
            String nuevaTarea = data.getStringExtra("nombreTarea");
            arrayDeTareas.add(nuevaTarea);
            eladaptador.notifyDataSetChanged();
        }
    }

}