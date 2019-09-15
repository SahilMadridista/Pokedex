package com.example.pokedex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolder> {
    private ArrayList<CardItems> mCardItemsList;

    public static class RVViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView1;

        public RVViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView1=itemView.findViewById(R.id.text1);
        }
    }

    public RVAdapter(ArrayList<CardItems> cardItems){
        mCardItemsList =cardItems;
    }

    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        RVViewHolder rvViewHolder=new RVViewHolder(v);
        return rvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolder holder, int position) {
        CardItems currentItem= mCardItemsList.get(position);

        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView1.setText(currentItem.getText1());

    }

    @Override
    public int getItemCount() {
        return mCardItemsList.size();
    }
}
