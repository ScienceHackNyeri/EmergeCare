package com.emergcare;



import android.app.Activity;
//import android.content.Context;
//import android.location.LocationListener;
//import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
public class MainActivity extends Activity {	 
    // Google Map
    private GoogleMap googleMap; 
    @Override    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        try {
            // Loading map
            initilizeMap(); 
         // Changing map type
         			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
         			// googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
         			// googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
         			// googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
         			 //googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

         			// Showing / hiding your current location
         			googleMap.setMyLocationEnabled(false);
         		

         			// Enable / Disable zooming controls
         			googleMap.getUiSettings().setZoomControlsEnabled(false);

         			// Enable / Disable my location button
         			googleMap.getUiSettings().setMyLocationButtonEnabled(true);

         			// Enable / Disable Compass icon
         			googleMap.getUiSettings().setCompassEnabled(true);

         			// Enable / Disable Rotate gesture
         			googleMap.getUiSettings().setRotateGesturesEnabled(true);

         			// Enable / Disable zooming functionality
         			googleMap.getUiSettings().setZoomGesturesEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    } 
    /**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();    
            
            // create marker
            MarkerOptions marker = new MarkerOptions().position(new LatLng(-0.423949, 36.935488)).title("Outspan Medical Hospital"+" Emergency Response Team").snippet(" Within a 3.48 KM radius"+" To the SW of current location"); 
            marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
            /*  Changing marker icon
            	marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.my_marker_icon));*/
            // VIOLET color icon            
            //new marker
            MarkerOptions marker1 = new MarkerOptions().position(new LatLng(-0.387047, 37.002507)).title("Kiganjo Medical Clinic" + " Light Emergency Handling").snippet(" Within a 5.53 KM radius"+" To the E of the current location" );        
            // GREEN color icon
            marker1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            
          //new marker
            MarkerOptions marker2 = new MarkerOptions().position(new LatLng(-0.42414, 36.93414)).title("MT KENYA HOSPITAL" + " Experienced Emergency Handling").snippet(" Within a 3.4 KM radius"+" To the SW of the current location" );        
            // AZURE color icon
            marker2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            
            //new marker
            MarkerOptions current = new MarkerOptions().position(new LatLng(-0.394228, 36.953369)).title("Dedan Kimathi University" + " Current Location" );        
            // RED color icon
            current.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            
            
            // adding marker
            googleMap.addMarker(marker);
            googleMap.addMarker(marker1);
            googleMap.addMarker(marker2);
            googleMap.addMarker(current);
            // check if map is created successfully or not            
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();              
             
            }
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }
 
}
 /*// Acquire a reference to the system Location Manager
    LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

    // Define a listener that responds to location updates
    LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
          // Called when a new location is found by the network location provider.
          makeUseOfNewLocation(location);
        }

        public void onStatusChanged(String provider, integer status, Bundle extras) {}

        public void onProviderEnabled(String provider) {}

        public void onProviderDisabled(String provider) {}
      };

    // Register the listener with the Location Manager to receive location updates
    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);*/
    
   /* private double[] createRandLocation(double latitude, double longitude) {

		return new double[] { latitude + ((Math.random() - 0.5) / 500),
				longitude + ((Math.random() - 0.5) / 500),
				150 + ((Math.random() - 0.5) * 10) };
	}*/
  