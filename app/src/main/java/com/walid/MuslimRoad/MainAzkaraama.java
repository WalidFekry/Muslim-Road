package com.walid.MuslimRoad;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class MainAzkaraama extends AppCompatActivity {
    List<itempager1> listpager7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_azkaraama);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView adView = (AdView) findViewById(R.id.maintitle9);
        adView.loadAd(adRequest);

        final ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager7);
        listpager7=new ArrayList<>();
        listpager7.add(new itempager1(getString(R.string.manzel1),""));
        listpager7.add(new itempager1(getString(R.string.manzel2),""));
        listpager7.add(new itempager1(getString(R.string.masgeed),""));
        Adapterpager7 adapterpager7=new Adapterpager7(MainAzkaraama.this,listpager7);
        viewPager.setAdapter(adapterpager7);


    }
}
