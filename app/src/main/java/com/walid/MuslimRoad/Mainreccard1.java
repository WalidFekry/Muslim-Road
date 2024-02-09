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

public class Mainreccard1 extends AppCompatActivity {
RecyclerView recymaincard1;
List<item_maincard1>listmaincard1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_mainreccard1);
        recymaincard1=(RecyclerView)findViewById(R.id.recymaincard1);
        recymaincard1.setHasFixedSize(true);
        recymaincard1.setItemViewCacheSize(20);
        recymaincard1.setDrawingCacheEnabled(true);
        recymaincard1.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recymaincard1.setLayoutManager(new LinearLayoutManager(this));
        listmaincard1=new ArrayList<>();
        listmaincard1.add(new item_maincard1("نصائح رمضانيه","1",getString(R.string.nsharmdan)));
        listmaincard1.add(new item_maincard1("طرق التغذية الرمضانية السليمة","2",getString(R.string.tkzya)));
        listmaincard1.add(new item_maincard1("ممارسات غذائية خاطئة خلال شهر رمضان","3",getString(R.string.khtea)));
        listmaincard1.add(new item_maincard1("وصايا طبية في شهر رمضان","4",getString(R.string.wsya)));
        listmaincard1.add(new item_maincard1("فقه الصحة في رمضان","5",getString(R.string.fkasha)));
        listmaincard1.add(new item_maincard1("الفوائد النفسية في الصيام","6",getString(R.string.nfsya)));
        listmaincard1.add(new item_maincard1("أسرار الإفطار على تمر","7",getString(R.string.tmr)));
        listmaincard1.add(new item_maincard1("الصوم والإقلاع عن التدخين","8",getString(R.string.tdhken)));






        Adaptermaincard1 adaptermaincard1=new Adaptermaincard1(Mainreccard1.this,listmaincard1);
        recymaincard1.setAdapter(adaptermaincard1);

    }
}
