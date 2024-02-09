package com.walid.MuslimRoad;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.romainpiel.shimmer.ShimmerTextView;

public class Maintitle3 extends AppCompatActivity {
ImageView imgicon3;
ShimmerTextView  text3;
TextView titletext3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_maintitle3);
        Intent intent=getIntent();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView adView = (AdView) findViewById(R.id.maintitle3);
        adView.loadAd(adRequest);

        String text=intent.getStringExtra("text3");
        String title=intent.getStringExtra("title3");
        text3=(ShimmerTextView)findViewById(R.id.text3);
        titletext3=(TextView)findViewById(R.id.titletext3);
         text3.setText(text);
          titletext3.setText(title);

    }
}
