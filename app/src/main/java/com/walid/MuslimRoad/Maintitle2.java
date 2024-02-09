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
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class Maintitle2 extends AppCompatActivity {
TextView titletext;
    ShimmerTextView textt;
    ImageView imgicon,imgicon1;
    Shimmer shimmer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_maintitle2);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView adView = (AdView) findViewById(R.id.maintitle2);
        adView.loadAd(adRequest);

        Intent intent=getIntent();
        titletext=(TextView)findViewById(R.id.titletext);
        textt=(ShimmerTextView)findViewById(R.id.text);
        shimmer=new Shimmer();
        shimmer.start(textt);
        imgicon1=(ImageView)findViewById(R.id.imgicon1);
        String text=intent.getStringExtra("text");
        String title=intent.getStringExtra("title");
        titletext.setText(title);
        textt.setText(text);

    }
}
