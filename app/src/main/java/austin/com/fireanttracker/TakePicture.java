package austin.com.fireanttracker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

import java.io.File;

public class TakePicture extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    ImageView imageViewPicture;
    private static final int PICTURE_REQUEST_CODE = 100;
    private static File mediaFile;
    private ParseGeoPoint geoPoint;
    public static final String INTENT_EXTRA_LOCATION = "location";
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private TextView textLat;
    private TextView textLong;
    private double lastLat;
    private double lastLong;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    public Button buttonSubmit;
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    public Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);

        textLat = (TextView) findViewById(R.id.textLat);
        textLong = (TextView) findViewById(R.id.textLong);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setVisibility(View.GONE);

        this.imageViewPicture = (ImageView)this.findViewById(R.id.imageViewPicture);

        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) this)
                    .addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this)
                    .addApi(LocationServices.API)
                    .build();
        }





        // Fade in and out of hint text for namePicture editText
        final EditText editText = (EditText) findViewById(R.id.namePicture);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editText.setHint("");
                } else {
                    editText.setHint("Enter your first name here");
                }
            }
        });

        // Fade in and out of hint text for imageDescriptionPicture editText
        final EditText editText1 = (EditText) findViewById(R.id.imageDescriptionPicture);
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editText1.setHint("");
                } else {
                    editText1.setHint("Enter in notes here after you capture the image");
                }
            }
        });

        // Sets ActionBar (title bar at the top) color to red
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#cc0000")));

        // ActionListener for capture image button
        Button captureImage = (Button) findViewById(R.id.captureImage);
        captureImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("hello", "hi");
                buttonSubmit.setVisibility(View.VISIBLE);
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);

                }
        });

        // This is where any parse.com stuff should happen (ie. have parse.com read appropriate
        // data from this activity)
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ParseObject pictureData = new ParseObject("PictureData");
                pictureData.put("Name", editText.getText().toString());
                //pictureData.put("Notes", editText1.getText().toString());
                //ParseGeoPoint geopoint = new ParseGeoPoint(lastLat, lastLong);
                //pictureData.put("Location", geopoint);

                pictureData.put("Latitude", lastLat);
                pictureData.put("Longitude", lastLong);

                //pictureData.put("Image", photo);
                pictureData.saveInBackground();




            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_take_picture, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    public void onConnected(Bundle connectionHint) {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
           // mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
           // mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
           // Looks like this is working!
            Log.d("hello", String.valueOf(mLastLocation.getLatitude()));
            Log.d("hello", String.valueOf(mLastLocation.getLongitude()));
            lastLat = Double.parseDouble(String.valueOf(mLastLocation.getLatitude()));
            lastLong = Double.parseDouble(String.valueOf(mLastLocation.getLongitude()));

            textLat.setText("Current latitude: " + lastLat);
            textLong.setText("Current longitude: " + lastLong);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            imageViewPicture.setImageBitmap(photo);
        }
    }


}
