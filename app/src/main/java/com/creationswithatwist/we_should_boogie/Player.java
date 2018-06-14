package com.creationswithatwist.we_should_boogie;

import java.lang.reflect.Array;
import java.util.Random;

public class Player {

    public String name;
    private String[] Adjective = new String[]{"Cute", "Cuddly", "Sweet", "Tough", "Funny"};

    public Player (String name, int i) {
        this.name = this.Adjective[i] + " " + name;
    }

}
