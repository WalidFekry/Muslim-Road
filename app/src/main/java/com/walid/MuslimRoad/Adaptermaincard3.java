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

public class Adaptermaincard3 extends RecyclerView.Adapter<Adaptermaincard3.holder3> {
    Context context;
    List<item_maincard2> listmaincard3;

    public Adaptermaincard3(Context context, List<item_maincard2> listmaincard3) {
        this.context = context;
        this.listmaincard3 = listmaincard3;
    }

    @NonNull
    @Override
    public holder3 onCreateViewHolder(@NonNull ViewGroup viewGroup, int positon) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_maincard3,viewGroup,false);
        return new holder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final holder3 holder3, final int position) {
        holder3.number.setText(listmaincard3.get(position).getNumber());
        holder3.text.setText(listmaincard3.get(position).getText());
      holder3.card3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(context,Maintitle4.class);
              intent.putExtra("texttitle",listmaincard3.get(position).getTitle());
              intent.putExtra("textheader",listmaincard3.get(position).getText());
              context.startActivity(intent);

          }
      });


    }

    @Override
    public int getItemCount() {
        return listmaincard3.size();
    }

    public class holder3 extends RecyclerView.ViewHolder{
        TextView text,number;
        CardView card3;
        public holder3(@NonNull View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.text2);
            number=(TextView)itemView.findViewById(R.id.number2);
            card3=(CardView)itemView.findViewById(R.id.card3);

        }
    }
}