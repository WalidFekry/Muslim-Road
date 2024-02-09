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

public class Mainadiearmdan extends AppCompatActivity {
RecyclerView recyclercard3;
 List<item_maincard2> listmaincard3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_mainadiearmdan);
        recyclercard3=(RecyclerView)findViewById(R.id.recyclercard3);
        recyclercard3.setHasFixedSize(true);
        recyclercard3.setItemViewCacheSize(20);
        recyclercard3.setDrawingCacheEnabled(true);
        recyclercard3.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclercard3.setLayoutManager(new LinearLayoutManager(this));
        listmaincard3=new ArrayList<>();
        listmaincard3.add(new item_maincard2("دعاء اليوم الاول","1",getString(R.string.r1)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الثاني","2",getString(R.string.r2)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الثالث","3",getString(R.string.r3)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الرابع","4",getString(R.string.r4)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الخامس","5",getString(R.string.r5)));
        listmaincard3.add(new item_maincard2("دعاء اليوم السادس","6",getString(R.string.r6)));
        listmaincard3.add(new item_maincard2("دعاء اليوم السابع","7",getString(R.string.r7)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الثامن","8",getString(R.string.r8)));
        listmaincard3.add(new item_maincard2("دعاء اليوم التاسع","9",getString(R.string.r9)));
        listmaincard3.add(new item_maincard2("دعاء اليوم العاشر","10",getString(R.string.r10)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الحادي عشر","11",getString(R.string.r11)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الثاني عشر","12",getString(R.string.r12)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الثالث عشر","13",getString(R.string.r13)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الرابع عشر","14",getString(R.string.r14)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الخامس عشر","15",getString(R.string.r15)));
        listmaincard3.add(new item_maincard2("دعاء اليوم السادس عشر","16",getString(R.string.r16)));
        listmaincard3.add(new item_maincard2("دعاء اليوم السابع عشر","17",getString(R.string.r17)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الثامن عشر","18",getString(R.string.r18)));
        listmaincard3.add(new item_maincard2("دعاء اليوم التاسع عشر","19",getString(R.string.r19)));
        listmaincard3.add(new item_maincard2("دعاء اليوم العشرين","20",getString(R.string.r20)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الحادي والعشرين","21",getString(R.string.r21)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الثاني والعشرين","22",getString(R.string.r22)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الثالث والعشرين","23",getString(R.string.r23)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الرابع والعشرين","24",getString(R.string.r24)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الخامس والعشرين","25",getString(R.string.r25)));
        listmaincard3.add(new item_maincard2("دعاء اليوم السادس والعشرين","26",getString(R.string.r26)));
        listmaincard3.add(new item_maincard2("دعاء اليوم السابع والعشرين","27",getString(R.string.r27)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الثامن والعشرين","28",getString(R.string.r28)));
        listmaincard3.add(new item_maincard2("دعاء اليوم التاسع والعشرين","29",getString(R.string.r29)));
        listmaincard3.add(new item_maincard2("دعاء اليوم الثلاثين","30",getString(R.string.r30)));

      Adaptermaincard3 adaptermaincard3 =new Adaptermaincard3(Mainadiearmdan.this,listmaincard3);
      recyclercard3.setAdapter(adaptermaincard3);
    }
}
