package com.vdopia.interstitialsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.vdopia.ads.lw.LVDOAdRequest;
import com.vdopia.ads.lw.LVDOConstants;
import com.vdopia.ads.lw.LVDOInterstitialAd;
import com.vdopia.ads.lw.LVDOInterstitialListener;

import org.w3c.dom.Text;

public class MainActivity extends RequestPermissionActivity implements LVDOInterstitialListener {
    private LVDOInterstitialAd mInterstitialAd;
    private static final String TAG = "InterstitialActivity";
    Button CLICK;
    TextView STRING;
    LVDOAdRequest adRequest = new LVDOAdRequest(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CLICK=(Button) findViewById(R.id.button);
        CLICK.setVisibility(View.VISIBLE);
        //CLICK=(Button) findViewById();
        STRING=(TextView) findViewById(R.id.textView4);
LVDOInterstitialAd.prefetch(this,"73qi1Y", adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void click(View v){

        //Toast.makeText(getBaseContext(), "To mainactivity2", Toast.LENGTH_SHORT).show();
        //Intent toy=new Intent(MainActivity.this,Main2Activity.class);
        //startActivity(toy);
        //calling show ad method
        loadInterstitial();
        //mInterstitialAd.show();


    }
    @Override
    public void onPermissionsGranted(int requestCode) {

    }

    private void loadInterstitial() {

        mInterstitialAd = new LVDOInterstitialAd(this, "73qi1Y", this);


        //ArrayList<LVDOConstants.PARTNERS> mPartnerNames = new ArrayList<>();
        //LVDOConstants.PARTNERS partner = (LVDOConstants.PARTNERS) this.getIntent().getSerializableExtra(LVDOConstants.PARTNERS.ALL.toString());
        //LVDOConstants.PARTNERS partner= LVDOConstants.PARTNERS.ALL;
        //mPartnerNames.add(partner);
        //adRequest.setPartnerNames(mPartnerNames);
        adRequest.setDmaCode("807");
        adRequest.setEthnicity("Asian");
        adRequest.setPostalCode("110096");
        adRequest.setCurrPostal("201301");
        adRequest.setDmaCode("807");
        adRequest.setAge("27");
        //adRequest.setMaritalStatus("single");
        adRequest.setGender(LVDOAdRequest.LVDOGender.MALE);
        //adRequest.setBirthday(Utils.getDate());

        adRequest.setRequester("Vdopia");
        //adRequest.setAppBundle("chocolateApp");
        adRequest.setAppDomain("vdopia.com");
        //adRequest.setAppName("VdopiaSampleApp");
        adRequest.setAppStoreUrl("play.google.com");
        adRequest.setCategory("Education");
        adRequest.setPublisherDomain("vdopia.com");

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public void onInterstitialLoaded(LVDOInterstitialAd interstitialAd) {
        Log.d(TAG, "Interstitial Loaded");
        //mInterstitialAd.show();

        STRING.setVisibility(View.INVISIBLE);

        try {
            mInterstitialAd.show();
        } catch(com.vdopia.ads.lw.ChocolateAdException e){
            Log.e("SouravTest", "show failed ",e);
        }
    }


    @Override
    public void onInterstitialFailed(LVDOInterstitialAd interstitialAd, LVDOConstants.LVDOErrorCode errorCode) {
        Log.v(TAG, "Interstitial Failed" + errorCode.toString());
        //loadInterstitial();
    }

    @Override
    public void onInterstitialShown(LVDOInterstitialAd interstitialAd) {
        Log.v(TAG, "Interstitial Shown");
    }

    @Override
    public void onInterstitialClicked(LVDOInterstitialAd interstitialAd) {
        Log.v(TAG, "Interstitial Clicked");
    }

    @Override
    public void onInterstitialDismissed(LVDOInterstitialAd interstitialAdl) {
        Log.v(TAG, "Interstitial Dismissed");
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
    @Override
    protected void onDestroy() {
        if (mInterstitialAd != null) {
            mInterstitialAd.destroyView();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        if (mInterstitialAd != null) {
            mInterstitialAd.pause();
        }
        super.onPause();
    }
}
