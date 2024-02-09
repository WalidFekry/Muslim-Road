package com.walid.MuslimRoad;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import guy4444.smartrate.SmartRate;

import net.steamcrafted.materialiconlib.MaterialIconView;

public class About extends AppCompatActivity {
MaterialIconView gmail,facebooks,share,star,googleplays;
TextView em,fb,sh,gooo,ra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        gmail=(MaterialIconView)findViewById(R.id.gmail);
        facebooks=(MaterialIconView)findViewById(R.id.facebooks);
        share=(MaterialIconView)findViewById(R.id.share);
        star=(MaterialIconView)findViewById(R.id.star);
        googleplays=(MaterialIconView)findViewById(R.id.googleplays);
        em=(TextView)findViewById(R.id.em);
        fb=(TextView)findViewById(R.id.fb);
        sh=(TextView)findViewById(R.id.sh);
        gooo=(TextView)findViewById(R.id.gooo);
        ra=(TextView)findViewById(R.id.ra);


        em.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","prowalidfekry@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "رسالة إلى مبرمج تطبيق المسلم 📲");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));

    }
});

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","prowalidfekry@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "رسالة إلى مبرمج تطبيق المسلم 📲");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

            }
        });
fb.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Waleed.Fikri")));

    }
});
        facebooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Waleed.Fikri")));

            }
        });
sh.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT," طريق المسلم - MuslimRoad");
        sendIntent.putExtra(Intent.EXTRA_TEXT,"\n" +
                "هذا التطبيق هو إصدار مجاني لمساعدتك في شهر رمضان و يحتوي على العديد من الأذكار و المساعدات الرمضانية لإدارة وقتك بشكل صحيح و  يضم أذكار الصباح و المساء مكتوبة و أذكار المسلم بدون إنترنت .\n \n" +
                "تفضل رابط التطبيق 👇  https://t.co/IuFGow3uyK\n");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent,"مشاركه تطبيق طريق المسلم - MuslimRoad مع الاصدقاء:"));


    }
});

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT," طريق المسلم- MuslimRoad");
                sendIntent.putExtra(Intent.EXTRA_TEXT,"\n" +
                        "هذا التطبيق هو إصدار مجاني لمساعدتك في شهر رمضان و يحتوي على العديد من الأذكار و المساعدات الرمضانية لإدارة وقتك بشكل صحيح و  يضم أذكار الصباح و المساء مكتوبة و أذكار المسلم بدون إنترنت .\n \n" +
                        "تفضل رابط التطبيق 👇  https://t.co/IuFGow3uyK\n");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent,"مشاركه تطبيق طريق المسلم - MuslimRoad مع الاصدقاء:"));

            }
        });

ra.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/IuFGow3uyK" )));

    }
});
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/IuFGow3uyK" )));

            }
        });

        googleplays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/US34fsUZeW" )));

            }
        });

        gooo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/US34fsUZeW" )));
            }
        });

    }
}
