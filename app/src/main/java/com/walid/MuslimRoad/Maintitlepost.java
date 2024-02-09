package com.walid.MuslimRoad;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import com.squareup.picasso.Picasso;

import net.steamcrafted.materialiconlib.MaterialIconView;

public class Maintitlepost extends AppCompatActivity {
    ImageView imgeturii;
    TextView texttit;
    ShimmerTextView textmove;
    Shimmer shimmer;
    MaterialIconView staa,coo,shaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_maintitlepost);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView adView = (AdView) findViewById(R.id.maintitle9);
        adView.loadAd(adRequest);
        imgeturii=(ImageView)findViewById(R.id.imgeturii);
        textmove=(ShimmerTextView)findViewById(R.id.textmove);
        texttit=(TextView)findViewById(R.id.texttit);
        staa=(MaterialIconView)findViewById(R.id.staa) ;
        coo=(MaterialIconView)findViewById(R.id.coo) ;
        shaa=(MaterialIconView)findViewById(R.id.shaa) ;
        Intent intent=getIntent();
        String imgeturi=intent.getStringExtra("imgeturi");
        final String title=intent.getStringExtra("title");
        String textmovee=intent.getStringExtra("textmove");


        texttit.setText(title);
        textmove.setText(textmovee);
        Picasso.get().load(imgeturi).into(imgeturii);
        shimmer=new Shimmer();
        shimmer.start(textmove);

        coo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager)getApplicationContext(). getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("",title+"\n"+
                        "\n"+"تم نسخ هذه النصوص  من تطبيق طريق المسلم " +"\n"+  " https://t.co/IuFGow3uyK\n");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(Maintitlepost.this, "تم نسخ النص", Toast.LENGTH_SHORT).show();

            }
        });
        shaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT," طريق المسلم - MuslimRoad ");
                sendIntent.putExtra(Intent.EXTRA_TEXT,title+"\n"+ "مشاركه نصوص من تطبيق  طريق المسلم - MuslimRoad" +"\n"+ "\n"+"https://t.co/IuFGow3uyK");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent,"مشاركه تطبيق طريق المسلم مع الاصدقاء:"));

            }
        });

        staa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/IuFGow3uyK")));
            }
        });

    }
}
