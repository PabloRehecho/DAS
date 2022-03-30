package com.example.laboratorio5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;


public class AlumnListFragment extends ListFragment
{
    private String[] datos;
    public interface listenerDelFragment
    {
        void seleccionarElemento(String elemento);
    }
    private listenerDelFragment elListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v= inflater.inflate(R.layout.fragment_alumn_list,container,false);
        return v;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, datos));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        elListener.seleccionarElemento(datos[position]);

    }

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        try
        {
            elListener=(listenerDelFragment) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException("La clase " +context.toString() + "debe implementar listenerDelFragment");
        }
    }
}