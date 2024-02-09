package com.walid.MuslimRoad;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.navigation.NavigationView;

import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.firebase.messaging.FirebaseMessaging;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import com.walid.MuslimRoad.masbaha.MasbahaActivity;
import com.walid.MuslimRoad.qoutes.QoutesActivity;
import com.walid.MuslimRoad.roqia.RoqiaActivity;

import net.steamcrafted.materialiconlib.MaterialIconView;

import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;
import softpro.naseemali.ShapedNavigationView;
import softpro.naseemali.ShapedViewSettings;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button hakbt, azkar, post, kutob, masbahaa, roqiaa, thawaap, qoutes;
    MaterialIconView about;
    ShimmerTextView textsh;
    Shimmer shimmer;
    String[] permission = new String[]{
            Manifest.permission.POST_NOTIFICATIONS
    };
    boolean isPermission = false;
    private final ActivityResultLauncher<String> requestPermissionLauncherNotification =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                isPermission = isGranted;
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        about = findViewById(R.id.about);
        hakbt = findViewById(R.id.hakbt);
        qoutes = findViewById(R.id.qoutes);
        masbahaa = findViewById(R.id.masbahaa);
        roqiaa = findViewById(R.id.roqiaa);
        azkar = findViewById(R.id.azkar);
        post = findViewById(R.id.post);
        thawaap = findViewById(R.id.thawaap);
        kutob = findViewById(R.id.kutob);
        textsh = findViewById(R.id.textsh);
        shimmer = new Shimmer();
        shimmer.start(textsh);
        hakbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Maintitle1.class));
            }
        });
        qoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QoutesActivity.class));
            }
        });
        azkar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Mainazkar.class));

            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Mainposts.class));


            }
        });
        kutob.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Mainbook.class));
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, About.class));
            }
        });
        masbahaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MasbahaActivity.class));
            }
        });
        thawaap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/4VQlA6AZrH")));
            }
        });
        roqiaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RoqiaActivity.class));
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        ShapedNavigationView shapedNavigationView = findViewById(R.id.nav_view);
        shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.WAVES_INDEFINITE);
        shapedNavigationView.setNavigationItemSelectedListener(this);

        FirebaseMessaging.getInstance().subscribeToTopic("all");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            cheakNotificationPermission();
        }
    }

    private void cheakNotificationPermission() {
        if (!isPermission) {
            requestPermissionsNotfication();
        }
    }

    private void requestPermissionsNotfication() {
        if (ContextCompat.checkSelfPermission(this, permission[0]) == PackageManager.PERMISSION_GRANTED) {
            isPermission = true;
        } else {
            requestPermissionLauncherNotification.launch(permission[0]);
            showPermissionDialog();
        }
    }

    private void showPermissionDialog() {
        new AlertDialog.Builder(this)
                .setMessage("من فضلك قم بالموافقة على الاشعارات لكي تصلك رسائل التفاؤل والإقتباسات من التطبيق ..")
                .setPositiveButton("الاعدادات", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setAction(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    public void onBackPressed() {
        final PrettyDialog pDialog = new PrettyDialog(this);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.setTitle("هل تريد الخروج من التطبيق !")
                .setMessage("كيف نطور التطبيق ليصبح أفضل .. ما رأيك بتقييم التطبيق ؟").
                setIcon(R.mipmap.icon_myapp)
                .setAnimationEnabled(true)
                .setMessageColor(R.color.darkblue)
                .setTitleColor(R.color.colorAccent)
                .setIconTint(R.color.background_light_grey)
                .setGravity(Gravity.DISPLAY_CLIP_HORIZONTAL)
                .setTypeface(Typeface.createFromAsset(getAssets(), "rrrr.ttf"))
                .addButton(
                        "خروج",
                        R.color.colorWhite,
                        R.color.colorBlueT,
                        new PrettyDialogCallback() {
                            @Override
                            public void onClick() {
                                finish();
                            }
                        }
                )

                .addButton(
                        "♥ تقييم التطبيق ♥",
                        R.color.colorWhite,
                        R.color.green,
                        new PrettyDialogCallback() {
                            @Override
                            public void onClick() {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/IuFGow3uyK")));
                            }
                        }

                )
                .show();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.webside) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=201094674881&text=%D8%A7%D8%B3%D8%AA%D9%81%D8%B3%D8%A7%D8%B1%20%D8%A8%D8%AE%D8%B5%D9%88%D8%B5%20%D8%AA%D8%B7%D8%A8%D9%8A%D9%82%20%D8%B7%D8%B1%D9%8A%D9%82%20%D8%A7%D9%84%D9%85%D8%B3%D9%84%D9%85%20..&source=&data=")));
        } else if (id == R.id.facegroub) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/440403217380641")));
        } else if (id == R.id.teleee) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/App_Maktbti")));
        } else if (id == R.id.ratee) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/IuFGow3uyK")));
        } else if (id == R.id.shareee) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, " طريق المسلم- MuslimRoad");
            sendIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.sshar));
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "مشاركه تطبيق طريق المسلم- MuslimRoad مع الاصدقاء:"));

        } else if (id == R.id.mass) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "prowalidfekry@gmail.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "رسالة إلى مبرمج تطبيق طريق المسلم 📲");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "");
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        } else if (id == R.id.sysa) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/muslimroad/home?fbclid=IwAR1HNohEjDySFEqTKk5IH5Msny23OvaSb_qmTLtiZav7AXBo6LwBz8Bc4Oc")));

        } else if (id == R.id.about) {
            startActivity(new Intent(MainActivity.this, About.class));
        } else if (id == R.id.walidmore) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/US34fsUZeW")));
        } else if (id == R.id.ffb) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/App.Qurani")));
        } else if (id == R.id.maktbtiplus) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://walid-fekry.com/maktbti-plus/")));
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }


}



