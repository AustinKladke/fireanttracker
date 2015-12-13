package austin.com.fireanttracker;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ScrollView;
import android.widget.TextView;

public class Facts extends AppCompatActivity {
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    WebView webViewFacts;
    TextView textViewHelp;
    ScrollView scrollViewFacts;
    TextView textFacts;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);

        // Sets ActionBar (title bar at the top) color to red
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#cc0000")));

        // Code to get the website for the web view and also to format it
        webViewFacts = (WebView)findViewById(R.id.webViewFacts);
        webViewFacts.setWebViewClient(new MyWebViewClient());
        openURL();

        webViewFacts.getSettings().setLoadWithOverviewMode(true);
        webViewFacts.getSettings().setUseWideViewPort(true);
        webViewFacts.getSettings().setBuiltInZoomControls(true);

        scrollViewFacts = (ScrollView) findViewById(R.id.scrollViewFacts);
        textFacts = (TextView) findViewById(R.id.textFacts);
        textViewHelp = (TextView) findViewById(R.id.textViewHelp);

        // If wifi is available, this will be shown
        if(isOnline()){
            webViewFacts.setVisibility(View.VISIBLE);
        }
        // If there is no wifi, this will be shown
        else {
            webViewFacts.setVisibility(View.GONE);
            textViewHelp.setVisibility(View.GONE);
            scrollViewFacts.setVisibility(View.VISIBLE);
            textFacts.setVisibility(View.VISIBLE);
        }
    }

    // Opens the URL in a browser
    private void openURL() {
        webViewFacts.loadUrl("http://entnemdept.ufl.edu/creatures/urban/ants/red_imported_fire_ant.htm");
        webViewFacts.requestFocus();
    }

    // Checks state of wifi
    public boolean isOnline() {
        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        boolean wifiInfo = wifiManager.isWifiEnabled();
        return wifiInfo;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_facts, menu);
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
