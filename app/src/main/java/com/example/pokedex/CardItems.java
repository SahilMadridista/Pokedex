package com.example.pokedex;

public class CardItems {
    private int image;
    private String text1;

    public CardItems(int imageRes, String text){
        image=imageRes;
        text1=text;
    }
    public int getImage(){
        return image;
    }
    public String getText1(){
        return text1;
    }

}
