package com.example.pokedex;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;


public class homefragment extends Fragment {

    private Button birdsbutton;
    private Button animalssbutton;
    private Button inscetsbutton;
    private Button reptilesbutton;
    private Button marinesbutton;
    private Button plantsbutton;

    androidx.gridlayout.widget.GridLayout gridlayout;


    public homefragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homefragment, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        birdsbutton = view.findViewById(R.id.BirdsButtom);
        animalssbutton = view.findViewById(R.id.AnimalsButton);
        inscetsbutton = view.findViewById(R.id.InscetsButton);
        reptilesbutton = view.findViewById(R.id.ReptilesButton);
        marinesbutton = view.findViewById(R.id.MarinesButton);
        plantsbutton = view.findViewById(R.id.PlantsButton);

        gridlayout = view.findViewById(R.id.gridLayout);
        gridlayout.setBackgroundResource(R.drawable.gradient_files);
        AnimationDrawable animationDrawable = (AnimationDrawable)gridlayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        birdsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),CardViewListActivity.class));
            }
        });

        animalssbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        inscetsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        reptilesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        marinesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        plantsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }





}
