package com.walid.MuslimRoad;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.walid.MuslimRoad.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import guy4444.smartrate.SmartRate;
import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;

public class Mainbook extends BaseActivity {
RecyclerView booksrecycler;
List<item_book>listbooks;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
SpinKitView spin_kitt;
private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
         WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_mainbook);
        Intent intent=getIntent();
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    if(this!=null && !isFinishing()){
                        SmartRate.Rate(Mainbook.this
                                , "تقييم التطبيق"
                                , "تقييمك للتطبيق يساعدنا علي التطوير المستمر وتقديم المزيد"
                                , "تقييم الان"
                                , "حسنا يمكنك تقيممنا الان علي جوجل بلاي"
                                , "اضغط هنا"
                                , "ليس الان"
                                , "Thanks "
                                , Color.parseColor("#c65164")                 , 4         );


                    }
                }
            }, 15000);



        } else {
            final PrettyDialog pDialog = new PrettyDialog(this);
            pDialog. setCanceledOnTouchOutside(false);
            pDialog .setTitle("INTERNET ERROR")
                    .setMessage("هناك مشكله ! من فضلك تاكد من الاتصال با الانترنت .").
                    setIcon(R.mipmap.icon_myapp)
                    .setAnimationEnabled(true)
                    .setMessageColor(R.color.colorBlue)
                    .setTitleColor(R.color.colorAccent)
                    .setIconTint(R.color.colorBlue)
                    .setGravity(Gravity.DISPLAY_CLIP_HORIZONTAL)
                    .setTypeface(Typeface.createFromAsset(getAssets(),"rrrr.ttf"))

                    .addButton(
                            "Cancel",
                            R.color.colorWhite,
                            R.color.colorPurpleT,
                            new PrettyDialogCallback() {
                                @Override
                                public void onClick() {
                                    finish();
                                }
                            }
                    )
                    .show();     }

        spin_kitt=(SpinKitView)findViewById(R.id.spin_kitt);
        booksrecycler=(RecyclerView)findViewById(R.id.booksrecycler);
        booksrecycler.setLayoutManager(new GridLayoutManager(this,2));
        Window w=getWindow();
        listbooks=new ArrayList<>();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        databaseReference.child("books").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot!=null){spin_kitt.setVisibility(View.GONE);}
                listbooks.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    item_book item_book = dataSnapshot1.getValue(item_book.class);
                    listbooks.add(item_book);
                }
                 Adapterbook  adapterbook=new Adapterbook(listbooks,getApplicationContext());
                 booksrecycler.setAdapter(adapterbook);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        setUpAds();
        getHandler().postDelayed(this::LoadAds, 4000);
    }

    private void setUpAds() {

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, getString(R.string.Biny1), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

    }

    private void LoadAds() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(Mainbook.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }    }
}
