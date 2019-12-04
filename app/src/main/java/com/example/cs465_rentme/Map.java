package com.example.cs465_rentme;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(15);
        mMap.setMaxZoomPreference(20);
        mMap.setOnInfoWindowClickListener(this);
        // Add a marker in Siebel and move the camera
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.116566, -88.222277)).
                        title("Weber Grill").snippet("$20 / day").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.112021, -88.222953)).
                title("Phantom 4 Drone Set").snippet("$50 / day").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.115631, -88.226322)).
                title("Golf Clubs").snippet("$30 / day").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.114113, -88.227652)).
                title("12 Person Tent").snippet("$50 / day").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.113858, -88.224896)).
                        title("Your Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(40.113858, -88.224896)));
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(Map.this, RentPageOne.class);
        startActivity(intent);
    }
}
