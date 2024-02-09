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

public class Adaptermaincard1 extends RecyclerView.Adapter<Adaptermaincard1.holdermaincard1> {
    Context context;
    List<item_maincard1>listmaincard1;

    public Adaptermaincard1(Context context, List<item_maincard1> listmaincard1) {
        this.context = context;
        this.listmaincard1 = listmaincard1;
    }

    @NonNull
    @Override
    public holdermaincard1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_maincard1,viewGroup,false);
        return   new holdermaincard1(view);

    }

    @Override
    public void onBindViewHolder(@NonNull holdermaincard1 holder, final int position) {
        holder.text.setText(listmaincard1.get(position).getText());
        holder.number.setText(listmaincard1.get(position).getNumber());
        holder.card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Maintitle2.class);
                intent.putExtra("text",listmaincard1.get(position).getText());
                intent.putExtra("title",listmaincard1.get(position).getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listmaincard1.size();
    }

    public class holdermaincard1 extends RecyclerView.ViewHolder{

TextView text,number;
CardView card1;
        public holdermaincard1(@NonNull View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.text);
            number=(TextView)itemView.findViewById(R.id.number);
            card1=(CardView)itemView.findViewById(R.id.card1);
        }
    }
}
