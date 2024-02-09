package com.walid.MuslimRoad;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class Maincard4 extends AppCompatActivity {
    List<item_maincard2> listmaincard4;
    RecyclerView recyclercard4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_maincard4);
        recyclercard4=(RecyclerView)findViewById(R.id.recyclercard4);
        recyclercard4.setLayoutManager(new LinearLayoutManager(this));
        listmaincard4=new ArrayList<>();
        listmaincard4.add(new item_maincard2("المقصود بالصيام","1",getString(R.string.t1)));
        listmaincard4.add(new item_maincard2("أركان الصوم","2",getString(R.string.t3)));
        listmaincard4.add(new item_maincard2("على من يجب الصوم","3",getString(R.string.t4)));
        listmaincard4.add(new item_maincard2("آداب الصيام","4",getString(R.string.t5)));
        listmaincard4.add(new item_maincard2("مبطلات الصيام","5",getString(R.string.t6)));
        listmaincard4.add(new item_maincard2("قضاء رمضان","6",getString(R.string.t7)));
        listmaincard4.add(new item_maincard2("السفر المبيح للفطر","7",getString(R.string.t8)));

        Adaptermaincard4 adaptermaincard4=new Adaptermaincard4(Maincard4.this,listmaincard4);
        recyclercard4.setAdapter(adaptermaincard4);

    }
}
