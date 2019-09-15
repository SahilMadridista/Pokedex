package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CardViewListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_list);

        ArrayList<CardItems> cardItemsList=new ArrayList<>();
        cardItemsList.add(new CardItems(R.drawable.lol,"Bird1"));
        cardItemsList.add(new CardItems(R.drawable.lol,"Bird2"));
        cardItemsList.add(new CardItems(R.drawable.lol,"Bird3"));
        cardItemsList.add(new CardItems(R.drawable.lol,"Bird4"));
        cardItemsList.add(new CardItems(R.drawable.lol,"Bird5"));
        cardItemsList.add(new CardItems(R.drawable.lol,"Bird6"));
        cardItemsList.add(new CardItems(R.drawable.lol,"Bird7"));
        cardItemsList.add(new CardItems(R.drawable.lol,"Bird8"));

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        adapter=new RVAdapter(cardItemsList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
