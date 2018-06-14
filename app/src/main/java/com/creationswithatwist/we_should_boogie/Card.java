package com.creationswithatwist.we_should_boogie;

public class Card {

    private String color;
    private String Action;
    public Card(String color) {
        this.color = color;

        if(color == "black"){
            Action = "cool";
        } else {
            Action = "uncool";
        }
    }

    public String getAction(){
       // return Action;
        return Action;
    }
}
