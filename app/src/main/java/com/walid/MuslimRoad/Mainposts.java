package com.walid.MuslimRoad;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;
import guy4444.smartrate.SmartRate;


public class Mainposts extends AppCompatActivity {
    RecyclerView recyclerpost;
    List<item_post> listpost;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    SpinKitView spin_kit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
         WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_mainposts);
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
                        SmartRate.Rate(Mainposts.this
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
            }, 12000);

        } else {
            final PrettyDialog pDialog = new PrettyDialog(this);
            pDialog. setCanceledOnTouchOutside(false);
            pDialog .setTitle("INTERNET ERROR")
                    .setMessage("هناك مشكله ! من فضلك تاكد من الاتصال بالانترنت .. لأن هذا القسم متجدد يومياً .").
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


        spin_kit=(SpinKitView)findViewById(R.id.spin_kit);
        recyclerpost=(RecyclerView)findViewById(R.id.recyclerpost);
        recyclerpost.setLayoutManager(new LinearLayoutManager(this));
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        listpost=new ArrayList<>();
        databaseReference.child("posts").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot!=null){spin_kit.setVisibility(View.GONE);}
                listpost.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    item_post  item_post = dataSnapshot1.getValue(item_post.class);
                    listpost.add(item_post);
                }
                Adapterpost  adapter1 =new Adapterpost(listpost,Mainposts.this);
                recyclerpost.setAdapter(adapter1);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });


    }
}
