package com.walid.MuslimRoad;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class Maintitle4 extends AppCompatActivity {
ShimmerTextView textheader;
TextView texttitle;
Shimmer shimmer;
Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_maintitle4);
        Intent intent=getIntent();
        String text=intent.getStringExtra("textheader");
        String title=intent.getStringExtra("texttitle");
        texttitle=(TextView)findViewById(R.id.texttitle);
        textheader=(ShimmerTextView)findViewById(R.id.textheader);
        texttitle.setText(title);
        textheader.setText(text);
        shimmer=new Shimmer();
        shimmer.start(textheader);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView adView = (AdView) findViewById(R.id.maintitle4);
        adView.loadAd(adRequest);




    }
}
