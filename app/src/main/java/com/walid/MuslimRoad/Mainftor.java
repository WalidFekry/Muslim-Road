package com.walid.MuslimRoad;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.walid.MuslimRoad.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class Mainftor extends BaseActivity {
    List<itempager1> listpager4;
    int size = 18;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mainftor);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager4);
        listpager4 = new ArrayList<>();
        listpager4.add(new itempager1(getString(R.string.ftor1), ""));
        listpager4.add(new itempager1(getString(R.string.ftor2), getString(R.string.ftor3)));
        listpager4.add(new itempager1(getString(R.string.ftor4), getString(R.string.ftor5)));
        listpager4.add(new itempager1(getString(R.string.ftor6), getString(R.string.ftor7)));
        listpager4.add(new itempager1(getString(R.string.ftor8), getString(R.string.ftor9)));
        listpager4.add(new itempager1(getString(R.string.ftor10), getString(R.string.ftor11)));
        listpager4.add(new itempager1(getString(R.string.ftor12), getString(R.string.ftor13)));
        Adapterpager4 adapterpager = new Adapterpager4(Mainftor.this, listpager4);
        viewPager.setAdapter(adapterpager);

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

        AdView adView = (AdView) findViewById(R.id.maintitle6);
        adView.loadAd(adRequest);

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
            mInterstitialAd.show(Mainftor.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }

    }

}
