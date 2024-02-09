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

import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.ArrayList;
import java.util.List;

public class Mainazkarrmadan extends AppCompatActivity {
    List<itempager1> listpager3;
    MaterialIconView plus;
    int size=18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_mainazkarrmadan);
        final ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager3);
        listpager3=new ArrayList<>();
        listpager3.add(new itempager1(getString(R.string.azkarrmdan1),getString(R.string.azkarrmdan2)));
        listpager3.add(new itempager1(getString(R.string.azkarrmdan3),getString(R.string.azkarrmdan4)));
        listpager3.add(new itempager1(getString(R.string.azkarrmdan5),getString(R.string.azkarrmdan6)));
        listpager3.add(new itempager1(getString(R.string.azkarrmdan7),getString(R.string.azkarrmdan8)));
        listpager3.add(new itempager1(getString(R.string.azkarrmdan9),getString(R.string.azkarrmdan10)));
        listpager3.add(new itempager1(getString(R.string.azkarrmdan11),getString(R.string.azkarrmdan12)));
        listpager3.add(new itempager1(getString(R.string.azkarrmdan13),getString(R.string.azkarrmdan14)));
        listpager3.add(new itempager1(getString(R.string.azkarrmdan15),getString(R.string.azkarrmdan16)));
        Adapterpager3 adapterpager3=new Adapterpager3(Mainazkarrmadan.this,listpager3);
        viewPager.setAdapter(adapterpager3);
    }
}
