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

public class Mainazkarelnoom extends AppCompatActivity {
    List<itempager1> listpager5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainazkarelnoom);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView adView = (AdView) findViewById(R.id.maintitle10);
        adView.loadAd(adRequest);

        final ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager5);
        listpager5=new ArrayList<>();
        listpager5.add(new itempager1(getString(R.string.noom1),""));
        listpager5.add(new itempager1(getString(R.string.noom2),getString(R.string.noom3)));
        listpager5.add(new itempager1(getString(R.string.noom4),""));
        listpager5.add(new itempager1(getString(R.string.noom6),""));
        listpager5.add(new itempager1(getString(R.string.noom7),""));
        listpager5.add(new itempager1(getString(R.string.noom8),""));
        Adapterpager5 adapterpager5=new Adapterpager5(Mainazkarelnoom.this,listpager5);
        viewPager.setAdapter(adapterpager5);
    }
}
