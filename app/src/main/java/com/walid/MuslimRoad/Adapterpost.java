package com.walid.MuslimRoad;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapterpost extends RecyclerView.Adapter<Adapterpost.holder> {
    List<item_post> listpost;
    Context context;

    public Adapterpost(List<item_post> listpost, Context context) {
        this.listpost = listpost;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_posts,viewGroup,false);
        return new holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull holder  holder, final int possition) {
        holder.textunderimage.setText(listpost.get(possition).getTextunderimage());
        Picasso.get().load(listpost.get(possition).getImge()).into(holder.imgeturi);
       holder.cards.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(context,Maintitlepost.class);
               intent.putExtra("textmove",listpost.get(possition).getTextheder());
               intent.putExtra("title",listpost.get(possition).getTitle());
               intent.putExtra("imgeturi",listpost.get(possition).getImge());
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return listpost.size();
    }

    public class holder extends RecyclerView.ViewHolder{
        CardView cards;
        TextView textunderimage;
        ImageView imgeturi;
        public holder(@NonNull View itemView) {
            super(itemView);
            imgeturi=(ImageView)itemView.findViewById(R.id.imge);
            cards=(CardView) itemView.findViewById(R.id.cardss);
            textunderimage=(TextView) itemView.findViewById(R.id.textunderimage);

        }
    }
}
