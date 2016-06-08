package com.example.xavier.fireprotect.MainActivityScreens;

/**
 * Created by xavier on 7/06/16.
 */

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;

import com.example.xavier.fireprotect.R;
import com.example.xavier.myapplication.backend.messaging.Messaging;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by xavier i dídac
 */


public class Map extends AppCompatActivity implements OnMapReadyCallback {

    private static final LatLng CENTRECAT = new LatLng(41.837555, 1.537764);

    private static final LatLng PRADES = new LatLng(41.283540, 0.976916);
    private static final LatLng MONTSEC = new LatLng(42.028382, 0.898003);
    private static final LatLng VIC = new LatLng(41.977763, 2.228778);
    private static final LatLng AIGUESTORTES = new LatLng(42.566905, 0.933564);
    private static final LatLng MONTSERRAT = new LatLng(41.600298, 1.807416);
    private static final LatLng ALBERA = new LatLng(42.409718, 3.032365);
    private static final LatLng LLEIDA = new LatLng(41.607644, 0.622699);

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                Messaging.Builder builder = new Messaging.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
                Messaging message = builder.build();
                try {
                    message.messagingEndpoint().sendMessage("Dades Actualitzades").execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
        setContentView(R.layout.map);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }


    public void showCatalunya(View v) {
        if (mMap == null) {
            return;
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CENTRECAT, 7f));
    }


    /**
     * Called when the map is ready to add all markers and objects to the map.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        final View mapView = getSupportFragmentManager().findFragmentById(R.id.map).getView();
        if (mapView.getViewTreeObserver().isAlive()) {
            mapView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @SuppressWarnings("deprecation") // We use the new method when supported
                @SuppressLint("NewApi") // We check which build version we are using.
                @Override
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                        mapView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        mapView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    showCatalunya(null);
                    addMarkers();
                }
            });
        }
    }

    private void addMarkers() {
        mMap.addMarker(new MarkerOptions()
                .position(PRADES)
                .title("Muntanyes de Prades")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions()
                .position(MONTSEC)
                .title("Serra del Montsec")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        mMap.addMarker(new MarkerOptions()
                .position(VIC)
                .title("Plana de Vic")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions()
                .position(AIGUESTORTES)
                .title("Parc Nacional d'Aiguestortes")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions()
                .position(MONTSERRAT)
                .title("Muntanya de Montserrat")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        mMap.addMarker(new MarkerOptions()
                .position(ALBERA)
                .title("Massís de l'Albera")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.addMarker(new MarkerOptions()
                .position(LLEIDA)
                .title("Lleida")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
    }


}
