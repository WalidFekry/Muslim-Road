package com.walid.MuslimRoad;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Mainbook2 extends AppCompatActivity {
ImageView imgebooks;
TextView textnn;
Button read,downlod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
          WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_mainbook2);
        final Intent intent =getIntent();
        String imbook=intent.getStringExtra("imgebook");
        final String nbook=intent.getStringExtra("namebook");
        final String bread=intent.getStringExtra("bookread");
        final String bdownlod=intent.getStringExtra("bookdownlod");
        imgebooks=(ImageView)findViewById(R.id.imgebooks);
        textnn=(TextView)findViewById(R.id.textnn);
        read=(Button)findViewById(R.id.read1);
        downlod=(Button)findViewById(R.id.downlod1);
        Picasso.get().load(imbook).into(imgebooks);
        textnn.setText(nbook);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Mainbook2.this,Webview.class);
                intent1.putExtra("boookread",bread);
                startActivity(intent1);
            }
        });

        downlod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(bdownlod)));
            }
        });


    }
}
