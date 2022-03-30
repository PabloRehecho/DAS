package com.example.laboratorio5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class AlumnInfoFragment extends Fragment
{


    public interface listenerDelFragment
    {
        String[] seleccionarElemento(int elemento);
    }
    private listenerDelFragment elListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v= inflater.inflate(R.layout.fragment_alumn_info,container,false);
        return v;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        TextView laetiqueta= getView().findViewById(R.id.infoFragment);

    }

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
    }

    public void mostrarAlumno(int elemento)
    {
        String[] datos=elListener.seleccionarElemento(elemento);
        TextView nombre = getView().findViewById(R.id.textView3);
        nombre.setText(datos[0]);
        TextView apellido = getView().findViewById(R.id.textView4);
        apellido.setText(datos[1]);
        TextView telefono = getView().findViewById(R.id.textView5);
        telefono.setText(datos[2]);
    }
}