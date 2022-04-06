package com.example.conectargoogle;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment elfragmento =(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.mapa);
        elfragmento.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }
}