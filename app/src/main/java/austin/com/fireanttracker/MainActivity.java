package austin.com.fireanttracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import static android.graphics.Color.parseColor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets ActionBar (title bar at the top) color to red
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(parseColor("#cc0000")));

        Button takeAPictureButton = (Button) findViewById(R.id.takeAPictureButton);

        takeAPictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TakePicture.class));

            }
        });

        Button distributionButton = (Button) findViewById(R.id.distributionButton);

        distributionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GlobalDistributionMap.class));

            }
        });

        Button factsButton = (Button) findViewById(R.id.factsButton);

        factsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Facts.class));

            }
        });

        Button quizButton = (Button) findViewById(R.id.quizButton);

        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Quiz.class));

            }
        });

        Button questionButton = (Button) findViewById(R.id.questionButton);

        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                alertDialog.setTitle("What is the purpose of this application (and how to use it)?");

                alertDialog.setMessage("Fire Ant Tracker is a global crowdsourced citizen science effort " +
                        "that intends to track and visualize fire ant mound abundance over time.\n\nTapping " +
                        "on the 'Take a Picture' button will take you to a screen that will allow you to " +
                        "take a picture of a fire ant mound with your device's built in camera at your " +
                        "current location.\n\nTapping on the " +
                        "'Global Distribution Map of Fire Ant Mounds' button will allow you to see a " +
                        "real time visualization on a map of all recorded fire ant mounds by fellow " +
                        "users such as yourself.\n\nTapping on the 'Facts about Fire Ants' button will " +
                        "take you to a screen that will inform you of the biology and behavior of fire ants.\n\n" +
                        "Finally, tapping on the 'Quiz' button will take you to a quiz that will test " +
                        "your newly acquired knowledge of fire ants.");

                alertDialog.setButton("OK (click here to exit this screen)", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });

        Button contactDeveloper = (Button) findViewById(R.id.contactDeveloper);

        contactDeveloper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                alertDialog.setTitle("How to contact the developer");

                alertDialog.setMessage("Contact the developer through the Google Play Store by leaving a comment " +
                        "on this app or email the developer at createnewemailaccount@yahoo.com");

                alertDialog.setButton("OK (click here to exit this screen)", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
