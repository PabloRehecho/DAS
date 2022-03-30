package com.example.laboratorio4;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class ClaseDialogo extends DialogFragment
{
    ListenerdelDialogo miListener;
    public int selec;
    public interface ListenerdelDialogo {
        void alpulsarOK(int i);
    }
    //@NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        super.onCreateDialog(savedInstanceState);
        miListener =(ListenerdelDialogo) getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Elige el nivel de dificultad");
        CharSequence[] opciones = {"Fácil", "Medio", "Difícil"};
        builder.setSingleChoiceItems(opciones, -1, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                selec=i;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                miListener.alpulsarOK(selec);
            }
        });
        return builder.create();
    }
}
