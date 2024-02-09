package com.walid.MuslimRoad;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class Mainmsa extends AppCompatActivity {
    List<itempager1> listpager2;
    int size=18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_mainmsa);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView adView = (AdView) findViewById(R.id.maintitle7);
        adView.loadAd(adRequest);

        final ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager2);
        listpager2=new ArrayList<>();
        listpager2.add(new itempager1(getString(R.string.msaa1),getString(R.string.msaa2)));
        listpager2.add(new itempager1(getString(R.string.msaa3),getString(R.string.msaa4)));
        listpager2.add(new itempager1(getString(R.string.msaa5),getString(R.string.msaa6)));
        listpager2.add(new itempager1(getString(R.string.msaa7),getString(R.string.msaa8)));
        listpager2.add(new itempager1(getString(R.string.msaa9),getString(R.string.msaa10)));
        listpager2.add(new itempager1(getString(R.string.msaa11),getString(R.string.msaa12)));
        listpager2.add(new itempager1(getString(R.string.msaa13),getString(R.string.msaa14)));
        listpager2.add(new itempager1(getString(R.string.msaa15),getString(R.string.msaa16)));
        listpager2.add(new itempager1(getString(R.string.msaa17),getString(R.string.msaa18)));
        listpager2.add(new itempager1(getString(R.string.msaa19),""));
       Adapterpager2 adapterpager=new Adapterpager2(Mainmsa.this,listpager2);
       viewPager.setAdapter(adapterpager);

    }
}
