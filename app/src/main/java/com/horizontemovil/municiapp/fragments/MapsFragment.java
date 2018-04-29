package com.horizontemovil.municiapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.horizontemovil.municiapp.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment  {
    MapView mapView;
    Bundle bundle;


    public MapsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maps, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Creacion y carga asincrona del mapa
        mapView = (MapView) view.findViewById(R.id.map_client);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(mMapAsync);
    }
    //Callback cuando el mapa esta listo para ubicar informacion del cliente
    private OnMapReadyCallback mMapAsync = new OnMapReadyCallback() {
        @Override public void onMapReady(GoogleMap googleMap) {
            if (googleMap != null) {
                bundle = getArguments();
                LatLng clientLocation = new LatLng(bundle.getDouble("clientLatitude"), bundle.getDouble("clientLongitude"));
                googleMap.addMarker(new MarkerOptions().position(clientLocation).title(bundle.getString("clientName")));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(clientLocation));
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(18), 500, null);
            }
        }};


}
