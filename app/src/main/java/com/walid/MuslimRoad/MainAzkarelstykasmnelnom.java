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

public class MainAzkarelstykasmnelnom extends AppCompatActivity {
    List<itempager1> listpager6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_azkarelstykasmnelnom);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView adView = (AdView) findViewById(R.id.maintitle11);
        adView.loadAd(adRequest);
        final ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager6);
        listpager6=new ArrayList<>();
        listpager6.add(new itempager1(getString(R.string.stkazmnelnom),""));
        Adapterpager6 adapterpager6=new Adapterpager6(MainAzkarelstykasmnelnom.this,listpager6);
        viewPager.setAdapter(adapterpager6);
    }
}
