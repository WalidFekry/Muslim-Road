package com.walid.MuslimRoad;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.List;

public class Adapterpager6 extends PagerAdapter {

    int a = 0;
    int c = 18;
    Context context;
    List<itempager1> listpager6;

    public Adapterpager6(Context context, List<itempager1> listpager6) {
        this.context = context;
        this.listpager6 = listpager6;
    }


    @Override
    public int getCount() {
        return listpager6.size();


    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == o);

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.item_pager1, container, false);
        final TextView tests1 = (TextView) view.findViewById(R.id.texts1);
        final TextView tests2 = (TextView) view.findViewById(R.id.texts2);
        tests1.setText(listpager6.get(position).getTexts1());
        tests2.setText(listpager6.get(position).getTexts2());
        final ImageView play = (ImageView) view.findViewById(R.id.play);
        final MaterialIconView minus = (MaterialIconView) view.findViewById(R.id.minus);
        MaterialIconView plus = (MaterialIconView) view.findViewById(R.id.plus);
        MaterialIconView share = (MaterialIconView) view.findViewById(R.id.share);
        MaterialIconView starts = (MaterialIconView) view.findViewById(R.id.stars);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c > 13) {
                    c--;
                } else
                    Toast.makeText(context, "لايمكن تصغير الخط اصغر من ذلك", Toast.LENGTH_SHORT).show();
                tests1.setTextSize(c);
                tests2.setTextSize(c);

            }


        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c < 50) {
                    c++;
                } else
                    Toast.makeText(context, "لايمكن تكبير الخط اكبر من ذلك", Toast.LENGTH_SHORT).show();
                tests1.setTextSize(c);
                tests2.setTextSize(c);

            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, " تطبيق طريق المسلم - MuslimRoad ");
                sendIntent.putExtra(Intent.EXTRA_TEXT, listpager6.get(position).getTexts1() + "\n" + listpager6.get(position).getTexts2() + "\n" + "مشاركه نصوص من تطبيق'طريق المسلم_MuslimRoad  \n" + "\n" + "\n" + " https://t.co/IuFGow3uyK\n");
                sendIntent.setType("text/plain");
                context.startActivity(Intent.createChooser(sendIntent, "مشاركه تطبيق طريق المسلم - MuslimRoad:"));
                Toast.makeText(context, "جزاك الله خيرا لمشاركه التطبيق", Toast.LENGTH_SHORT).show();

            }
        });


        starts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/IuFGow3uyK"));
                context.startActivity(intent);


            }
        });

        container.addView(view);

        return view;
    }
}