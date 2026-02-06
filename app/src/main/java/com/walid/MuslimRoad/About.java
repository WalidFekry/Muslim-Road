package com.walid.MuslimRoad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.walid.MuslimRoad.databinding.ActivityAboutBinding;


public class About extends AppCompatActivity {

    private ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupClicks();
    }

    private void setupClicks() {

        // Gmail
        ViewClick(this::sendEmail,
                binding.gmail,
                binding.em
        );

        // Facebook
        ViewClick(() -> openUrl("https://www.facebook.com/Waleed.Fikri"),
                binding.facebooks,
                binding.fb
        );

        // Share App
        ViewClick(() -> shareApp(),
                binding.share,
                binding.sh
        );

        // Rate App
        ViewClick(() -> openUrl("https://t.co/IuFGow3uyK"),
                binding.star,
                binding.ra
        );

        // More Apps
        ViewClick(() -> openUrl("https://t.co/US34fsUZeW"),
                binding.googleplays,
                binding.gooo
        );
    }

    /* ---------------- Actions ---------------- */

    private void sendEmail() {
        Intent emailIntent = new Intent(
                Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", "prowalidfekry@gmail.com", null)
        );
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "رسالة إلى مبرمج تطبيق المسلم 📲");
        startActivity(Intent.createChooser(emailIntent, "إرسال بريد"));
    }

    private void shareApp() {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "طريق المسلم - MuslimRoad");
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "هذا التطبيق إصدار مجاني لمساعدتك في شهر رمضان ويحتوي على العديد من الأذكار.\n\n" +
                        "رابط التطبيق 👇\nhttps://t.co/IuFGow3uyK"
        );
        startActivity(Intent.createChooser(sendIntent, "مشاركة التطبيق"));
    }

    private void openUrl(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    /* ---------------- Helper ---------------- */

    private void ViewClick(Runnable action, android.view.View... views) {
        for (android.view.View view : views) {
            view.setOnClickListener(v -> action.run());
        }
    }
}
