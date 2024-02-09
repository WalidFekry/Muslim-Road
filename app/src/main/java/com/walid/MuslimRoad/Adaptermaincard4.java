package com.walid.MuslimRoad;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adaptermaincard4 extends RecyclerView.Adapter<Adaptermaincard4.holder4> {
    Context context;
    List<item_maincard2> listmaincard4;

    public Adaptermaincard4(Context context, List<item_maincard2> listmaincard4) {
        this.context = context;
        this.listmaincard4 = listmaincard4;
    }

    @NonNull
    @Override
    public holder4 onCreateViewHolder(@NonNull ViewGroup viewGroup, int positon) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_maincard1,viewGroup,false);
        return new holder4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder4 holder2, final int position) {
        holder2.number.setText(listmaincard4.get(position).getNumber());
        holder2.text.setText(listmaincard4.get(position).getText());
        holder2.card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Maintitle3.class);
                intent.putExtra("text3",listmaincard4.get(position).getText());
                intent.putExtra("title3",listmaincard4.get(position).getTitle());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listmaincard4.size();
    }

    public class holder4 extends RecyclerView.ViewHolder{
        TextView text,number;
        CardView card1;
        public holder4(@NonNull View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.text);
            number=(TextView)itemView.findViewById(R.id.number);
            card1=(CardView)itemView.findViewById(R.id.card1);

        }
    }
}
