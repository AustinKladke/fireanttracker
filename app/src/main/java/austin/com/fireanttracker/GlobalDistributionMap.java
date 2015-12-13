package austin.com.fireanttracker;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class GlobalDistributionMap extends FragmentActivity implements OnMapReadyCallback {
    Location location1;
    Location location2;
    SupportMapFragment mapFragment;
    GoogleMap map;
    private GoogleApiClient mGoogleApiClient;
    public static final String TAG = GlobalDistributionMap.class.getSimpleName();
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_distribution_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        // Enable Local Datastore.
        //Parse.enableLocalDatastore(this);
        //Parse.initialize(this, "bWzGUS3Mj00BHIax7d9kk21GKzoHq5Y3Yw2m9vSm", "p0wTCMhRH9HRUDYzlBzoZOdllm5qJ41VP6Lz8fR0");







        //mGoogleApiClient = new GoogleApiClient.Builder(this)
                //.addConnectionCallbacks(this)
                //.addOnConnectionFailedListener(this)
                // .addApi(LocationServices.API)
                //.build();

                // Create the LocationRequest object
                // mLocationRequest = LocationRequest.create()
                // .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                //.setInterval(10 * 1000)        // 10 seconds, in milliseconds
                //.setFastestInterval(1 * 1000); // 1 second, in milliseconds
    }

    //@Override
    //protected void onResume() {
        //super.onResume();
        //setUpMapIfNeeded();
        //mGoogleApiClient.connect();
    //}

   // @Override
    //protected void onPause() {
        //super.onPause();
        //if (mGoogleApiClient.isConnected()) {
            //if (mGoogleApiClient.isConnected()) {
                //LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
                //mGoogleApiClient.disconnect();
           // }
       // }

    //}

    @Override
    public void onMapReady(final GoogleMap map) {
        // Add a marker to current location and move the camera
        final LatLng currentLocation = new LatLng(28.3220463, -81.5434115 );
        //map.addMarker(new MarkerOptions().position(currentLocation).title("Marker is where you are!"));
        map.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
        map.setMyLocationEnabled(true);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("PictureData");
        //query.getInBackground("44G6m1I3Fq", new GetCallback<ParseObject>()
        query.findInBackground(new FindCallback<ParseObject>() {

            //@Override
            public void done(ParseObject object, ParseException e) {

            }

            @Override
            public void done(List<ParseObject> object, com.parse.ParseException e) {
                //String name = object.getString("Name");
                //Double lat = object.getDouble("Latitude");
                //Double longi = object.getDouble("Longitude");

                //String notes = object.getString("Notes");
                //ParseGeoPoint point1 = (ParseGeoPoint) object.get("Location");


               /* map.addMarker(new MarkerOptions()
                        .position(currentLocation)
                        .title(name))
                        .setSnippet(lat + ", " + longi);*/
                if (object.size() > 0) {

                    for (int i = 0; i < object.size(); i++) {
                        //ParseObject p = object.get(i);
                        //email = p.getString("email");
                        //password  = p.getString("password");
                        ParseObject p = object.get(i);
                        String name = p.getString("Name");
                        Double lat = p.getDouble("Latitude");
                        Double longi = p.getDouble("Longitude");

                        map.addMarker(new MarkerOptions()
                                .position(new LatLng(lat, longi))
                                .title(name))
                                .setSnippet(lat + ", " + longi);
                    }
                }
            }
        });
    }


            // @Override
            //public void done(ParseObject arg0, ParseException arg1) {
            // TODO Auto-generated method stub

            //if (arg1 == null) {
                   /* String name = arg0.getString("Name");
                    String notes = arg0.getString("Notes");
                    //Double lat = arg0.getDouble("Latitude");
                    //Double lon = arg0.getDouble("Longitude");
                    query.get("Location");

                    map.addMarker(new MarkerOptions()
                            .position(currentLocation)
                            .title(name));
                            .setSnippet();*/


            //} else {
            //Log.d("score", "Error: " + arg1.getMessage());
            //}
            //}

            //});

        /*ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("PictureData");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> markers, ParseException e) {
                if (e == null) {
                    // your logic here
                } else {
                    // handle Parse Exception here
                }
            }
        });*/


            //double currentLatitude = location.getLatitude();
            //double currentLongitude = location.getLongitude();

            //LatLng latLng = new LatLng(currentLatitude, currentLongitude);

            //mMap.addMarker(new MarkerOptions().position(new LatLng(currentLatitude, currentLongitude)).title("Current Location"));
            //MarkerOptions options = new MarkerOptions()
            //.position(latLng)
            //.title("I am here!");
            //map.addMarker(options);
            //float zoomLevel = (float) 16.0; //This goes up to 21
            //map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));


            //@Override
            //public void onConnected(Bundle bundle) {
            //Log.i(TAG, "Location services connected.");
            //Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            //if (location == null) {
            //LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
            //}
            //else {
            //handleNewLocation(location);
            //};
            //}

            //@Override
            //public void onConnectionSuspended(int i) {
            //Log.i(TAG, "Location services suspended. Please reconnect.");
            //}

            //@Override
            //public void onConnectionFailed(ConnectionResult connectionResult) {
            // if (connectionResult.hasResolution()) {
            //try {
            // Start an Activity that tries to resolve the error
            //connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
            //} catch (IntentSender.SendIntentException e) {
            //e.printStackTrace();
            //}
            //} else {
            // Log.i(TAG, "Location services connection failed with code " + connectionResult.getErrorCode());
            //}
            //}

            //private void handleNewLocation(Location location) {
            //Log.d(TAG, location.toString());

            //double currentLatitude = location.getLatitude();
            //double currentLongitude = location.getLongitude();
            //LatLng latLng = new LatLng(10, 10);

            //MarkerOptions options = new MarkerOptions()
            // .position(latLng)
            // .title("I am here!");
            //map.addMarker(options);
            //map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            //}

            //@Override
            // public void onLocationChanged(Location location) {
            //handleNewLocation(location);
            //}
}