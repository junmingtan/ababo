package com.ababo.tanjunming.ababo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(MapsActivity.this, MainActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(MapsActivity.this, Donate.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(MapsActivity.this, Explore.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_notifications);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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

        // Add a marker in Sydney and move the camera
        LatLng singapore = new LatLng(1.352083, 103.819830);
        LatLng bloodBankWoodlands = new LatLng(1.435330, 103.787600);
        LatLng bloodBankWestgate = new LatLng(1.334440, 103.742830);
        LatLng bloodBankHSA = new LatLng(1.281040, 103.838950);
        LatLng bloodBankDhoby = new LatLng(1.294460, 103.848070);

        mMap.addMarker(new MarkerOptions().position(bloodBankWoodlands).title("Bloodbank@Woodlands"));
        mMap.addMarker(new MarkerOptions().position(bloodBankWestgate).title("Bloodbank@Westgate Tower"));
        mMap.addMarker(new MarkerOptions().position(bloodBankHSA).title("Bloodbank@HSA"));
        mMap.addMarker(new MarkerOptions().position(bloodBankDhoby).title("Bloodbank@DhobyGhaut"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(singapore, 11.0f));
    }
}
