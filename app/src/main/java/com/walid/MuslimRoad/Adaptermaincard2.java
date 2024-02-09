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

public class Adaptermaincard2 extends RecyclerView.Adapter<Adaptermaincard2.holder2> {
    Context context;
    List<item_maincard2>listmaincard2;

    public Adaptermaincard2(Context context, List<item_maincard2> listmaincard2) {
        this.context = context;
        this.listmaincard2 = listmaincard2;
    }

    @NonNull
    @Override
    public holder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int positon) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_maincard2,viewGroup,false);
        return new holder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder2 holder2, final int position) {
        holder2.number.setText(listmaincard2.get(position).getNumber());
        holder2.text.setText(listmaincard2.get(position).getText());
        holder2.card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Maintitle3.class);
                intent.putExtra("text3",listmaincard2.get(position).getText());
                intent.putExtra("title3",listmaincard2.get(position).getTitle());
                   context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listmaincard2.size();
    }

    public class holder2 extends RecyclerView.ViewHolder{
TextView text,number;
CardView card2;
        public holder2(@NonNull View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.text2);
            number=(TextView)itemView.findViewById(R.id.number2);
            card2=(CardView)itemView.findViewById(R.id.card2);

        }
    }
}
