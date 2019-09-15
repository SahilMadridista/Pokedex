package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class CardViewListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    RelativeLayout RecyclerViewRelativeLayout;

    androidx.appcompat.widget.Toolbar toolbarthree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_list);

        RecyclerViewRelativeLayout = (RelativeLayout)findViewById(R.id.recyclerview_relativelayout);
        RecyclerViewRelativeLayout.setBackgroundResource(R.drawable.gradient_files);
        AnimationDrawable animationDrawable = (AnimationDrawable)RecyclerViewRelativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        toolbarthree =findViewById(R.id.toolbarofcardview);
        toolbarthree.setTitle("Check out these species");
        setSupportActionBar(toolbarthree);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
//        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener() {
//            @Override
//            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
//
//            }
//        });
    }
}
