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

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapterbook extends RecyclerView.Adapter<Adapterbook.holder> {
    List<item_book> listbooks;
    Context context;

    public Adapterbook(List<item_book> listbooks, Context context) {
        this.listbooks = listbooks;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_book,viewGroup,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, final int pposition) {
        Picasso.get().load(listbooks.get(pposition).getImgebook()).into(holder.imagebooks);
        holder.cardsbooks.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent =new Intent(context,Mainbook2.class);
               intent.putExtra("imgebook",listbooks.get(pposition).getImgebook());
               intent.putExtra("namebook",listbooks.get(pposition).getNamebook());
               intent.putExtra("bookread",listbooks.get(pposition).getBookread());
               intent.putExtra("bookdownlod",listbooks.get(pposition).getBookdownlod());
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount() {
        return listbooks.size();
    }

    public class holder extends RecyclerView.ViewHolder{
        ImageView imagebooks;
        CardView cardsbooks;
        public holder(@NonNull View itemView) {
            super(itemView);
            imagebooks=(ImageView)itemView.findViewById(R.id.imagebookrecycler);
            cardsbooks=(CardView)itemView.findViewById(R.id.cardsbookss);
        }
    }
}
