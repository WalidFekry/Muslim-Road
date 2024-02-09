package com.walid.MuslimRoad;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class Mainreccard2 extends AppCompatActivity {
    RecyclerView recymaincard2;
    List<item_maincard2> listmaincard2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_mainreccard2);
        recymaincard2=(RecyclerView)findViewById(R.id.recymaincard2);
        recymaincard2.setHasFixedSize(true);
        recymaincard2.setItemViewCacheSize(20);
        recymaincard2.setDrawingCacheEnabled(true);
        recymaincard2.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recymaincard2.setLayoutManager(new LinearLayoutManager(this));
        listmaincard2=new ArrayList<>();
        listmaincard2.add(new item_maincard2("عشر وصايا لاستقبال رمضان","1",getString(R.string.wsyarmdan)));
        listmaincard2.add(new item_maincard2("كيف تكسب ليلة القدر؟","2",getString(R.string.lylatelkader)));
        listmaincard2.add(new item_maincard2("رمضان والدعاء","3",getString(R.string.rmdanwado3a)));
        listmaincard2.add(new item_maincard2(" وقفات للنساء في رمضان","4",getString(R.string.wkfatelnessa)));
        listmaincard2.add(new item_maincard2("حتى يكون صيامك مقبولاً","5",getString(R.string.syammkbol)));
        listmaincard2.add(new item_maincard2("10 وسائل للمداومه علي العمل الصالح في رمضان","6",getString(R.string.wsyarmdanto)));
        listmaincard2.add(new item_maincard2("مراتب الصوم ودرجات الصائمين","7",getString(R.string.somsalehen)));
        listmaincard2.add(new item_maincard2("الأيام التي يحرم الصيام فيها","8",getString(R.string.thremelsoom)));

        Adaptermaincard2 adaptermaincard2=new Adaptermaincard2(Mainreccard2.this,listmaincard2);
        recymaincard2.setAdapter(adaptermaincard2);
    }
}
