package com.walid.MuslimRoad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.romainpiel.shimmer.Shimmer;

public class Mainazkar extends AppCompatActivity {
    //Animation ani;
// Animation butn;


    Shimmer shimmer;
    CardView cardazkarsbah, cardazkarmsaa, cardazkarrmdan, cardazkatftorsohor, cardazkarelnoom, cardaztkazmnelnoom, adiamtnea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mainazkar);
        Intent intent = getIntent();


        cardazkarsbah = (CardView) findViewById(R.id.cardazkarsbah);
        cardazkarmsaa = (CardView) findViewById(R.id.cardazkarmsaa);
        cardazkarrmdan = (CardView) findViewById(R.id.cardazkarrmdan);
        cardazkatftorsohor = (CardView) findViewById(R.id.cardazkatftorsohor);
        cardazkarelnoom = (CardView) findViewById(R.id.cardazkarelnoom);
        cardaztkazmnelnoom = (CardView) findViewById(R.id.cardaztkazmnelnoom);
        adiamtnea = (CardView) findViewById(R.id.adiamtnea);
        cardazkarsbah.setDrawingCacheEnabled(true);
        cardazkarsbah.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        cardazkarsbah.setDrawingCacheEnabled(true);
        cardazkarsbah.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        cardazkarmsaa.setDrawingCacheEnabled(true);
        cardazkarmsaa.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        cardazkarrmdan.setDrawingCacheEnabled(true);
        cardazkarrmdan.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        cardazkatftorsohor.setDrawingCacheEnabled(true);
        cardazkatftorsohor.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        cardazkarelnoom.setDrawingCacheEnabled(true);
        cardazkarelnoom.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        cardaztkazmnelnoom.setDrawingCacheEnabled(true);
        cardaztkazmnelnoom.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        adiamtnea.setDrawingCacheEnabled(true);
        adiamtnea.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        cardazkarsbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainazkar.this, Mainsb.class);
                startActivity(i);
            }
        });
        cardazkarmsaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainazkar.this, Mainmsa.class);
                startActivity(intent);

            }
        });
        cardazkarrmdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainazkar.this, Mainazkarrmadan.class);
                startActivity(intent);
            }
        });


        cardazkatftorsohor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Mainazkar.this, Mainftor.class);
                startActivity(i);
            }
        });
        cardazkarelnoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainazkar.this, Mainazkarelnoom.class);
                startActivity(intent);

            }
        });
        cardaztkazmnelnoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainazkar.this, MainAzkarelstykasmnelnom.class);
                startActivity(intent);


            }
        });
        adiamtnea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainazkar.this, MainAzkaraama.class);
                startActivity(intent);
            }
        });

    }


}
