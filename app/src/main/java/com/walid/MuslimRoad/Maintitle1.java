package com.walid.MuslimRoad;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import com.walid.MuslimRoad.base.BaseActivity;

public class Maintitle1 extends BaseActivity {
    ImageView star1, star2, star3, star5;
    //  Animation stars,circle;
    RecyclerView recramadan;
    CardView card1, card2, card3, card4;
    ShimmerTextView rmdankarem;
    Shimmer shimmer;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_maintitle1);
        Intent intent = getIntent();

        rmdankarem = (ShimmerTextView) findViewById(R.id.rmdankarem);
        shimmer = new Shimmer();
        shimmer.start(rmdankarem);
        card1 = (CardView) findViewById(R.id.card1);
        card2 = (CardView) findViewById(R.id.card2);
        card3 = (CardView) findViewById(R.id.card3);
        card4 = (CardView) findViewById(R.id.card4);

        card1.setDrawingCacheEnabled(true);
        card1.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        card2.setDrawingCacheEnabled(true);
        card2.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        card3.setDrawingCacheEnabled(true);
        card3.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        card4.setDrawingCacheEnabled(true);
        card4.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        //  stars= AnimationUtils.loadAnimation(this,R.anim.animstar);
        //  circle= AnimationUtils.loadAnimation(this,R.anim.animcloud);
        // star1=(ImageView)findViewById(R.id.star1);
        // star2=(ImageView)findViewById(R.id.star2);
        // star3=(ImageView)findViewById(R.id.star3);
        // star5=(ImageView)findViewById(R.id.star5);

        //  star1.startAnimation(circle);
        //  star2.startAnimation(stars);
        //  star3.startAnimation(stars);
        //  star5.startAnimation(circle);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Maintitle1.this, Mainreccard1.class));
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maintitle1.this, Mainreccard2.class);
                startActivity(i);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Maintitle1.this, Mainadiearmdan.class));
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Maintitle1.this, Maincard4.class));
            }
        });

        setUpAds();
        getHandler().postDelayed(this::LoadAds, 4000);
    }

    private void setUpAds() {

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, getString(R.string.Biny1), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

    }

    private void LoadAds() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(Maintitle1.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }

    }


}
